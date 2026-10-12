package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Order;
import application.domain.entities.Payment;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    private final PaymentService service = new PaymentService();

    @Test
    void validatesPositivePaymentForExistingOrder() {
        Order order = new Order();
        order.setId(1L);

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(BigDecimal.TEN);

        assertDoesNotThrow(() -> service.validate(payment));
    }

    @Test
    void rejectsZeroPayment() {
        Order order = new Order();
        order.setId(1L);

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(BigDecimal.ZERO);

        assertThrows(IllegalArgumentException.class, () -> service.validate(payment));
    }
}
