package application.domain.services;

import application.domain.entities.Shipment;
import application.domain.enums.ShipmentStatus;
import java.time.LocalDateTime;

public class DeliveryService {
    public Shipment confirm(Shipment shipment) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        if (shipment.getShipmentStatus() != ShipmentStatus.DISPATCHED
                && shipment.getShipmentStatus() != ShipmentStatus.IN_TRANSIT) {
            throw new IllegalStateException("Shipment must be dispatched before delivery.");
        }
        shipment.setShipmentStatus(ShipmentStatus.DELIVERED);
        shipment.setDeliveryDate(LocalDateTime.now());
        return shipment;
    }
}
