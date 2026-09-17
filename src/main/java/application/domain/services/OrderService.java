package application.domain.services;

import application.domain.models.Order;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getCreationDate() == null) {
            order.setCreationDate(LocalDateTime.now());
        }
        if (order.getStatus() == null || order.getStatus().isBlank()) {
            order.setStatus("CREATED");
        }
        return order;
    }

    public Order updateOrderStatus(Order order, String newStatus) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (newStatus == null || newStatus.isBlank()) {
            throw new IllegalArgumentException("Order status is required.");
        }
        order.setStatus(newStatus);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public Order confirmOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus("CONFIRMED");
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public Order cancelOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus("CANCELLED");
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }
}
