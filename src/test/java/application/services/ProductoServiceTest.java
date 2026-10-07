package application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;
import application.infrastructure.repositories.InMemoryProductRepository;
import org.junit.jupiter.api.Test;

class ProductoServiceTest {
    private final ProductoService productService =
            new ProductoService(new InMemoryProductRepository());

    @Test
    void registersAndUpdatesProductThroughRepository() {
        Product product = new Product();
        product.setName("Keyboard");

        Product registered = productService.registerProduct(product);
        productService.publishProduct(registered);

        assertNotNull(registered.getId());
        assertEquals(ProductStatus.PUBLISHED, productService.getProduct(registered.getId()).getStatus());
    }

    @Test
    void publishesNewProductWithoutRequiringAnExistingId() {
        Product product = new Product();

        Product published = productService.publishProduct(product);

        assertNotNull(published.getId());
        assertEquals(ProductStatus.PUBLISHED, published.getStatus());
    }
}
