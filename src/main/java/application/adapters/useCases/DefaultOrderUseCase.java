package application.adapters.useCases;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import application.domain.ports.in.CreateOrderUseCase;
import application.domain.ports.in.ManageOrderUseCase;
import application.domain.ports.out.CartRepositoryPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.services.OrderService;
import java.util.ArrayList;

public class DefaultOrderUseCase implements CreateOrderUseCase, ManageOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final CartRepositoryPort cartRepositoryPort;
    private final OrderService orderService;

    public DefaultOrderUseCase(
            OrderRepositoryPort orderRepositoryPort,
            CartRepositoryPort cartRepositoryPort,
            OrderService orderService) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.cartRepositoryPort = cartRepositoryPort;
        this.orderService = orderService;
    }

    @Override
    public Order create(Order order) {
        return orderRepositoryPort.save(orderService.create(order));
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
        Order saved = orderRepositoryPort.save(orderService.create(order));

        cartServiceClear(cart);
        return saved;
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
