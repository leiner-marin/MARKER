package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Order;
import application.domain.entities.Shipment;
import application.domain.enums.ShipmentStatus;
import org.junit.jupiter.api.Test;

class ShipmentDeliveryServiceTest {
    private final ShipmentService shipmentService = new ShipmentService();
    private final DeliveryService deliveryService = new DeliveryService();

    @Test
    void dispatchesAndConfirmsDelivery() {
        Order order = new Order();
        order.setId(1L);

        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        shipment.setDeliveryAddress("Main Street 1");

        shipmentService.create(shipment);
        shipmentService.dispatch(shipment);
        deliveryService.confirm(shipment);

        assertEquals(ShipmentStatus.DELIVERED, shipment.getShipmentStatus());
    }

    @Test
    void rejectsDeliveryBeforeDispatch() {
        Shipment shipment = new Shipment();

        assertThrows(IllegalStateException.class,
                () -> deliveryService.confirm(shipment));
    }
}
