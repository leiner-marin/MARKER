package application.domain.services;

import application.domain.entities.Product;
import java.util.ArrayList;

public class ProductVariantService {
    public Product addVariant(Product product, String variant) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (variant == null || variant.isBlank()) {
            throw new IllegalArgumentException("Variant is required.");
        }
        if (product.getVariants() == null) {
            product.setVariants(new ArrayList<>());
        }
        if (!product.getVariants().contains(variant)) {
            product.getVariants().add(variant);
        }
        return product;
    }
}
