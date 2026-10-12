package application.domain.ports.in;

import application.domain.entities.Inventory;
import java.util.Optional;

public interface ManageInventoryUseCase {
    Inventory save(Inventory inventory);
    Optional<Inventory> findByProductId(Long productId);
    Inventory validateAndAdjust(Inventory inventory, int delta);
}
