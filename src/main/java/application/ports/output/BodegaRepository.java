package application.ports.output;

import application.domain.entities.Warehouse;
import java.util.List;
import java.util.Optional;

public interface BodegaRepository {
    Warehouse save(Warehouse warehouse);
    Warehouse update(Warehouse warehouse);
    Optional<Warehouse> findById(Long id);
    List<Warehouse> findAll();
}
