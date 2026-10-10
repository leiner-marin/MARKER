package application.domain.ports.out;

import application.domain.entities.Buyer;
import java.util.Optional;

public interface BuyerRepositoryPort {
    Buyer save(Buyer buyer);
    Buyer update(Buyer buyer);
    Optional<Buyer> findById(Long id);
}