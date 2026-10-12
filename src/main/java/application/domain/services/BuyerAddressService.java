package application.domain.services;

import application.domain.entities.Buyer;
import java.util.ArrayList;

public class BuyerAddressService {
    public Buyer addAddress(Buyer buyer, String address) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is required.");
        }
        if (buyer.getAdditionalAddresses() == null) {
            buyer.setAdditionalAddresses(new ArrayList<>());
        }
        if (!buyer.getAdditionalAddresses().contains(address)) {
            buyer.getAdditionalAddresses().add(address);
        }
        return buyer;
    }
}
