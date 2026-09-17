package application.domain.services;

import application.domain.models.Buyer;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    public Buyer registerBuyer(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (buyer.getEmail() == null || buyer.getEmail().isBlank()) {
            throw new IllegalArgumentException("Buyer email is required.");
        }
        if (buyer.getCommercialStatus() == null || buyer.getCommercialStatus().isBlank()) {
            buyer.setCommercialStatus("ACTIVE");
        }
        return buyer;
    }

    public Buyer addAddress(Buyer buyer, String newAddress) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (newAddress == null || newAddress.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        if (buyer.getAdditionalAddresses() == null) {
            buyer.setAdditionalAddresses(new ArrayList<>());
        }
        buyer.getAdditionalAddresses().add(newAddress);
        return buyer;
    }

    public String getCommercialStatus(Buyer buyer) {
        if (buyer == null) {
            return "UNKNOWN";
        }
        return buyer.getCommercialStatus() == null ? "UNKNOWN" : buyer.getCommercialStatus();
    }

    public Buyer updateCommercialStatus(Buyer buyer, String newStatus) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        buyer.setCommercialStatus(newStatus);
        return buyer;
    }
}
