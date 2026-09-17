package application.domain.services;

import application.domain.models.Order;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ReturnRefundService {

    public Order registerReturn(Order order, BigDecimal amount) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Return amount must be valid.");
        }
        order.setStatus("RETURNED");
        return order;
    }

    public boolean isValidRefundAmount(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    public Order approveRefund(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        order.setStatus("REFUNDED");
        return order;
    }
}
