package application.adapters.persistence;

import application.domain.entities.Shipment;
import application.domain.ports.out.ShipmentRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryShipmentRepositoryAdapter implements ShipmentRepositoryPort {
    private final Map<Long, Shipment> shipments = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Shipment save(Shipment shipment) {
        validate(shipment);
        if (shipment.getId() == null) {
            shipment.setId(nextId.getAndIncrement());
        }
        shipments.put(shipment.getId(), shipment);
        return shipment;
    }

    @Override
    public Shipment update(Shipment shipment) {
        validate(shipment);
        if (shipment.getId() == null || !shipments.containsKey(shipment.getId())) {
            throw new IllegalArgumentException("Shipment must exist before it can be updated.");
        }
        shipments.put(shipment.getId(), shipment);
        return shipment;
    }

    @Override
    public Optional<Shipment> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(shipments.get(id));
    }

    @Override
    public Optional<Shipment> findByOrderId(Long orderId) {
        return shipments.values().stream()
                .filter(s -> s.getOrder() != null && orderId != null && orderId.equals(s.getOrder().getId()))
                .findFirst();
    }

    @Override
    public List<Shipment> findAll() {
        return new ArrayList<>(shipments.values());
    }

    private void validate(Shipment shipment) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
    }
}
