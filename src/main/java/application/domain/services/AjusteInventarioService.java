package application.services;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class AjusteInventarioService {

    public Inventory ajustarInventario(Inventory inventory, Integer nuevaCantidad) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (nuevaCantidad == null || nuevaCantidad < 0) {
            throw new IllegalArgumentException("Adjusted quantity must be zero or positive.");
        }
        inventory.setAvailableQuantity(nuevaCantidad);
        inventory.setMovementType(InventoryMovementType.ADJUSTMENT.name());
        inventory.setMovementDate(LocalDateTime.now());
        return inventory;
    }
}
