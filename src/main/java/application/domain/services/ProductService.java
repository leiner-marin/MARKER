package application.domain.services;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;

public class ProductService {
    public Product register(Product product) {
        validate(product);
        if (product.getStatus() == null) {
            product.setStatus(ProductStatus.PUBLISHED);
        }
        return product;
    }

    public void validate(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (product.getName() == null || product.getName().isBlank()) {
            throw new IllegalArgumentException("Product name is required.");
        }
        if (product.getSeller() == null || product.getSeller().getId() == null) {
            throw new IllegalArgumentException("Seller is required.");
        }
        if (product.getProductType() == null) {
            throw new IllegalArgumentException("Product type is required.");
        }
    }
}
