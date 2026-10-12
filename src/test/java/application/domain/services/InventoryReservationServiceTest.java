package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Inventory;
import org.junit.jupiter.api.Test;

class InventoryReservationServiceTest {
    private final InventoryReservationService service = new InventoryReservationService();

    @Test
    void reservesAvailableInventory() {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(10);

        service.reserve(inventory, 4);

        assertEquals(6, inventory.getAvailableQuantity());
    }

    @Test
    void rejectsReservationAboveAvailableQuantity() {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(2);

        assertThrows(IllegalStateException.class,
                () -> service.reserve(inventory, 3));
        assertEquals(2, inventory.getAvailableQuantity());
    }
}
