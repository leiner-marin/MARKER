package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Buyer;
import application.domain.enums.CommercialStatus;
import org.junit.jupiter.api.Test;

class BuyerServiceTest {
    private final BuyerService buyerService = new BuyerService();

    @Test
    void registersBuyerWithActiveCommercialStatus() {
        Buyer buyer = new Buyer();
        buyer.setIdentityDocument("2001");
        buyer.setFullName("Test Buyer");
        buyer.setEmail("buyer@example.com");
        buyer.setPrimaryAddress("Main Street 1");

        Buyer result = buyerService.register(buyer);

        assertEquals(CommercialStatus.ACTIVE, result.getCommercialStatus());
    }

    @Test
    void rejectsBuyerWithoutPrimaryAddress() {
        Buyer buyer = new Buyer();
        buyer.setIdentityDocument("2002");
        buyer.setFullName("Test Buyer");
        buyer.setEmail("buyer@example.com");

        assertThrows(IllegalArgumentException.class, () -> buyerService.register(buyer));
    }
}
