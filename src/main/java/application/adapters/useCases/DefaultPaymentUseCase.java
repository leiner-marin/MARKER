package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.entities.Payment;
import application.domain.enums.OrderStatus;
import application.domain.enums.PaymentStatus;
import application.domain.ports.in.ProcessPaymentUseCase;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.PaymentPort;
import application.domain.ports.out.PaymentRepositoryPort;
import application.domain.services.OrderService;
import application.domain.services.PaymentService;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DefaultPaymentUseCase implements ProcessPaymentUseCase {
    private final PaymentPort paymentPort;
    private final PaymentRepositoryPort paymentRepositoryPort;
    private final OrderRepositoryPort orderRepositoryPort;
    private final PaymentService paymentService;
    private final OrderService orderService;

    public DefaultPaymentUseCase(
            PaymentPort paymentPort,
            PaymentRepositoryPort paymentRepositoryPort,
            OrderRepositoryPort orderRepositoryPort,
            PaymentService paymentService,
            OrderService orderService) {
        this.paymentPort = paymentPort;
        this.paymentRepositoryPort = paymentRepositoryPort;
        this.orderRepositoryPort = orderRepositoryPort;
        this.paymentService = paymentService;
        this.orderService = orderService;
    }

    @Override
    public String processPayment(String orderId, BigDecimal amount) {
        long parsedOrderId = parseOrderId(orderId);
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }

        Order order = orderRepositoryPort.findById(parsedOrderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        if (order.getStatus() != OrderStatus.PENDING_PAYMENT) {
            throw new IllegalStateException("Only orders pending payment can be paid.");
        }

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setMethod("EXTERNAL");
        paymentService.validate(payment);

        String result = paymentPort.processPayment(orderId, amount);
        if ("PAYMENT_ACCEPTED".equals(result)) {
            payment.setStatus(PaymentStatus.PAID);
            paymentRepositoryPort.save(payment);
            Order paidOrder = orderService.updateStatus(order, OrderStatus.PAID);
            if (!orderService.requiresPhysicalDelivery(paidOrder)) {
                orderService.finalizeDigitalOrder(paidOrder);
            }
            orderRepositoryPort.update(paidOrder);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
            paymentRepositoryPort.save(payment);
        }
        return result;
    }

    private long parseOrderId(String orderId) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("Order id is required.");
        }
        try {
            return Long.parseLong(orderId);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Order id must be numeric.", exception);
        }
    }
}
