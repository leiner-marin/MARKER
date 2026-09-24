package application.ports.output;

import application.domain.entities.Seller;
import java.util.List;
import java.util.Optional;

public interface VendedorRepository {
    Seller save(Seller seller);
    Seller update(Seller seller);
    Optional<Seller> findById(Long id);
    List<Seller> findAll();
}
