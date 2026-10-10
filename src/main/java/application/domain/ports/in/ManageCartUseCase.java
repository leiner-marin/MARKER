package application.domain.ports.in;

import application.domain.entities.Buyer;
import application.domain.entities.Product;
import application.domain.entities.Order;

public interface ManageCartUseCase {
    Order addProduct(Buyer buyer, Product product);
    Order removeProduct(Buyer buyer, Product product);
    Order clear(Buyer buyer);
}
