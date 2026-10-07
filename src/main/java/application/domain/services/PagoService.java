package application.services;

import application.ports.out.PaymentPort;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
    private final PaymentPort paymentPort;

    public PagoService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public String procesarPago(String orderId, BigDecimal amount) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order id is required.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Payment amount must be valid.");
        }
        return paymentPort.processPayment(orderId, amount);
    }
}
