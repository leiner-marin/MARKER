package application.domain.services;

import application.domain.entities.Order;
import java.util.Objects;

public class ValidacionPedidoService {

    public Order validarPedido(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getBuyer() == null) {
            throw new IllegalArgumentException("Buyer is required for the order.");
        }
        if (order.getProducts() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one product.");
        }
        return order;
    }

    public boolean tieneProductosValidados(Order order) {
        return order != null
                && order.getProducts() != null
                && !order.getProducts().isEmpty()
                && !Objects.equals(order.getBuyer(), null);
    }
}
