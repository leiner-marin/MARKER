package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.entities.Payment;
import application.domain.enums.OrderStatus;
import application.domain.ports.in.ProcessPaymentUseCase;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.PaymentPort;
import application.domain.services.PaymentService;
import java.math.BigDecimal;

public class DefaultPaymentUseCase implements ProcessPaymentUseCase {
    private final PaymentPort paymentPort;
    private final OrderRepositoryPort orderRepositoryPort;
    private final PaymentService paymentService;

    public DefaultPaymentUseCase(
            PaymentPort paymentPort,
            OrderRepositoryPort orderRepositoryPort,
            PaymentService paymentService) {
        this.paymentPort = paymentPort;
        this.orderRepositoryPort = orderRepositoryPort;
        this.paymentService = paymentService;
    }

    @Override
    public String processPayment(String orderId, BigDecimal amount) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order id is required.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }

        Order order = orderRepositoryPort.findById(Long.valueOf(orderId))
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        paymentService.validate(payment);

        String result = paymentPort.processPayment(orderId, amount);
        if ("PAYMENT_ACCEPTED".equals(result)) {
            order.setStatus(OrderStatus.PAID);
            orderRepositoryPort.update(order);
        }
        return result;
    }
}
