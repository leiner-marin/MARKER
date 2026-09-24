package application.ports.output;

import application.domain.entities.Shipment;
import java.util.Optional;

public interface EnvioRepository {
    Shipment save(Shipment shipment);
    Shipment update(Shipment shipment);
    Optional<Shipment> findById(Long id);
    Optional<Shipment> findByOrderId(Long orderId);
}
