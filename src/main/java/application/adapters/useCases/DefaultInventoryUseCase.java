package application.adapters.useCases;

import application.domain.entities.Inventory;
import application.domain.enums.InventoryMovementType;
import application.domain.ports.in.ManageInventoryUseCase;
import application.domain.ports.out.InventoryMovementRepositoryPort;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.services.InventoryAdjustmentService;
import application.domain.services.InventoryMovementService;
import application.domain.services.InventoryService;
import java.time.LocalDateTime;
import java.util.Optional;

public class DefaultInventoryUseCase implements ManageInventoryUseCase {
    private final InventoryRepositoryPort inventoryRepositoryPort;
    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;
    private final InventoryService inventoryService;
    private final InventoryAdjustmentService inventoryAdjustmentService;
    private final InventoryMovementService inventoryMovementService;

    public DefaultInventoryUseCase(
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort,
            InventoryService inventoryService,
            InventoryAdjustmentService inventoryAdjustmentService,
            InventoryMovementService inventoryMovementService) {
        this.inventoryRepositoryPort = inventoryRepositoryPort;
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
        this.inventoryService = inventoryService;
        this.inventoryAdjustmentService = inventoryAdjustmentService;
        this.inventoryMovementService = inventoryMovementService;
    }

    @Override
    public Inventory save(Inventory inventory) {
        inventoryService.validate(inventory);
        if (inventory.getMovementType() == null || inventory.getMovementType().isBlank()) {
            inventory.setMovementType(InventoryMovementType.INGRESS.name());
        }
        if (inventory.getMovementDate() == null) {
            inventory.setMovementDate(LocalDateTime.now());
        }
        Inventory saved = inventoryRepositoryPort.save(inventory);
        inventoryMovementRepositoryPort.saveMovement(saved);
        return saved;
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
        Inventory adjusted = inventoryAdjustmentService.adjust(inventory, delta);
        Inventory saved = inventoryRepositoryPort.update(adjusted);
        inventoryMovementRepositoryPort.saveMovement(saved);
        return saved;
    }

    @Override
    public Inventory applyMovement(Long inventoryId, InventoryMovementType movement, int quantity) {
        if (inventoryId == null) {
            throw new IllegalArgumentException("Inventory id is required.");
        }
        Inventory inventory = inventoryRepositoryPort.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found."));
        Inventory moved = inventoryMovementService.apply(inventory, movement, quantity);
        Inventory saved = inventoryRepositoryPort.update(moved);
        inventoryMovementRepositoryPort.saveMovement(saved);
        return saved;
    }
}
