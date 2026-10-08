package application.domain.ports.in;

import application.domain.models.ProductModel;

public interface RegisterProductUseCase {
    ProductModel register(ProductModel product);
}
