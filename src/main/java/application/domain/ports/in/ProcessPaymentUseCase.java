package application.domain.ports.in;

import java.math.BigDecimal;

public interface ProcessPaymentUseCase {
    String processPayment(String orderId, BigDecimal amount);
}
