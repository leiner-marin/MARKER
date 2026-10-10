package application.adapters.useCases;

import application.domain.entities.Product;
import application.domain.exceptions.ProductValidationException;
import application.domain.ports.in.ManageProductUseCase;
import application.domain.ports.in.PublishProductUseCase;
import application.domain.ports.in.RegisterProductUseCase;
import java.util.List;
import java.util.Optional;
import application.domain.ports.out.ProductRepositoryPort;

public class DefaultProductUseCase implements RegisterProductUseCase, PublishProductUseCase, ManageProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public DefaultProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<Product> findAll() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        if (id == null) {
            throw new ProductValidationException("Product id is required.");
        }
        return productRepositoryPort.findById(id);
    }

    @Override
    public Product register(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product cannot be null.");
        }
        if (product.getName() == null || product.getName().isBlank()) {
            throw new ProductValidationException("Product name is required.");
        }
        if (product.getSeller() == null || product.getSeller().getId() == null) {
            throw new ProductValidationException("Seller is required to register the product.");
        }
        return productRepositoryPort.save(product);
    }

    @Override
    public Product publish(Long productId) {
        if (productId == null) {
            throw new ProductValidationException("Product id is required.");
        }
        Product product = productRepositoryPort.findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        if (product.getStatus() != null && product.getStatus().name().equals("DISCONTINUED")) {
            throw new ProductValidationException("A discontinued product cannot be published.");
        }
        product.setStatus(application.domain.enums.ProductStatus.PUBLISHED);
        return productRepositoryPort.update(product);
    }
}
