package application.adapters.useCases;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Product;
import application.domain.ports.in.ManageCartUseCase;
import application.domain.ports.out.CartRepositoryPort;
import application.domain.services.CartService;

public class DefaultCartUseCase implements ManageCartUseCase {
    private final CartRepositoryPort cartRepositoryPort;
    private final CartService cartService;

    public DefaultCartUseCase(CartRepositoryPort cartRepositoryPort, CartService cartService) {
        this.cartRepositoryPort = cartRepositoryPort;
        this.cartService = cartService;
    }

    @Override
    public Cart addProduct(Buyer buyer, Product product) {
        Cart cart = getOrCreate(buyer);
        return cartRepositoryPort.saveOrUpdate(cartService.addProduct(cart, product));
    }

    @Override
    public Cart removeProduct(Buyer buyer, Product product) {
        Cart cart = getOrCreate(buyer);
        return cartRepositoryPort.saveOrUpdate(cartService.removeProduct(cart, product));
    }

    @Override
    public Cart clear(Buyer buyer) {
        Cart cart = getOrCreate(buyer);
        return cartRepositoryPort.saveOrUpdate(cartService.clear(cart));
    }

    private Cart getOrCreate(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        return cartRepositoryPort.findByBuyer(buyer)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setBuyer(buyer);
                    return cart;
                });
    }
}
