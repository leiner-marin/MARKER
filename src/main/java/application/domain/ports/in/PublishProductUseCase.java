package application.domain.ports.in;

import application.domain.models.ProductModel;

public interface PublishProductUseCase {
    ProductModel publish(Long productId);
}
