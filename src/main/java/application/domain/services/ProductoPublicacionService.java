package application.domain.services;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;

public class ProductoPublicacionService {

    public Product publicarProducto(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus(ProductStatus.PUBLISHED);
        return product;
    }

    public Product retirarPublicacion(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus(ProductStatus.DRAFT);
        return product;
    }

    public Product suspenderProducto(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus(ProductStatus.SUSPENDED);
        return product;
    }
}
