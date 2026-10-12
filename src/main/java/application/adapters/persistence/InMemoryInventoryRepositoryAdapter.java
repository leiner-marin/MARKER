package application.adapters.persistence;

import application.domain.entities.Inventory;
import application.domain.ports.out.InventoryRepositoryPort;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryInventoryRepositoryAdapter implements InventoryRepositoryPort {
    private final ConcurrentMap<Long, Inventory> inventoryById = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Inventory save(Inventory inventory) {
        validate(inventory);
        if (inventory.getId() == null) {
            inventory.setId(nextId.getAndIncrement());
        }
        inventoryById.put(inventory.getId(), inventory);
        return inventory;
    }

    @Override
    public Inventory update(Inventory inventory) {
        validate(inventory);
        if (inventory.getId() == null || !inventoryById.containsKey(inventory.getId())) {
            throw new IllegalArgumentException("Inventory must exist before it can be updated.");
        }
        inventoryById.put(inventory.getId(), inventory);
        return inventory;
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(inventoryById.get(id));
    }

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        if (productId == null) {
            return Optional.empty();
        }
        return inventoryById.values().stream()
                .filter(item -> item.getProduct() != null && productId.equals(item.getProduct().getId()))
                .sorted(Comparator.comparing(Inventory::getId))
                .findFirst();
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryById.values().stream()
                .sorted(Comparator.comparing(Inventory::getId))
                .toList();
    }

    private void validate(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }
    }
}
