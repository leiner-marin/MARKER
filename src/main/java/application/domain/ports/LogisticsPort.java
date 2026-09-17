package application.domain.ports;

import application.domain.models.Shipment;
import java.time.LocalDateTime;

public interface LogisticsPort {
    Shipment createShipment(Shipment shipment);
    Shipment updateShipmentStatus(Shipment shipment, String newStatus);
    Shipment scheduleDelivery(Shipment shipment, LocalDateTime deliveryDate);
}
