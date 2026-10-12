package application.domain.services;

import application.domain.entities.Inventory;

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
        return inventory;
    }

    public Inventory adjust(Inventory inventory, int delta) {
        validate(inventory);
        int current = inventory.getAvailableQuantity();
        int result = current + delta;
        if (result < 0) {
            throw new IllegalStateException("Inventory cannot become negative.");
        }
        inventory.setAvailableQuantity(result);
        return inventory;
    }
}
