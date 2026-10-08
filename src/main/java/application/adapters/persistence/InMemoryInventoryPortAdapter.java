package application.adapters.persistence;

import application.domain.models.InventoryModel;
import application.domain.ports.out.InventoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryInventoryPortAdapter implements InventoryPort {
    private final Map<Long, InventoryModel> inventories = new ConcurrentHashMap<>();

    @Override
    public InventoryModel save(InventoryModel inventory) {
        if (inventory.getProductId() == null) {
            throw new IllegalArgumentException("ProductId is required for inventory.");
        }
        inventories.put(inventory.getProductId(), inventory);
        return inventory;
    }

    @Override
    public InventoryModel update(InventoryModel inventory) {
        if (inventory.getProductId() == null) {
            throw new IllegalArgumentException("ProductId is required for update.");
        }
        inventories.put(inventory.getProductId(), inventory);
        return inventory;
    }

    @Override
    public Optional<InventoryModel> findByProductId(Long productId) {
        return Optional.ofNullable(inventories.get(productId));
    }
}
