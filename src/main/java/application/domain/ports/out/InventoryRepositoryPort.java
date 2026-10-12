package application.domain.ports.out;

import application.domain.entities.Inventory;
import java.util.Optional;

public interface InventoryRepositoryPort {
    Inventory save(Inventory inventory);
    Inventory update(Inventory inventory);
    Optional<Inventory> findById(Long id);
    Optional<Inventory> findByProductId(Long productId);
}
