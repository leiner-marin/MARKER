package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Product;
import org.junit.jupiter.api.Test;

class CartServiceTest {
    private final CartService service = new CartService();

    @Test
    void addsRemovesAndClearsProducts() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Cart cart = new Cart();
        cart.setBuyer(buyer);

        Product product = new Product();
        product.setId(1L);

        service.addProduct(cart, product);
        assertEquals(1, cart.getProducts().size());

        service.removeProduct(cart, product);
        assertEquals(0, cart.getProducts().size());

        service.addProduct(cart, product);
        service.clear(cart);
        assertEquals(0, cart.getProducts().size());
    }
}
