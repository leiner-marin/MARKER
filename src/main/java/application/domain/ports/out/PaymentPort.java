package application.domain.ports.out;

import java.math.BigDecimal;

public interface PaymentPort {
    String processPayment(String orderId, BigDecimal amount);
}
