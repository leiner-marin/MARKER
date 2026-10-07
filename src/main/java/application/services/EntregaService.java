package application.services;

import application.domain.entities.Shipment;
import application.domain.enums.ShipmentStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {

    public Shipment entregarPedido(Shipment shipment) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        shipment.setShipmentStatus(ShipmentStatus.DELIVERED);
        shipment.setDeliveryDate(LocalDateTime.now());
        return shipment;
    }

    public Shipment registrarEntrega(Shipment shipment, LocalDateTime fechaEntrega) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        shipment.setShipmentStatus(ShipmentStatus.DELIVERED);
        shipment.setDeliveryDate(fechaEntrega != null ? fechaEntrega : LocalDateTime.now());
        return shipment;
    }
}
