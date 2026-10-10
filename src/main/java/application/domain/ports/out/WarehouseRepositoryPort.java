package application.domain.ports.out;

import application.domain.entities.Warehouse;
import java.util.List;
import java.util.Optional;

public interface WarehouseRepositoryPort {
    Warehouse save(Warehouse warehouse);
    Warehouse update(Warehouse warehouse);
    Optional<Warehouse> findById(Long id);
    List<Warehouse> findAll();
    List<Warehouse> findBySellerId(Long sellerId);
}
