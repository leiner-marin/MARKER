package application.adapters.useCases;

import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.entities.Shipment;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductType;
import application.domain.enums.InventoryMovementType;
import application.domain.ports.in.ManageShipmentUseCase;
import application.domain.ports.out.InventoryMovementRepositoryPort;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.LogisticsPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.services.InventoryMovementService;
import application.domain.services.OrderPreparationService;
import application.domain.services.OrderService;
import application.domain.services.ShipmentService;
import java.util.UUID;

public class DefaultShipmentUseCase implements ManageShipmentUseCase {
    private final ShipmentRepositoryPort shipmentRepositoryPort;
    private final ShipmentService shipmentService;
    private final LogisticsPort logisticsPort;
    private final OrderRepositoryPort orderRepositoryPort;
    private final InventoryRepositoryPort inventoryRepositoryPort;
    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;
    private final InventoryMovementService inventoryMovementService;
    private final OrderPreparationService orderPreparationService;
    private final OrderService orderService;

    public DefaultShipmentUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            ShipmentService shipmentService,
            LogisticsPort logisticsPort,
            OrderRepositoryPort orderRepositoryPort,
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort,
            InventoryMovementService inventoryMovementService,
            OrderPreparationService orderPreparationService,
            OrderService orderService) {
        this.shipmentRepositoryPort = shipmentRepositoryPort;
        this.shipmentService = shipmentService;
        this.logisticsPort = logisticsPort;
        this.orderRepositoryPort = orderRepositoryPort;
        this.inventoryRepositoryPort = inventoryRepositoryPort;
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
        this.inventoryMovementService = inventoryMovementService;
        this.orderPreparationService = orderPreparationService;
        this.orderService = orderService;
    }

    @Override
    public Shipment create(Shipment shipment) {
        Shipment prepared = shipmentService.create(shipment);
        Order order = orderRepositoryPort.findById(prepared.getOrder().getId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));
        if (!orderService.requiresPhysicalDelivery(order)) {
            throw new IllegalStateException("Digital-only orders do not require a physical shipment.");
        }
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

        Order preparedOrder = orderPreparationService.prepare(order);
        recordSaleOut(preparedOrder);
        orderRepositoryPort.update(preparedOrder);

        Shipment dispatched = shipmentService.dispatch(current);
        return shipmentRepositoryPort.update(logisticsPort.dispatch(dispatched));
    }

    private void recordSaleOut(Order order) {
        for (Product product : order.getProducts()) {
            if (product.getProductType() != ProductType.PHYSICAL) {
                continue;
            }
            Inventory inventory = inventoryRepositoryPort.findByProductId(product.getId())
                    .orElseThrow(() -> new IllegalStateException(
                            "Inventory not found for physical product " + product.getId() + "."));

            Inventory sold = inventoryMovementService.apply(
                    inventory, InventoryMovementType.SALE_OUT, 1);
            Inventory saved = inventoryRepositoryPort.update(sold);
            inventoryMovementRepositoryPort.saveMovement(saved);
        }
    }
}
