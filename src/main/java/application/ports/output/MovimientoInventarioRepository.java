package application.ports.output;

import application.domain.entities.Inventory;
import java.util.List;
import java.util.Optional;

public interface MovimientoInventarioRepository {
    Inventory saveMovement(Inventory inventory);
    List<Inventory> findByInventoryId(Long inventoryId);
    Optional<Inventory> findLastMovement(Long inventoryId);
}
