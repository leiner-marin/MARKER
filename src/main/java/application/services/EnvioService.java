package application.services;

import application.domain.entities.Shipment;
import application.domain.enums.ShipmentStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    public Shipment createShipment(Shipment shipment) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        if (shipment.getDispatchDate() == null) {
            shipment.setDispatchDate(LocalDateTime.now());
        }
        return shipment;
    }

    public Shipment updateShipmentStatus(Shipment shipment, ShipmentStatus newStatus) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("Shipment status is required.");
        }
        shipment.setShipmentStatus(newStatus);
        return shipment;
    }

    public Shipment scheduleDelivery(Shipment shipment, LocalDateTime deliveryDate) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        if (deliveryDate == null) {
            throw new IllegalArgumentException("Delivery date is required.");
        }
        shipment.setDeliveryDate(deliveryDate);
        return shipment;
    }
}

