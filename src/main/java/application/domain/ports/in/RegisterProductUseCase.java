package application.domain.ports.in;

import application.domain.entities.Product;

public interface RegisterProductUseCase {
    Product register(Product product);
}
