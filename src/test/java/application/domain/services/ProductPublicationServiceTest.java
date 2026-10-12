package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Product;
import application.domain.enums.ProductStatus;
import org.junit.jupiter.api.Test;

class ProductPublicationServiceTest {
    private final ProductPublicationService service = new ProductPublicationService();

    @Test
    void changesPublicationState() {
        Product product = new Product();

        service.suspend(product);
        assertEquals(ProductStatus.SUSPENDED, product.getStatus());

        service.publish(product);
        assertEquals(ProductStatus.PUBLISHED, product.getStatus());
    }

    @Test
    void rejectsPublishingDiscontinuedProduct() {
        Product product = new Product();
        product.setStatus(ProductStatus.DISCONTINUED);

        assertThrows(IllegalStateException.class, () -> service.publish(product));
    }
}
