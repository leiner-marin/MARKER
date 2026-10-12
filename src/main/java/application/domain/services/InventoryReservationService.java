package application.domain.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.time.LocalDateTime;

public class InventoryReservationService {
    public Inventory reserve(Inventory inventory, int quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (inventory.isDamaged()) {
            throw new IllegalStateException("Damaged inventory cannot be reserved.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Reservation quantity must be greater than zero.");
        }
        int available = inventory.getAvailableQuantity() == null ? 0 : inventory.getAvailableQuantity();
        if (available < quantity) {
            throw new IllegalStateException("Insufficient available inventory.");
        }
        int reserved = inventory.getReservedQuantity() == null ? 0 : inventory.getReservedQuantity();
        inventory.setAvailableQuantity(available - quantity);
        inventory.setReservedQuantity(reserved + quantity);
        inventory.setMovementType(InventoryMovementType.RESERVE.name());
        inventory.setMovementDate(LocalDateTime.now());
        return inventory;
    }
}
