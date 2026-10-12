package application.domain.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.time.LocalDateTime;

public class InventoryMovementService {
    private final InventoryService inventoryService = new InventoryService();
    private final InventoryReservationService reservationService = new InventoryReservationService();

    public Inventory apply(
            Inventory inventory,
            InventoryMovementType movement,
            int quantity) {
        if (inventory == null || movement == null) {
            throw new IllegalArgumentException("Inventory and movement are required.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Movement quantity must be greater than zero.");
        }

        inventoryService.validate(inventory);

        switch (movement) {
            case INGRESS -> inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            case RESERVE -> reservationService.reserve(inventory, quantity);
            case SALE_OUT -> consumeForSale(inventory, quantity);
            case ADJUSTMENT -> inventoryService.adjust(inventory, quantity);
            case RETURN -> inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
        }

        inventory.setMovementType(movement.name());
        inventory.setMovementDate(LocalDateTime.now());
        return inventory;
    }

    private void consumeForSale(Inventory inventory, int quantity) {
        int reserved = inventory.getReservedQuantity() == null ? 0 : inventory.getReservedQuantity();
        int available = inventory.getAvailableQuantity() == null ? 0 : inventory.getAvailableQuantity();

        if (reserved >= quantity) {
            inventory.setReservedQuantity(reserved - quantity);
            return;
        }

        int remaining = quantity - reserved;
        if (available < remaining) {
            throw new IllegalStateException("Inventory cannot become negative.");
        }

        inventory.setReservedQuantity(0);
        inventory.setAvailableQuantity(available - remaining);
    }
}
