package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import org.junit.jupiter.api.Test;

class InventoryMovementServiceTest {
    private final InventoryMovementService service = new InventoryMovementService();

    @Test
    void appliesIngress() {
        Inventory inventory = inventory(5);
        service.apply(inventory, InventoryMovementType.INGRESS, 3);
        assertEquals(8, inventory.getAvailableQuantity());
        assertEquals("INGRESS", inventory.getMovementType());
    }

    @Test
    void appliesSaleExit() {
        Inventory inventory = inventory(5);
        service.apply(inventory, InventoryMovementType.SALE_OUT, 3);
        assertEquals(2, inventory.getAvailableQuantity());
        assertEquals("SALE_OUT", inventory.getMovementType());
    }

    private Inventory inventory(int quantity) {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(quantity);
        inventory.setReservedQuantity(0);
        return inventory;
    }
}
