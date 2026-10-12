package application.infrastructure.external;

import application.domain.ports.out.PaymentPort;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class InMemoryPaymentAdapter implements PaymentPort {
    @Override
    public String processPayment(String orderId, BigDecimal amount) {
        return "PAYMENT_ACCEPTED";
    }
}
