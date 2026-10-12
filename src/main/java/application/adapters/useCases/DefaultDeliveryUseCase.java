package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.entities.Shipment;
import application.domain.enums.OrderStatus;
import application.domain.ports.in.ConfirmDeliveryUseCase;
import application.domain.ports.out.LogisticsPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.services.DeliveryService;
import application.domain.services.OrderService;

public class DefaultDeliveryUseCase implements ConfirmDeliveryUseCase {
    private final ShipmentRepositoryPort shipmentRepositoryPort;
    private final DeliveryService deliveryService;
    private final LogisticsPort logisticsPort;
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderService orderService;

    public DefaultDeliveryUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            DeliveryService deliveryService,
            LogisticsPort logisticsPort,
            OrderRepositoryPort orderRepositoryPort,
            OrderService orderService) {
        this.shipmentRepositoryPort = shipmentRepositoryPort;
        this.deliveryService = deliveryService;
        this.logisticsPort = logisticsPort;
        this.orderRepositoryPort = orderRepositoryPort;
        this.orderService = orderService;
    }

    @Override
    public Shipment confirm(Shipment shipment) {
        if (shipment == null || shipment.getId() == null) {
            throw new IllegalArgumentException("Shipment id is required.");
        }
        Shipment current = shipmentRepositoryPort.findById(shipment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found."));

        boolean confirmed = current.getTrackingNumber() == null
                || logisticsPort.confirmDelivery(current.getTrackingNumber());
        if (!confirmed) {
            throw new IllegalStateException("Logistics provider did not confirm delivery.");
        }

        Shipment delivered = deliveryService.confirm(current);
        Order order = orderRepositoryPort.findById(delivered.getOrder().getId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        if (order.getStatus() == OrderStatus.DISPATCHED) {
            orderService.updateStatus(order, OrderStatus.DELIVERED);
        }
        if (order.getStatus() == OrderStatus.DELIVERED) {
            orderService.updateStatus(order, OrderStatus.FINALIZED);
        }
        orderRepositoryPort.update(order);
        return shipmentRepositoryPort.update(delivered);
    }
}
