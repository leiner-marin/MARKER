package application.domain.services;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import java.time.LocalDateTime;

public class EstadoPedidoService {

    public Order actualizarEstadoPedido(Order order, OrderStatus nuevoEstado) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("Order status is required.");
        }
        order.setStatus(nuevoEstado);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public Order confirmarPedido(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus(OrderStatus.PAID);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }
}
