package application.infrastructure.external;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.adapters.persistence.InMemoryInventoryRepositoryAdapter;
import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.adapters.persistence.InMemoryShipmentRepositoryAdapter;
import application.domain.entities.Buyer;
import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.entities.Shipment;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import application.domain.enums.ShipmentStatus;
import java.util.List;
import org.junit.jupiter.api.Test;

class InMemoryReportAdapterTest {

    @Test
    void reportsCurrentOrdersInventoryAndShipments() {
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryInventoryRepositoryAdapter inventoryRepository = new InMemoryInventoryRepositoryAdapter();
        InMemoryShipmentRepositoryAdapter shipmentRepository = new InMemoryShipmentRepositoryAdapter();

        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setName("Product");
        product.setProductType(ProductType.PHYSICAL);
        product.setStatus(ProductStatus.PUBLISHED);

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProducts(List.of(product));
        order.setStatus(OrderStatus.FINALIZED);
        orderRepository.save(order);

        Inventory inventory = new Inventory();
        inventory.setId(1L);
        inventory.setProduct(product);
        inventory.setAvailableQuantity(5);
        inventory.setReservedQuantity(2);
        inventory.setDamaged(false);
        inventoryRepository.save(inventory);

        Shipment shipment = new Shipment();
        shipment.setId(1L);
        shipment.setOrder(order);
        shipment.setShipmentStatus(ShipmentStatus.DELIVERED);
        shipmentRepository.save(shipment);

        InMemoryReportAdapter adapter = new InMemoryReportAdapter(
                orderRepository, inventoryRepository, shipmentRepository);

        assertEquals(1, adapter.sales().get("totalOrders"));
        assertEquals(1L, adapter.sales().get("finalizedOrders"));
        assertEquals(5, adapter.inventory().get("availableStock"));
        assertEquals(2, adapter.inventory().get("reservedStock"));
        assertEquals(1L, adapter.shipments().get("delivered"));
        assertEquals(1, adapter.orders().get("totalOrders"));
    }
}
