package application.domain.ports.in;

import application.domain.entities.Inventory;

public interface ReserveInventoryUseCase {
    Inventory reserve(Long inventoryId, int quantity);
}
