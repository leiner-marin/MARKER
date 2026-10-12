package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Inventory;
import application.domain.entities.Product;
import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import org.junit.jupiter.api.Test;

class InventoryServiceTest {
    private final InventoryService inventoryService = new InventoryService();

    @Test
    void adjustsInventoryWithoutAllowingNegativeStock() {
        Inventory inventory = inventoryWithQuantity(5);

        Inventory result = inventoryService.adjust(inventory, -2);

        assertEquals(3, result.getAvailableQuantity());
    }

    @Test
    void rejectsAdjustmentThatWouldCreateNegativeStock() {
        Inventory inventory = inventoryWithQuantity(2);

        assertThrows(IllegalStateException.class,
                () -> inventoryService.adjust(inventory, -3));
        assertEquals(2, inventory.getAvailableQuantity());
    }

    private Inventory inventoryWithQuantity(int quantity) {
        Inventory inventory = new Inventory();
        Product product = new Product();
        product.setId(1L);
        Seller seller = new Seller();
        seller.setId(1L);
        product.setSeller(seller);
        inventory.setProduct(product);
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        inventory.setWarehouse(warehouse);
        inventory.setAvailableQuantity(quantity);
        return inventory;
    }
}
