package application.services;

import application.domain.entities.Inventory;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    public Inventory registerInitialStock(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (inventory.getAvailableQuantity() == null) {
            inventory.setAvailableQuantity(0);
        }
        return inventory;
    }

    public Inventory registerStockIn(Inventory inventory, Integer quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("Input quantity must be valid.");
        }
        int newTotal = Objects.requireNonNullElse(inventory.getAvailableQuantity(), 0) + quantity;
        inventory.setAvailableQuantity(newTotal);
        return inventory;
    }

    public Inventory reserveStock(Inventory inventory, Integer quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("Reservation quantity must be valid.");
        }
        int available = Objects.requireNonNullElse(inventory.getAvailableQuantity(), 0);
        if (available < quantity) {
            throw new IllegalStateException("Not enough stock available.");
        }
        inventory.setAvailableQuantity(available - quantity);
        return inventory;
    }

    public Inventory registerSaleOut(Inventory inventory, Integer quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("Output quantity must be valid.");
        }
        int available = Objects.requireNonNullElse(inventory.getAvailableQuantity(), 0);
        if (available < quantity) {
            throw new IllegalStateException("Cannot sell more than available stock.");
        }
        inventory.setAvailableQuantity(available - quantity);
        return inventory;
    }

    public Inventory adjustInventory(Inventory inventory, Integer quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (quantity == null) {
            throw new IllegalArgumentException("Adjustment quantity is required.");
        }
        int newTotal = Objects.requireNonNullElse(inventory.getAvailableQuantity(), 0) + quantity;
        if (newTotal < 0) {
            throw new IllegalStateException("Inventory cannot become negative.");
        }
        inventory.setAvailableQuantity(newTotal);
        return inventory;
    }

    public Inventory registerReturn(Inventory inventory, Integer quantity) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException("Return quantity must be valid.");
        }
        int total = Objects.requireNonNullElse(inventory.getAvailableQuantity(), 0);
        inventory.setAvailableQuantity(total + quantity);
        return inventory;
    }

    public boolean validateNonNegativeInventory(Inventory inventory) {
        if (inventory == null || inventory.getAvailableQuantity() == null) {
            return false;
        }
        return inventory.getAvailableQuantity() >= 0;
    }
}

