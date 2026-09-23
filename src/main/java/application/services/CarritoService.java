package application.services;

import application.domain.entities.Order;
import application.domain.entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    public Order addProduct(Order cart, Product product) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null.");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (cart.getProducts() == null) {
            cart.setProducts(new ArrayList<>());
        }
        cart.getProducts().add(product);
        return cart;
    }

    public Order removeProduct(Order cart, Product product) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null.");
        }
        if (cart.getProducts() == null) {
            return cart;
        }
        cart.getProducts().remove(product);
        return cart;
    }

    public Order clearCart(Order cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null.");
        }
        cart.setProducts(new ArrayList<>());
        return cart;
    }

    public List<Product> getProductsInCart(Order cart) {
        if (cart == null || cart.getProducts() == null) {
            return new ArrayList<>();
        }
        return cart.getProducts();
    }
}

