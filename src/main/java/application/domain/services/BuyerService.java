package application.domain.services;

import application.domain.entities.Buyer;
import application.domain.enums.CommercialStatus;

public class BuyerService {
    public Buyer register(Buyer buyer) {
        validate(buyer);
        if (buyer.getCommercialStatus() == null) {
            buyer.setCommercialStatus(CommercialStatus.ACTIVE);
        }
        return buyer;
    }

    public void validate(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (buyer.getFullName() == null || buyer.getFullName().isBlank()) {
            throw new IllegalArgumentException("Buyer full name is required.");
        }
        if (buyer.getEmail() == null || buyer.getEmail().isBlank()) {
            throw new IllegalArgumentException("Buyer email is required.");
        }
        if (buyer.getPrimaryAddress() == null || buyer.getPrimaryAddress().isBlank()) {
            throw new IllegalArgumentException("Buyer primary address is required.");
        }
    }
}
