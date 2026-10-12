package application.domain.ports.out;

import application.domain.entities.Shipment;
import java.util.List;
import java.util.Optional;

public interface ShipmentRepositoryPort {
    Shipment save(Shipment shipment);
    Shipment update(Shipment shipment);
    Optional<Shipment> findById(Long id);
    Optional<Shipment> findByOrderId(Long orderId);
    List<Shipment> findAll();
}
