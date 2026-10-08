package application.adapters.useCases;

import application.domain.exceptions.ProductValidationException;
import application.domain.models.ProductModel;
import application.domain.ports.in.PublishProductUseCase;
import application.domain.ports.in.RegisterProductUseCase;
import application.domain.ports.out.ProductPort;

public class DefaultProductUseCase implements RegisterProductUseCase, PublishProductUseCase {
    private final ProductPort productPort;

    public DefaultProductUseCase(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public ProductModel register(ProductModel product) {
        if (product == null) {
            throw new ProductValidationException("Product cannot be null.");
        }
        if (product.getName() == null || product.getName().isBlank()) {
            throw new ProductValidationException("Product name is required.");
        }
        if (product.getSellerId() == null || product.getSellerId().isBlank()) {
            throw new ProductValidationException("Seller is required to register the product.");
        }
        return productPort.save(product);
    }

    @Override
    public ProductModel publish(Long productId) {
        if (productId == null) {
            throw new ProductValidationException("Product id is required.");
        }
        ProductModel product = productPort.findById(productId)
                .orElseThrow(() -> new ProductValidationException("Product not found."));
        product.setStatus("PUBLISHED");
        return productPort.update(product);
    }
}
