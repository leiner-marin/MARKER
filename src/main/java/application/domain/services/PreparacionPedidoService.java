package application.services;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PreparacionPedidoService {

    public Order prepararPedido(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus(OrderStatus.PAID);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public Order marcarPedidoListo(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus(OrderStatus.DISPATCHED);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }
}
