package application.infrastructure.persistence;

import application.domain.entities.Inventory;
import application.domain.ports.out.InventoryRepositoryPort;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryJpaAdapter implements InventoryRepositoryPort {
    private final InventoryJpaRepository repository;

    public InventoryJpaAdapter(InventoryJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        validate(inventory);
        return toDomain(repository.save(toEntity(inventory)));
    }

    @Override
    public Inventory update(Inventory inventory) {
        validate(inventory);
        return toDomain(repository.save(toEntity(inventory)));
    }

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        if (productId == null) {
            return Optional.empty();
        }
        return repository.findFirstByProductId(productId).map(this::toDomain);
    }

    private void validate(Inventory inventory) {
        if (inventory == null || inventory.getProduct() == null || inventory.getProduct().getId() == null) {
            throw new IllegalArgumentException("Product is required for inventory.");
        }
        if (inventory.getWarehouse() == null || inventory.getWarehouse().getId() == null) {
            throw new IllegalArgumentException("Warehouse is required for inventory.");
        }
        if (inventory.getAvailableQuantity() == null || inventory.getAvailableQuantity() < 0) {
            throw new IllegalArgumentException("Available quantity cannot be negative.");
        }
        if (inventory.getMovementType() == null || inventory.getMovementType().isBlank()) {
            inventory.setMovementType("INGRESS");
        }
    }

    private InventoryEntity toEntity(Inventory inventory) {
        InventoryEntity entity = new InventoryEntity();
        entity.setId(inventory.getId());
        entity.setProductId(inventory.getProduct().getId());
        entity.setWarehouseId(inventory.getWarehouse().getId());
        entity.setAvailableQuantity(inventory.getAvailableQuantity());
        entity.setReservedQuantity(0);
        entity.setMovementType(inventory.getMovementType());
        return entity;
    }

    private Inventory toDomain(InventoryEntity entity) {
        Inventory inventory = new Inventory();
        inventory.setId(entity.getId());
        inventory.setAvailableQuantity(entity.getAvailableQuantity());
        inventory.setMovementType(entity.getMovementType());

        application.domain.entities.Product product = new application.domain.entities.Product();
        product.setId(entity.getProductId());
        inventory.setProduct(product);

        application.domain.entities.Warehouse warehouse = new application.domain.entities.Warehouse();
        warehouse.setId(entity.getWarehouseId());
        inventory.setWarehouse(warehouse);

        return inventory;
    }
}