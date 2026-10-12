package application.adapters.persistence;

import application.domain.entities.Inventory;
import application.domain.ports.out.InventoryMovementRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryInventoryMovementRepositoryAdapter implements InventoryMovementRepositoryPort {
    private final ConcurrentMap<Long, List<Inventory>> movements = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Inventory saveMovement(Inventory movement) {
        if (movement == null || movement.getId() == null) {
            throw new IllegalArgumentException("Inventory movement must reference an inventory id.");
        }
        Inventory snapshot = copy(movement);
        snapshot.setId(nextId.getAndIncrement());
        movements.computeIfAbsent(movement.getId(), ignored -> new ArrayList<>()).add(snapshot);
        return snapshot;
    }

    @Override
    public List<Inventory> findByInventoryId(Long inventoryId) {
        if (inventoryId == null) {
            return List.of();
        }
        return List.copyOf(movements.getOrDefault(inventoryId, List.of()));
    }

    private Inventory copy(Inventory source) {
        Inventory snapshot = new Inventory();
        snapshot.setId(source.getId());
        snapshot.setProduct(source.getProduct());
        snapshot.setWarehouse(source.getWarehouse());
        snapshot.setAvailableQuantity(source.getAvailableQuantity());
        snapshot.setReservedQuantity(source.getReservedQuantity());
        snapshot.setDamaged(source.isDamaged());
        snapshot.setMovementType(source.getMovementType());
        snapshot.setMovementDate(source.getMovementDate());
        return snapshot;
    }
}
