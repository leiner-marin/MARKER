package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.entities.Shipment;
import application.domain.enums.OrderStatus;
import application.domain.ports.in.ManageShipmentUseCase;
import application.domain.ports.out.LogisticsPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.services.OrderPreparationService;
import application.domain.services.ShipmentService;
import java.util.UUID;

public class DefaultShipmentUseCase implements ManageShipmentUseCase {
    private final ShipmentRepositoryPort shipmentRepositoryPort;
    private final ShipmentService shipmentService;
    private final LogisticsPort logisticsPort;
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderPreparationService orderPreparationService;

    public DefaultShipmentUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            ShipmentService shipmentService,
            LogisticsPort logisticsPort,
            OrderRepositoryPort orderRepositoryPort,
            OrderPreparationService orderPreparationService) {
        this.shipmentRepositoryPort = shipmentRepositoryPort;
        this.shipmentService = shipmentService;
        this.logisticsPort = logisticsPort;
        this.orderRepositoryPort = orderRepositoryPort;
        this.orderPreparationService = orderPreparationService;
    }

    @Override
    public Shipment create(Shipment shipment) {
        Shipment prepared = shipmentService.create(shipment);
        Order order = orderRepositoryPort.findById(prepared.getOrder().getId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));
        if (order.getStatus() != OrderStatus.PAID) {
            throw new IllegalStateException("Only paid orders can be shipped.");
        }
        if (prepared.getTrackingNumber() == null || prepared.getTrackingNumber().isBlank()) {
            prepared.setTrackingNumber("MK-" + UUID.randomUUID());
        }
        Shipment external = logisticsPort.create(prepared);
        return shipmentRepositoryPort.save(external);
    }

    @Override
    public Shipment findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Shipment id is required.");
        }
        return shipmentRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found."));
    }

    @Override
    public Shipment dispatch(Shipment shipment) {
        if (shipment == null || shipment.getId() == null) {
            throw new IllegalArgumentException("Shipment id is required.");
        }
        Shipment current = shipmentRepositoryPort.findById(shipment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found."));
        Order order = orderRepositoryPort.findById(current.getOrder().getId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));
        orderRepositoryPort.update(orderPreparationService.prepare(order));
        Shipment dispatched = shipmentService.dispatch(current);
        return shipmentRepositoryPort.update(logisticsPort.dispatch(dispatched));
    }
}
