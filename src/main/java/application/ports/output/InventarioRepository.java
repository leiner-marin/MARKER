package application.ports.output;

import application.domain.entities.Inventory;
import java.util.List;
import java.util.Optional;

public interface InventarioRepository {
    Inventory save(Inventory inventory);
    Inventory update(Inventory inventory);
    Optional<Inventory> findById(Long id);
    List<Inventory> findByProductId(Long productId);
    List<Inventory> findByWarehouseId(Long warehouseId);
    int getAvailableQuantity(Long productId);
    boolean reserve(Long productId, int quantity);
    boolean subtract(Long productId, int quantity);
    boolean returnToInventory(Long productId, int quantity);
}
