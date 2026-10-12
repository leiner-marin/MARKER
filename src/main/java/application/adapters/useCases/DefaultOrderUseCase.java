package application.adapters.useCases;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductType;
import application.domain.ports.in.CreateOrderUseCase;
import application.domain.ports.in.ManageOrderUseCase;
import application.domain.ports.out.CartRepositoryPort;
import application.domain.ports.out.InventoryMovementRepositoryPort;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.services.InventoryReservationService;
import application.domain.services.OrderService;
import java.util.ArrayList;

public class DefaultOrderUseCase implements CreateOrderUseCase, ManageOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final CartRepositoryPort cartRepositoryPort;
    private final InventoryRepositoryPort inventoryRepositoryPort;
    private final InventoryMovementRepositoryPort inventoryMovementRepositoryPort;
    private final InventoryReservationService reservationService;
    private final OrderService orderService;

    public DefaultOrderUseCase(
            OrderRepositoryPort orderRepositoryPort,
            CartRepositoryPort cartRepositoryPort,
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort,
            InventoryReservationService reservationService,
            OrderService orderService) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.cartRepositoryPort = cartRepositoryPort;
        this.inventoryRepositoryPort = inventoryRepositoryPort;
        this.inventoryMovementRepositoryPort = inventoryMovementRepositoryPort;
        this.reservationService = reservationService;
        this.orderService = orderService;
    }

    @Override
    public Order create(Order order) {
        Order created = orderService.create(order);
        reservePhysicalProducts(created);
        return orderRepositoryPort.save(orderService.confirmFromCart(created));
    }

    @Override
    public Order createFromCart(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        Cart cart = cartRepositoryPort.findByBuyer(buyer)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found."));
        if (cart.getProducts() == null || cart.getProducts().isEmpty()) {
            throw new IllegalStateException("Cart must contain at least one product.");
        }

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProducts(new ArrayList<>(cart.getProducts()));
        Order confirmed = orderService.confirmFromCart(order);
        reservePhysicalProducts(confirmed);
        Order saved = orderRepositoryPort.save(confirmed);

        cartServiceClear(cart);
        return saved;
    }

    private void reservePhysicalProducts(Order order) {
        for (Product product : order.getProducts()) {
            if (product.getProductType() != ProductType.PHYSICAL) {
                continue;
            }

            Inventory inventory = inventoryRepositoryPort.findByProductId(product.getId())
                    .orElseThrow(() -> new IllegalStateException(
                            "Inventory not found for physical product " + product.getId() + "."));

            Inventory reserved = reservationService.reserve(inventory, 1);
            Inventory saved = inventoryRepositoryPort.update(reserved);
            inventoryMovementRepositoryPort.saveMovement(saved);
        }
    }

    private void cartServiceClear(Cart cart) {
        cart.setProducts(new ArrayList<>());
        cartRepositoryPort.update(cart);
    }

    @Override
    public Order updateStatus(Order order) {
        Order current = findById(order == null ? null : order.getId());
        OrderStatus target = order == null ? null : order.getStatus();
        return orderRepositoryPort.update(orderService.updateStatus(current, target));
    }

    @Override
    public Order findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Order id is required.");
        }
        return orderRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));
    }
}
