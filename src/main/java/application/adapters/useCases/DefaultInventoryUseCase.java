package application.adapters.useCases;

import application.domain.exceptions.InventoryValidationException;
import application.domain.models.InventoryModel;
import application.domain.ports.in.InventoryValidationUseCase;
import application.domain.ports.out.InventoryPort;

public class DefaultInventoryUseCase implements InventoryValidationUseCase {
    private final InventoryPort inventoryPort;

    public DefaultInventoryUseCase(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    @Override
    public InventoryModel validateAndAdjust(InventoryModel inventory, int delta) {
        if (inventory == null) {
            throw new InventoryValidationException("Inventory cannot be null.");
        }
        int newQuantity = inventory.getAvailableQuantity() + delta;
        if (newQuantity < 0) {
            throw new InventoryValidationException("Inventory adjustment would become negative.");
        }
        inventory.setAvailableQuantity(newQuantity);
        return inventoryPort.save(inventory);
    }
}
