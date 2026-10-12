package application.domain.ports.out;

import application.domain.entities.Inventory;
import java.util.List;

public interface InventoryMovementRepositoryPort {
    Inventory saveMovement(Inventory movement);
    List<Inventory> findByInventoryId(Long inventoryId);
}