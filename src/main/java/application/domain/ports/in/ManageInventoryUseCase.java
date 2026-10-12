package application.domain.ports.in;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.util.Optional;

public interface ManageInventoryUseCase {
    Inventory save(Inventory inventory);
    Optional<Inventory> findByProductId(Long productId);
    Inventory validateAndAdjust(Inventory inventory, int delta);
    Inventory applyMovement(Long inventoryId, InventoryMovementType movement, int quantity);
}
