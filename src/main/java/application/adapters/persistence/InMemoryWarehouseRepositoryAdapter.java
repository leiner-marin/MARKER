package application.adapters.persistence;

import application.domain.entities.Warehouse;
import application.domain.ports.out.WarehouseRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryWarehouseRepositoryAdapter implements WarehouseRepositoryPort {
    private final Map<Long, Warehouse> warehouses = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Warehouse save(Warehouse warehouse) {
        validate(warehouse);
        if (warehouse.getId() == null) {
            warehouse.setId(nextId.getAndIncrement());
        }
        warehouses.put(warehouse.getId(), warehouse);
        return warehouse;
    }

    @Override
    public Warehouse update(Warehouse warehouse) {
        validate(warehouse);
        if (warehouse.getId() == null || !warehouses.containsKey(warehouse.getId())) {
            throw new IllegalArgumentException("Warehouse must exist before it can be updated.");
        }
        warehouses.put(warehouse.getId(), warehouse);
        return warehouse;
    }

    @Override
    public Optional<Warehouse> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(warehouses.get(id));
    }

    @Override
    public List<Warehouse> findAll() {
        return new ArrayList<>(warehouses.values());
    }

    @Override
    public List<Warehouse> findBySellerId(Long sellerId) {
        if (sellerId == null) {
            return List.of();
        }
        return warehouses.values().stream()
                .filter(warehouse -> warehouse.getOwnerSeller() != null
                        && sellerId.equals(warehouse.getOwnerSeller().getId()))
                .toList();
    }

    private void validate(Warehouse warehouse) {
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
    }
}
