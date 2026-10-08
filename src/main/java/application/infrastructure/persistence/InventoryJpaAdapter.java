package application.infrastructure.persistence;

import application.domain.models.InventoryModel;
import application.domain.ports.out.InventoryPort;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryJpaAdapter implements InventoryPort {
    private final InventoryJpaRepository repository;

    public InventoryJpaAdapter(InventoryJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public InventoryModel save(InventoryModel inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (inventory.getProductId() == null) {
            throw new IllegalArgumentException("ProductId is required for inventory.");
        }
        InventoryEntity entity = toEntity(inventory);
        return toModel(repository.save(entity));
    }

    @Override
    public InventoryModel update(InventoryModel inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
        if (inventory.getProductId() == null) {
            throw new IllegalArgumentException("ProductId is required for update.");
        }
        InventoryEntity entity = toEntity(inventory);
        return toModel(repository.save(entity));
    }

    @Override
    public Optional<InventoryModel> findByProductId(Long productId) {
        return repository.findById(productId).map(this::toModel);
    }

    private InventoryEntity toEntity(InventoryModel model) {
        InventoryEntity entity = new InventoryEntity();
        entity.setProductId(model.getProductId());
        entity.setAvailableQuantity(model.getAvailableQuantity());
        entity.setReservedQuantity(model.getReservedQuantity());
        return entity;
    }

    private InventoryModel toModel(InventoryEntity entity) {
        InventoryModel model = new InventoryModel();
        model.setProductId(entity.getProductId());
        model.setAvailableQuantity(entity.getAvailableQuantity());
        model.setReservedQuantity(entity.getReservedQuantity());
        return model;
    }
}
