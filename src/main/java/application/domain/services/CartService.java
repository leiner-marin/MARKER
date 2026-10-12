package application.domain.services;

import application.domain.entities.Cart;
import application.domain.entities.Product;
import java.util.ArrayList;

public class CartService {

    public Cart addProduct(Cart cart, Product product) {
        validate(cart, product);
        if (cart.getProducts() == null) {
            cart.setProducts(new ArrayList<>());
        }
        if (!cart.getProducts().contains(product)) {
            cart.getProducts().add(product);
        }
        return cart;
    }

    public Cart removeProduct(Cart cart, Product product) {
        validate(cart, product);
        if (cart.getProducts() != null) {
            cart.getProducts().remove(product);
        }
        return cart;
    }

    public Cart clear(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null.");
        }
        cart.setProducts(new ArrayList<>());
        return cart;
    }

    private void validate(Cart cart, Product product) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null.");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
    }
}
