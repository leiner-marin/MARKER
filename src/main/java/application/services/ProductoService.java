package application.services;

import application.ports.out.ProductRepository;
import application.domain.entities.Product;
import application.domain.entities.Seller;
import application.domain.enums.ProductStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductRepository productRepository;

    public ProductoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (product.getStatus() == null) {
            product.setStatus(ProductStatus.DRAFT);
        }
        return productRepository.save(product);
    }

    public Product assignVariants(Product product, List<String> variants) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (variants == null) {
            product.setVariants(new ArrayList<>());
            return persist(product);
        }
        product.setVariants(variants);
        return persist(product);
    }

    public Product publishProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus(ProductStatus.PUBLISHED);
        return persist(product);
    }

    public Product suspendProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus(ProductStatus.SUSPENDED);
        return persist(product);
    }

    public Product discontinueProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        product.setStatus(ProductStatus.DISCONTINUED);
        return persist(product);
    }

    public List<Product> getCatalog(Seller seller) {
        if (seller == null) {
            return new ArrayList<>();
        }
        if (seller.getId() != null) {
            return productRepository.findBySellerId(seller.getId());
        }
        if (seller.getProductCatalog() == null) {
            return new ArrayList<>();
        }
        return seller.getProductCatalog();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found."));
    }

    private Product persist(Product product) {
        return product.getId() == null
                ? productRepository.save(product)
                : productRepository.update(product);
    }
}

