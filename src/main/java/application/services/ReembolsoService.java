package application.services;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ReembolsoService {
    public Order aprobarReembolso(Order order, BigDecimal amount) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Refund amount must be valid.");
        }
        order.setStatus(OrderStatus.REFUNDED);
        return order;
    }
}
