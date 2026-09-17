package application.domain.ports;

import application.domain.models.Order;

public interface OrderPort {
    Order createOrder(Order order);
    Order updateOrderStatus(Order order, String newStatus);
    Order confirmOrder(Order order);
    Order cancelOrder(Order order);
}
