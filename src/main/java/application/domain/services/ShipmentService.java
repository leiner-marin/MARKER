package application.domain.services;

import application.domain.entities.Shipment;
import application.domain.enums.ShipmentStatus;
import java.time.LocalDateTime;

public class ShipmentService {
    public Shipment create(Shipment shipment) {
        if (shipment == null || shipment.getOrder() == null || shipment.getOrder().getId() == null) {
            throw new IllegalArgumentException("Order is required for shipment.");
        }
        if (shipment.getDeliveryAddress() == null || shipment.getDeliveryAddress().isBlank()) {
            throw new IllegalArgumentException("Delivery address is required.");
        }
        if (shipment.getShipmentStatus() == null) {
            shipment.setShipmentStatus(ShipmentStatus.CREATED);
        }
        return shipment;
    }

    public Shipment dispatch(Shipment shipment) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        shipment.setShipmentStatus(ShipmentStatus.DISPATCHED);
        shipment.setDispatchDate(LocalDateTime.now());
        return shipment;
    }
}
