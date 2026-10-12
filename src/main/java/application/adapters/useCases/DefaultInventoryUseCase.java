package application.adapters.useCases;

import application.domain.entities.Inventory;
import application.domain.ports.in.ManageInventoryUseCase;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.services.InventoryService;
import java.util.Optional;

public class DefaultInventoryUseCase implements ManageInventoryUseCase {
    private final InventoryRepositoryPort inventoryRepositoryPort;
    private final InventoryService inventoryService;

    public DefaultInventoryUseCase(
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryService inventoryService) {
        this.inventoryRepositoryPort = inventoryRepositoryPort;
        this.inventoryService = inventoryService;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepositoryPort.save(inventoryService.validate(inventory));
    }

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("Product id is required.");
        }
        return inventoryRepositoryPort.findByProductId(productId);
    }

    @Override
    public Inventory validateAndAdjust(Inventory inventory, int delta) {
        return inventoryRepositoryPort.update(inventoryService.adjust(inventory, delta));
    }
}
