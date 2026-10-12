package application.domain.services;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;
import java.util.List;

public class CatalogService {
    public List<Product> publishedProducts(List<Product> products) {
        if (products == null) {
            return List.of();
        }
        return products.stream()
                .filter(product -> product != null && product.getStatus() == ProductStatus.PUBLISHED)
                .toList();
    }
}
