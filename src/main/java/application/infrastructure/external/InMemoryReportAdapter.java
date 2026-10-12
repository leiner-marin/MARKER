package application.infrastructure.external;

import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Shipment;
import application.domain.enums.OrderStatus;
import application.domain.enums.ShipmentStatus;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.ReportPort;
import application.domain.ports.out.ShipmentRepositoryPort;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class InMemoryReportAdapter implements ReportPort {
    private final OrderRepositoryPort orderRepositoryPort;
    private final InventoryRepositoryPort inventoryRepositoryPort;
    private final ShipmentRepositoryPort shipmentRepositoryPort;

    public InMemoryReportAdapter(
            OrderRepositoryPort orderRepositoryPort,
            InventoryRepositoryPort inventoryRepositoryPort,
            ShipmentRepositoryPort shipmentRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.inventoryRepositoryPort = inventoryRepositoryPort;
        this.shipmentRepositoryPort = shipmentRepositoryPort;
    }

    @Override
    public Map<String, Object> sales() {
        List<Order> orders = orderRepositoryPort.findAll();
        long paid = orders.stream().filter(order -> order.getStatus() == OrderStatus.PAID
                || order.getStatus() == OrderStatus.DISPATCHED
                || order.getStatus() == OrderStatus.DELIVERED
                || order.getStatus() == OrderStatus.FINALIZED).count();
        long finalized = orders.stream().filter(order -> order.getStatus() == OrderStatus.FINALIZED).count();

        Map<String, Object> report = new LinkedHashMap<>();
        report.put("totalOrders", orders.size());
        report.put("paidOrders", paid);
        report.put("finalizedOrders", finalized);
        return report;
    }

    @Override
    public Map<String, Object> inventory() {
        List<Inventory> inventory = inventoryRepositoryPort.findAll();
        int available = inventory.stream()
                .map(Inventory::getAvailableQuantity)
                .filter(java.util.Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
        int reserved = inventory.stream()
                .map(Inventory::getReservedQuantity)
                .filter(java.util.Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
        long damaged = inventory.stream().filter(Inventory::isDamaged).count();

        Map<String, Object> report = new LinkedHashMap<>();
        report.put("availableStock", available);
        report.put("reservedStock", reserved);
        report.put("damagedItems", damaged);
        return report;
    }

    @Override
    public Map<String, Object> orders() {
        List<Order> orders = orderRepositoryPort.findAll();
        Map<String, Object> report = new LinkedHashMap<>();
        report.put("totalOrders", orders.size());

        for (OrderStatus status : OrderStatus.values()) {
            report.put(status.name().toLowerCase(), orders.stream()
                    .filter(order -> order.getStatus() == status)
                    .count());
        }
        return report;
    }

    @Override
    public Map<String, Object> shipments() {
        List<Shipment> shipments = shipmentRepositoryPort.findAll();
        Map<String, Object> report = new LinkedHashMap<>();
        report.put("totalShipments", shipments.size());

        for (ShipmentStatus status : ShipmentStatus.values()) {
            report.put(status.name().toLowerCase(), shipments.stream()
                    .filter(shipment -> shipment.getShipmentStatus() == status)
                    .count());
        }
        return report;
    }
}
