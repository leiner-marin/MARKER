package application.adapters.persistence;

import application.domain.entities.Seller;
import application.domain.ports.out.SellerRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemorySellerRepositoryAdapter implements SellerRepositoryPort {
    private final Map<Long, Seller> sellers = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Seller save(Seller seller) {
        validate(seller);
        if (seller.getId() == null) {
            seller.setId(nextId.getAndIncrement());
        }
        sellers.put(seller.getId(), seller);
        return seller;
    }

    @Override
    public Seller update(Seller seller) {
        validate(seller);
        if (seller.getId() == null || !sellers.containsKey(seller.getId())) {
            throw new IllegalArgumentException("Seller must exist before it can be updated.");
        }
        sellers.put(seller.getId(), seller);
        return seller;
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(sellers.get(id));
    }

    @Override
    public List<Seller> findAll() {
        return new ArrayList<>(sellers.values());
    }

    private void validate(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
    }
}
