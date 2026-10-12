package application.adapters.useCases;

import application.domain.entities.Product;
import application.domain.exceptions.ProductValidationException;
import application.domain.ports.in.ManageProductUseCase;
import application.domain.ports.in.PublishProductUseCase;
import application.domain.ports.in.RegisterProductUseCase;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.services.ProductPublicationService;
import application.domain.services.ProductService;
import application.domain.services.ProductVariantService;
import java.util.List;
import java.util.Optional;

public class DefaultProductUseCase implements RegisterProductUseCase, PublishProductUseCase, ManageProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final ProductService productService;
    private final ProductPublicationService publicationService;
    private final ProductVariantService variantService;

    public DefaultProductUseCase(
            ProductRepositoryPort productRepositoryPort,
            ProductService productService,
            ProductPublicationService publicationService,
            ProductVariantService variantService) {
        this.productRepositoryPort = productRepositoryPort;
        this.productService = productService;
        this.publicationService = publicationService;
        this.variantService = variantService;
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
        Product normalized = productService.register(product);
        if (normalized.getVariants() != null) {
            List<String> variants = List.copyOf(normalized.getVariants());
            normalized.setVariants(new java.util.ArrayList<>());
            for (String variant : variants) {
                variantService.addVariant(normalized, variant);
            }
        }
        if (normalized.getStatus() == null) {
            normalized.setStatus(application.domain.enums.ProductStatus.PUBLISHED);
        }
        return productRepositoryPort.save(normalized);
    }

    @Override
    public Product publish(Long productId) {
        Product product = findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        return productRepositoryPort.update(publicationService.publish(product));
    }

    @Override
    public Product suspend(Long productId) {
        Product product = findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        return productRepositoryPort.update(publicationService.suspend(product));
    }

    @Override
    public Product discontinue(Long productId) {
        Product product = findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        return productRepositoryPort.update(publicationService.discontinue(product));
    }

    @Override
    public Product addVariant(Long productId, String variant) {
        Product product = findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        return productRepositoryPort.update(variantService.addVariant(product, variant));
    }
}
