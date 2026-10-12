package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Product;
import application.domain.entities.Seller;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    private final ProductService productService = new ProductService();

    @Test
    void registersValidProductAsSuspendedUntilPublication() {
        Product product = new Product();
        product.setName("Keyboard");
        product.setProductType(ProductType.PHYSICAL);
        Seller seller = new Seller();
        seller.setId(1L);
        product.setSeller(seller);

        Product result = productService.register(product);

        assertEquals("Keyboard", result.getName());
        assertEquals(ProductType.PHYSICAL, result.getProductType());
        assertEquals(ProductStatus.SUSPENDED, result.getStatus());
    }

    @Test
    void rejectsProductWithoutSeller() {
        Product product = new Product();
        product.setName("Keyboard");
        product.setProductType(ProductType.PHYSICAL);

        assertThrows(IllegalArgumentException.class, () -> productService.register(product));
    }
}
