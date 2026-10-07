package application.domain.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MovimientoInventarioService {

    public Inventory registrarMovimiento(Inventory inventory, InventoryMovementType movementType, Integer quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (movementType == null) {
            throw new IllegalArgumentException("Movement type is required.");
        }
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("Quantity must be zero or positive.");
        }
        inventory.setMovementType(movementType.name());
        inventory.setMovementDate(LocalDateTime.now());
        if (inventory.getAvailableQuantity() == null) {
            inventory.setAvailableQuantity(0);
        }
        switch (movementType) {
            case INGRESS -> inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            case RESERVE, SALE_OUT -> inventory.setAvailableQuantity(Math.max(0, inventory.getAvailableQuantity() - quantity));
            case ADJUSTMENT -> inventory.setAvailableQuantity(quantity);
            case RETURN -> inventory.setAvailableQuantity(inventory.getAvailableQuantity() + quantity);
            default -> throw new IllegalArgumentException("Unsupported movement type.");
        }
        return inventory;
    }
}
