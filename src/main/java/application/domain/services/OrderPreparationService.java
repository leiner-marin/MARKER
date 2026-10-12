package application.domain.services;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;

public class OrderPreparationService {
    public Order prepare(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getStatus() != OrderStatus.PAID) {
            throw new IllegalStateException("Only paid orders can be prepared.");
        }
        order.setStatus(OrderStatus.DISPATCHED);
        return order;
    }
}
