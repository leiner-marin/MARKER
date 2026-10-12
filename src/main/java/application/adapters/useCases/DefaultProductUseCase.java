package application.adapters.useCases;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;
import application.domain.exceptions.ProductValidationException;
import application.domain.ports.in.ManageProductUseCase;
import application.domain.ports.in.PublishProductUseCase;
import application.domain.ports.in.RegisterProductUseCase;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.services.ProductPublicationService;
import application.domain.services.ProductService;
import java.util.List;
import java.util.Optional;

public class DefaultProductUseCase implements RegisterProductUseCase, PublishProductUseCase, ManageProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final ProductService productService;
    private final ProductPublicationService publicationService;

    public DefaultProductUseCase(
            ProductRepositoryPort productRepositoryPort,
            ProductService productService,
            ProductPublicationService publicationService) {
        this.productRepositoryPort = productRepositoryPort;
        this.productService = productService;
        this.publicationService = publicationService;
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
        return productRepositoryPort.save(productService.register(product));
    }

    @Override
    public Product publish(Long productId) {
        Product product = findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        return productRepositoryPort.update(publicationService.publish(product));
    }
}
