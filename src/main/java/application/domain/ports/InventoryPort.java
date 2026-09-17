package application.domain.ports;

import application.domain.models.Inventory;

public interface InventoryPort {
    Inventory registerInitialStock(Inventory inventory);
    Inventory registerStockIn(Inventory inventory, Integer quantity);
    Inventory reserveStock(Inventory inventory, Integer quantity);
    Inventory registerSaleOut(Inventory inventory, Integer quantity);
    Inventory adjustInventory(Inventory inventory, Integer quantity);
    Inventory registerReturn(Inventory inventory, Integer quantity);
    boolean validateNonNegativeInventory(Inventory inventory);
}
