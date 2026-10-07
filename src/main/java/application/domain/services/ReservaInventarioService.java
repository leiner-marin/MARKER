package application.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class ReservaInventarioService {

    public Inventory reservar(Inventory inventory, Integer cantidad) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("Quantity to reserve must be greater than zero.");
        }
        if (inventory.getAvailableQuantity() == null || inventory.getAvailableQuantity() < cantidad) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        inventory.setAvailableQuantity(inventory.getAvailableQuantity() - cantidad);
        inventory.setMovementType(InventoryMovementType.RESERVE.name());
        inventory.setMovementDate(LocalDateTime.now());
        return inventory;
    }
}
