package application.domain.services;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import java.time.LocalDateTime;

public class OrderService {

    public Order create(Order order) {
        validateForCreation(order);
        if (order.getCreationDate() == null) {
            order.setCreationDate(LocalDateTime.now());
        }
        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.CART);
        }
        return order;
    }

    public Order updateStatus(Order order, OrderStatus newStatus) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("Order status is required.");
        }
        if (order.getStatus() == OrderStatus.FINALIZED) {
            throw new IllegalStateException("A finalized order cannot be modified.");
        }
        if (!isValidTransition(order.getStatus(), newStatus)) {
            throw new IllegalStateException("Invalid order status transition.");
        }
        order.setStatus(newStatus);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public boolean isValidTransition(OrderStatus current, OrderStatus target) {
        if (current == null || target == null) {
            return false;
        }
        return switch (current) {
            case CART -> target == OrderStatus.PENDING_PAYMENT;
            case PENDING_PAYMENT -> target == OrderStatus.PAID || target == OrderStatus.CART;
            case PAID -> target == OrderStatus.DISPATCHED;
            case DISPATCHED -> target == OrderStatus.DELIVERED;
            case DELIVERED -> target == OrderStatus.FINALIZED;
            case FINALIZED -> false;
            default -> false;
        };
    }

    private void validateForCreation(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getBuyer() == null || order.getBuyer().getId() == null) {
            throw new IllegalArgumentException("Buyer is required for the order.");
        }
        if (order.getProducts() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one product.");
        }
    }
}
