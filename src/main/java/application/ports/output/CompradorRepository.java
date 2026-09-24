package application.ports.output;

import application.domain.entities.Buyer;
import java.util.Optional;

public interface CompradorRepository {
    Buyer save(Buyer buyer);
    Buyer update(Buyer buyer);
    Optional<Buyer> findById(Long id);
}
