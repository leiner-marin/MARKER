package application.adapters.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.adapters.persistence.InMemoryInventoryMovementRepositoryAdapter;
import application.adapters.persistence.InMemoryInventoryRepositoryAdapter;
import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.adapters.persistence.InMemoryShipmentRepositoryAdapter;
import application.domain.entities.Buyer;
import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.entities.Seller;
import application.domain.entities.Shipment;
import application.domain.entities.Warehouse;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import application.domain.enums.ShipmentStatus;
import application.domain.services.InventoryMovementService;
import application.domain.services.OrderPreparationService;
import application.domain.services.OrderService;
import application.domain.services.ShipmentService;
import application.domain.ports.out.LogisticsPort;
import java.util.List;
import org.junit.jupiter.api.Test;

class DefaultShipmentUseCaseTest {

    @Test
    void dispatchRecordsSaleOutAndConsumesReservation() {
        InMemoryShipmentRepositoryAdapter shipmentRepository = new InMemoryShipmentRepositoryAdapter();
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryInventoryRepositoryAdapter inventoryRepository = new InMemoryInventoryRepositoryAdapter();
        InMemoryInventoryMovementRepositoryAdapter movementRepository =
                new InMemoryInventoryMovementRepositoryAdapter();

        Product product = new Product();
        product.setId(1L);
        product.setName("Physical Product");
        product.setProductType(ProductType.PHYSICAL);
        product.setStatus(ProductStatus.PUBLISHED);

        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProducts(List.of(product));
        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);

        Warehouse warehouse = new Warehouse(1L, "Main", "Medellin",
                application.domain.enums.WarehouseType.MARKETPLACE, null);

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setWarehouse(warehouse);
        inventory.setAvailableQuantity(0);
        inventory.setReservedQuantity(1);
        inventory.setMovementType("RESERVE");
        inventoryRepository.save(inventory);

        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        shipment.setOriginWarehouse(warehouse);
        shipment.setDeliveryAddress("Main Street 1");
        shipment.setShipmentStatus(ShipmentStatus.CREATED);
        shipmentRepository.save(shipment);

        LogisticsPort logistics = new LogisticsPort() {
            @Override
            public Shipment create(Shipment value) {
                return value;
            }

            @Override
            public Shipment dispatch(Shipment value) {
                value.setShipmentStatus(ShipmentStatus.DISPATCHED);
                return value;
            }

            @Override
            public java.util.Optional<String> getStatus(String trackingNumber) {
                return java.util.Optional.of("DISPATCHED");
            }

            @Override
            public boolean confirmDelivery(String trackingNumber) {
                return true;
            }
        };

        DefaultShipmentUseCase useCase = new DefaultShipmentUseCase(
                shipmentRepository,
                new ShipmentService(),
                logistics,
                orderRepository,
                inventoryRepository,
                movementRepository,
                new InventoryMovementService(),
                new OrderPreparationService(),
                new OrderService());

        Shipment dispatched = useCase.dispatch(shipment);

        assertEquals(ShipmentStatus.DISPATCHED, dispatched.getShipmentStatus());
        assertEquals(OrderStatus.DISPATCHED,
                orderRepository.findById(order.getId()).orElseThrow().getStatus());
        Inventory stored = inventoryRepository.findById(inventory.getId()).orElseThrow();
        assertEquals(0, stored.getReservedQuantity());
        assertEquals(1, movementRepository.findByInventoryId(inventory.getId()).size());
    }
}
