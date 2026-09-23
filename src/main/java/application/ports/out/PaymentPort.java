package application.ports.out;

import java.math.BigDecimal;

public interface PaymentPort {
    String processPayment(String orderId, BigDecimal amount);
}
