package application.domain.ports.in;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Product;

public interface ManageCartUseCase {
    Cart addProduct(Buyer buyer, Product product);
    Cart removeProduct(Buyer buyer, Product product);
    Cart clear(Buyer buyer);
}
