package application.domain.services;

import application.domain.models.Product;
import application.domain.models.Seller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product registerProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (product.getStatus() == null || product.getStatus().isBlank()) {
            product.setStatus("DRAFT");
        }
        return product;
    }

    public Product assignVariants(Product product, List<String> variants) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (variants == null) {
            product.setVariants(new ArrayList<>());
            return product;
        }
        product.setVariants(variants);
        return product;
    }

    public Product publishProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus("PUBLISHED");
        return product;
    }

    public Product suspendProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus("SUSPENDED");
        return product;
    }

    public Product discontinueProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus("DISCONTINUED");
        return product;
    }

    public List<Product> getCatalog(Seller seller) {
        if (seller == null || seller.getProductCatalog() == null) {
            return new ArrayList<>();
        }
        return seller.getProductCatalog();
    }
}
