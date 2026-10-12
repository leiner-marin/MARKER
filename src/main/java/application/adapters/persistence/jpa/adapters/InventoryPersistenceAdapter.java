package application.adapters.persistence.jpa.adapters;

import application.adapters.persistence.jpa.entities.InventoryEntity;
import application.adapters.persistence.jpa.mappers.InventoryJpaMapper;
import application.adapters.persistence.jpa.repositories.InventoryJpaRepository;
import application.domain.entities.Inventory;
import application.domain.ports.out.InventoryRepositoryPort;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryPersistenceAdapter implements InventoryRepositoryPort {
    private final InventoryJpaRepository repository;

    public InventoryPersistenceAdapter(InventoryJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        validate(inventory);
        return InventoryJpaMapper.toDomain(repository.save(InventoryJpaMapper.toEntity(inventory)));
    }

    @Override
    public Inventory update(Inventory inventory) {
        validate(inventory);
        if (inventory.getId() == null) {
            throw new IllegalArgumentException("Inventory id is required for update.");
        }
        return InventoryJpaMapper.toDomain(repository.save(InventoryJpaMapper.toEntity(inventory)));
    }

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        return productId == null
                ? Optional.empty()
                : repository.findFirstByProductId(productId).map(InventoryJpaMapper::toDomain);
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
    }
}
