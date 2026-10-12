package application.adapters.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.adapters.persistence.InMemoryCartRepositoryAdapter;
import application.adapters.persistence.InMemoryInventoryMovementRepositoryAdapter;
import application.adapters.persistence.InMemoryInventoryRepositoryAdapter;
import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import application.domain.services.InventoryReservationService;
import application.domain.services.OrderService;
import org.junit.jupiter.api.Test;

class DefaultOrderUseCaseTest {

    @Test
    void createsDigitalOrderFromCartAndClearsCart() {
        InMemoryCartRepositoryAdapter cartRepository = new InMemoryCartRepositoryAdapter();
        InMemoryInventoryRepositoryAdapter inventoryRepository = new InMemoryInventoryRepositoryAdapter();
        InMemoryInventoryMovementRepositoryAdapter movementRepository =
                new InMemoryInventoryMovementRepositoryAdapter();
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();

        Buyer buyer = buyer();
        Product product = product(10L, ProductType.DIGITAL);

        Cart cart = new Cart();
        cart.setBuyer(buyer);
        cart.getProducts().add(product);
        cartRepository.save(cart);

        DefaultOrderUseCase useCase = useCase(
                orderRepository,
                cartRepository,
                inventoryRepository,
                movementRepository);

        Order order = useCase.createFromCart(buyer);

        assertEquals(OrderStatus.PENDING_PAYMENT, order.getStatus());
        assertEquals(1, order.getProducts().size());
        assertEquals(0, cartRepository.findByBuyer(buyer).orElseThrow().getProducts().size());
    }

    @Test
    void createsPhysicalOrderFromCartAndReservesStock() {
        InMemoryCartRepositoryAdapter cartRepository = new InMemoryCartRepositoryAdapter();
        InMemoryInventoryRepositoryAdapter inventoryRepository = new InMemoryInventoryRepositoryAdapter();
        InMemoryInventoryMovementRepositoryAdapter movementRepository =
                new InMemoryInventoryMovementRepositoryAdapter();
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();

        Buyer buyer = buyer();
        Product product = product(10L, ProductType.PHYSICAL);

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setWarehouse(new application.domain.entities.Warehouse(1L, "Main", "Medellin",
                application.domain.enums.WarehouseType.MARKETPLACE, null));
        inventory.setAvailableQuantity(3);
        inventory.setReservedQuantity(0);
        inventoryRepository.save(inventory);

        Cart cart = new Cart();
        cart.setBuyer(buyer);
        cart.getProducts().add(product);
        cartRepository.save(cart);

        DefaultOrderUseCase useCase = useCase(
                orderRepository,
                cartRepository,
                inventoryRepository,
                movementRepository);

        Order order = useCase.createFromCart(buyer);

        Inventory stored = inventoryRepository.findById(inventory.getId()).orElseThrow();
        assertEquals(OrderStatus.PENDING_PAYMENT, order.getStatus());
        assertEquals(2, stored.getAvailableQuantity());
        assertEquals(1, stored.getReservedQuantity());
        assertEquals(1, movementRepository.findByInventoryId(inventory.getId()).size());
    }

    private DefaultOrderUseCase useCase(
            InMemoryOrderRepositoryAdapter orderRepository,
            InMemoryCartRepositoryAdapter cartRepository,
            InMemoryInventoryRepositoryAdapter inventoryRepository,
            InMemoryInventoryMovementRepositoryAdapter movementRepository) {
        return new DefaultOrderUseCase(
                orderRepository,
                cartRepository,
                inventoryRepository,
                movementRepository,
                new InventoryReservationService(),
                new OrderService());
    }

    private Buyer buyer() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);
        buyer.setFullName("Test Buyer");
        buyer.setEmail("buyer@example.com");
        buyer.setPrimaryAddress("Main Street 1");
        return buyer;
    }

    private Product product(Long id, ProductType type) {
        Product product = new Product();
        product.setId(id);
        product.setName("Test Product");
        product.setProductType(type);
        product.setStatus(ProductStatus.PUBLISHED);
        return product;
    }
}
