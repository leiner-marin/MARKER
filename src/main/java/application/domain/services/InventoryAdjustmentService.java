package application.domain.services;

import application.domain.entities.Inventory;

public class InventoryAdjustmentService {
    public Inventory adjust(Inventory inventory, int delta) {
        return new InventoryService().adjust(inventory, delta);
    }
}
