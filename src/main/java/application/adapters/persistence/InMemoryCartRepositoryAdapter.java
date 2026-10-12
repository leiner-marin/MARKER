package application.adapters.persistence;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.ports.out.CartRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryCartRepositoryAdapter implements CartRepositoryPort {
    private final Map<Long, Cart> carts = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Cart save(Cart cart) {
        validate(cart);
        if (cart.getId() == null) {
            cart.setId(nextId.getAndIncrement());
        }
        carts.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public Cart update(Cart cart) {
        validate(cart);
        if (cart.getId() == null || !carts.containsKey(cart.getId())) {
            throw new IllegalArgumentException("Cart must exist before it can be updated.");
        }
        carts.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(carts.get(id));
    }

    @Override
    public Optional<Cart> findByBuyer(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            return Optional.empty();
        }
        return carts.values().stream()
                .filter(cart -> cart.getBuyer() != null
                        && buyer.getId().equals(cart.getBuyer().getId()))
                .findFirst();
    }

    private void validate(Cart cart) {
        if (cart == null || cart.getBuyer() == null || cart.getBuyer().getId() == null) {
            throw new IllegalArgumentException("Cart buyer is required.");
        }
    }
}
