package application.domain.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.time.LocalDateTime;

public class InventoryService {
    public Inventory validate(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (inventory.getProduct() == null || inventory.getProduct().getId() == null) {
            throw new IllegalArgumentException("Product is required for inventory.");
        }
        if (inventory.getWarehouse() == null || inventory.getWarehouse().getId() == null) {
            throw new IllegalArgumentException("Warehouse is required for inventory.");
        }
        if (inventory.getAvailableQuantity() == null || inventory.getAvailableQuantity() < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative.");
        }
        if (inventory.getReservedQuantity() == null) {
            inventory.setReservedQuantity(0);
        }
        if (inventory.getReservedQuantity() < 0) {
            throw new IllegalArgumentException("Reserved quantity cannot be negative.");
        }
        return inventory;
    }

    public Inventory adjust(Inventory inventory, int delta) {
        validate(inventory);
        int result = inventory.getAvailableQuantity() + delta;
        if (result < 0) {
            throw new IllegalStateException("Inventory cannot become negative.");
        }
        inventory.setAvailableQuantity(result);
        inventory.setMovementType(InventoryMovementType.ADJUSTMENT.name());
        inventory.setMovementDate(LocalDateTime.now());
        return inventory;
    }
}
