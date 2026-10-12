package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Seller;
import application.domain.enums.SellerStatus;
import application.domain.enums.UserRole;
import org.junit.jupiter.api.Test;

class SellerServiceTest {
    private final SellerService service = new SellerService();

    @Test
    void registersSellerWithRoleAndActiveStatus() {
        Seller seller = new Seller();
        seller.setFullName("Test Seller");
        seller.setEmail("seller@example.com");

        Seller result = service.register(seller);

        assertEquals(UserRole.SELLER, result.getRole());
        assertEquals(SellerStatus.ACTIVE, result.getSellerStatus());
        assertNotNull(result.getIncorporationDate());
    }

    @Test
    void rejectsSellerWithoutEmail() {
        Seller seller = new Seller();
        seller.setFullName("Test Seller");

        assertThrows(IllegalArgumentException.class, () -> service.register(seller));
    }
}
