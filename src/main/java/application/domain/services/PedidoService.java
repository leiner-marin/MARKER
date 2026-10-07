package application.services;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public Order createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getCreationDate() == null) {
            order.setCreationDate(LocalDateTime.now());
        }
        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.CREATED);
        }
        return order;
    }

    public Order updateOrderStatus(Order order, OrderStatus newStatus) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (newStatus == null) {
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
        order.setStatus(OrderStatus.PAID);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public Order cancelOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus(OrderStatus.CANCELLED);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }
}

