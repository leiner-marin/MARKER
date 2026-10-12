package application.adapters.useCases;

import application.domain.entities.Inventory;
import application.domain.exceptions.InventoryValidationException;
import application.domain.ports.in.ManageInventoryUseCase;
import application.domain.ports.out.InventoryRepositoryPort;
import java.util.Optional;

public class DefaultInventoryUseCase implements ManageInventoryUseCase {
    private final InventoryRepositoryPort inventoryRepositoryPort;

    public DefaultInventoryUseCase(InventoryRepositoryPort inventoryRepositoryPort) {
        this.inventoryRepositoryPort = inventoryRepositoryPort;
    }

    @Override
    public Inventory save(Inventory inventory) {
        validateInventory(inventory);
        return inventoryRepositoryPort.save(inventory);
    }

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        if (productId == null) {
            throw new InventoryValidationException("Product id is required.");
        }
        return inventoryRepositoryPort.findByProductId(productId);
    }

    @Override
    public Inventory validateAndAdjust(Inventory inventory, int delta) {
        validateInventory(inventory);

        if (inventory.getAvailableQuantity() == null) {
            inventory.setAvailableQuantity(0);
        }

        int newQuantity = inventory.getAvailableQuantity() + delta;
        if (newQuantity < 0) {
            throw new InventoryValidationException("Inventory adjustment would become negative.");
        }

        inventory.setAvailableQuantity(newQuantity);
        return inventoryRepositoryPort.update(inventory);
    }

    private void validateInventory(Inventory inventory) {
        if (inventory == null) {
            throw new InventoryValidationException("Inventory cannot be null.");
        }
        if (inventory.getProduct() == null || inventory.getProduct().getId() == null) {
            throw new InventoryValidationException("Product is required for inventory.");
        }
        if (inventory.getWarehouse() == null || inventory.getWarehouse().getId() == null) {
            throw new InventoryValidationException("Warehouse is required for inventory.");
        }
        if (inventory.getAvailableQuantity() == null || inventory.getAvailableQuantity() < 0) {
            throw new InventoryValidationException("Available quantity cannot be negative.");
        }
    }
}
