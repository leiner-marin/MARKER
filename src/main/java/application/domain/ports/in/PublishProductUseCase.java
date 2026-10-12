package application.domain.ports.in;

import application.domain.entities.Product;

public interface PublishProductUseCase {
    Product publish(Long productId);
}
