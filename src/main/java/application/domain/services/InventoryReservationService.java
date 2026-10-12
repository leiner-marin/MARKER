package application.domain.services;

import application.domain.entities.Inventory;

public class InventoryReservationService {
    public Inventory reserve(Inventory inventory, int quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Reservation quantity must be greater than zero.");
        }
        if (inventory.getAvailableQuantity() == null || inventory.getAvailableQuantity() < quantity) {
            throw new IllegalStateException("Insufficient available inventory.");
        }
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - quantity);
        return inventory;
    }
}
