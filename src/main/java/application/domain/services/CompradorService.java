package application.services;

import application.domain.entities.Buyer;
import application.domain.enums.CommercialStatus;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CompradorService {

    public Buyer registerBuyer(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (buyer.getEmail() == null || buyer.getEmail().isBlank()) {
            throw new IllegalArgumentException("Buyer email is required.");
        }
        if (buyer.getCommercialStatus() == null) {
            buyer.setCommercialStatus(CommercialStatus.ACTIVE);
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

    public CommercialStatus getCommercialStatus(Buyer buyer) {
        if (buyer == null) {
            return CommercialStatus.UNKNOWN;
        }
        return buyer.getCommercialStatus() == null
                ? CommercialStatus.UNKNOWN
                : buyer.getCommercialStatus();
    }

    public Buyer updateCommercialStatus(Buyer buyer, CommercialStatus newStatus) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("Commercial status is required.");
        }
        buyer.setCommercialStatus(newStatus);
        return buyer;
    }
}

