package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import application.domain.ports.in.CreateOrderUseCase;
import application.domain.ports.in.ManageOrderUseCase;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.services.OrderService;

public class DefaultOrderUseCase implements CreateOrderUseCase, ManageOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderService orderService;

    public DefaultOrderUseCase(OrderRepositoryPort orderRepositoryPort, OrderService orderService) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.orderService = orderService;
    }

    @Override
    public Order create(Order order) {
        return orderRepositoryPort.save(orderService.create(order));
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
