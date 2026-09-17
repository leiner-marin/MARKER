package application.domain.ports;

import application.domain.models.Order;
import application.domain.models.Product;
import java.util.List;

public interface CartPort {
    Order addProduct(Order cart, Product product);
    Order removeProduct(Order cart, Product product);
    Order clearCart(Order cart);
    List<Product> getProductsInCart(Order cart);
}
