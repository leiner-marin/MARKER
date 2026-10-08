package application.domain.ports.out;

import application.domain.models.InventoryModel;
import java.util.Optional;

public interface InventoryPort {
    InventoryModel save(InventoryModel inventory);
    InventoryModel update(InventoryModel inventory);
    Optional<InventoryModel> findByProductId(Long productId);
}
