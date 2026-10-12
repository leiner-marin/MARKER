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
            case INGRESS -> {
                inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            }
            case RESERVE -> {
                reservationService.reserve(inventory, quantity);
            }
            case SALE_OUT -> {
                int result = inventory.getAvailableQuantity() - quantity;
                if (result < 0) {
                    throw new IllegalStateException("Inventory cannot become negative.");
                }
                inventory.setAvailableQuantity(result);
            }
            case ADJUSTMENT -> {
                inventoryService.adjust(inventory, quantity);
            }
            case RETURN -> {
                inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            }
        }

        inventory.setMovementType(movement.name());
        inventory.setMovementDate(LocalDateTime.now());
        return inventory;
    }
}
