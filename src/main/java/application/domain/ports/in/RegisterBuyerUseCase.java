package application.domain.ports.in;

import application.domain.entities.Buyer;

public interface RegisterBuyerUseCase {
    Buyer register(Buyer buyer);
}
