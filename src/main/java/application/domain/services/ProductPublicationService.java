package application.domain.services;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;

public class ProductPublicationService {
    public Product publish(Product product) {
        validate(product);
        if (product.getStatus() == ProductStatus.DISCONTINUED) {
            throw new IllegalStateException("A discontinued product cannot be published.");
        }
        product.setStatus(ProductStatus.PUBLISHED);
        return product;
    }

    public Product suspend(Product product) {
        validate(product);
        if (product.getStatus() == ProductStatus.DISCONTINUED) {
            throw new IllegalStateException("A discontinued product cannot be suspended.");
        }
        product.setStatus(ProductStatus.SUSPENDED);
        return product;
    }

    public Product discontinue(Product product) {
        validate(product);
        product.setStatus(ProductStatus.DISCONTINUED);
        return product;
    }

    private void validate(Product product) {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Product with id is required.");
        }
    }
}
