package application.domain.ports.out;

import application.domain.entities.Shipment;
import java.util.Optional;

public interface LogisticsPort {
    Shipment create(Shipment shipment);
    Shipment dispatch(Shipment shipment);
    Optional<String> getStatus(String trackingNumber);
    boolean confirmDelivery(String trackingNumber);
}