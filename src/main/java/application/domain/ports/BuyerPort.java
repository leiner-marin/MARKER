package application.domain.ports;

import application.domain.models.Buyer;

public interface BuyerPort {
    Buyer registerBuyer(Buyer buyer);
    Buyer addAddress(Buyer buyer, String newAddress);
    String getCommercialStatus(Buyer buyer);
    Buyer updateCommercialStatus(Buyer buyer, String newStatus);
}
