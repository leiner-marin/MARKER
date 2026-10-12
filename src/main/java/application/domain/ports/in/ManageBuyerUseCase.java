package application.domain.ports.in;

import application.domain.entities.Buyer;

public interface ManageBuyerUseCase {
    Buyer update(Buyer buyer);
    Buyer findById(Long id);
    Buyer addAddress(Long buyerId, String address);
}
