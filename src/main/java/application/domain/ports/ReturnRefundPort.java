package application.domain.ports;

import application.domain.models.Order;
import java.math.BigDecimal;

public interface ReturnRefundPort {
    Order registerReturn(Order order, BigDecimal amount);
    boolean isValidRefundAmount(BigDecimal amount);
    Order approveRefund(Order order);
}
