package application.domain.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;

public class InventoryMovementService {
    public Inventory apply(Inventory inventory, InventoryMovementType movement, int quantity) {
        if (inventory == null || movement == null) {
            throw new IllegalArgumentException("Inventory and movement are required.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Movement quantity must be greater than zero.");
        }
        inventory.setMovementType(movement.name());

        return switch (movement) {
            case INGRESS, RETURN -> new InventoryService().adjust(inventory, quantity);
            case RESERVE -> new InventoryReservationService().reserve(inventory, quantity);
            case SALE_EXIT -> new InventoryService().adjust(inventory, -quantity);
            case ADJUSTMENT -> new InventoryService().adjust(inventory, quantity);
        };
    }
}
