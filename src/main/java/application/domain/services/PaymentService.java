package application.domain.services;

import application.domain.entities.Payment;
import java.math.BigDecimal;

public class PaymentService {
    public Payment validate(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null.");
        }
        if (payment.getOrder() == null || payment.getOrder().getId() == null) {
            throw new IllegalArgumentException("Order is required for payment.");
        }
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        return payment;
    }
}
