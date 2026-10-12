package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Inventory;
import org.junit.jupiter.api.Test;

class InventoryReservationServiceTest {
    private final InventoryReservationService service = new InventoryReservationService();

    @Test
    void reservesAvailableInventoryAndIncreasesReservedQuantity() {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(10);
        inventory.setReservedQuantity(2);

        service.reserve(inventory, 4);

        assertEquals(6, inventory.getAvailableQuantity());
        assertEquals(6, inventory.getReservedQuantity());
    }

    @Test
    void rejectsReservationAboveAvailableQuantity() {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(2);
        inventory.setReservedQuantity(0);

        assertThrows(IllegalStateException.class,
                () -> service.reserve(inventory, 3));
        assertEquals(2, inventory.getAvailableQuantity());
    }

    @Test
    void rejectsDamagedInventory() {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(10);
        inventory.setDamaged(true);

        assertThrows(IllegalStateException.class,
                () -> service.reserve(inventory, 1));
    }
}
