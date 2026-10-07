package application.services;

import application.domain.entities.Order;
import application.domain.entities.Shipment;
import application.domain.entities.Warehouse;
import application.domain.enums.ShipmentStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class DespachoService {

    public Shipment despacharPedido(Order order, Warehouse origen, String direccionEntrega) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (origen == null) {
            throw new IllegalArgumentException("Origin warehouse is required.");
        }
        if (direccionEntrega == null || direccionEntrega.isBlank()) {
            throw new IllegalArgumentException("Delivery address is required.");
        }
        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        shipment.setOriginWarehouse(origen);
        shipment.setDeliveryAddress(direccionEntrega);
        shipment.setShipmentStatus(ShipmentStatus.CREATED);
        shipment.setDispatchDate(LocalDateTime.now());
        return shipment;
    }

    public Shipment actualizarEstadoDespacho(Shipment shipment, ShipmentStatus estado) {
        if (shipment == null) {
            throw new IllegalArgumentException("Shipment cannot be null.");
        }
        if (estado == null) {
            throw new IllegalArgumentException("Shipment status is required.");
        }
        shipment.setShipmentStatus(estado);
        if (estado == ShipmentStatus.DISPATCHED || estado == ShipmentStatus.IN_TRANSIT) {
            shipment.setDispatchDate(LocalDateTime.now());
        }
        return shipment;
    }
}
