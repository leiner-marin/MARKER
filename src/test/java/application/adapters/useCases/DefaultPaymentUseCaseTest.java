package application.adapters.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.adapters.persistence.InMemoryPaymentRepositoryAdapter;
import application.domain.entities.Buyer;
import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import application.domain.ports.out.PaymentPort;
import application.domain.services.OrderService;
import application.domain.services.PaymentService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DefaultPaymentUseCaseTest {

    @Test
    void acceptsPaymentAndChangesOrderToPaid() {
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryPaymentRepositoryAdapter paymentRepository = new InMemoryPaymentRepositoryAdapter();
        PaymentPort paymentPort = (orderId, amount) -> "PAYMENT_ACCEPTED";

        Order order = new Order();
        order.setBuyer(buyer());
        order.setProducts(java.util.List.of(new application.domain.entities.Product()));
        order.setStatus(OrderStatus.CART);
        OrderService orderService = new OrderService();
        orderService.create(order);
        orderService.updateStatus(order, OrderStatus.PENDING_PAYMENT);
        orderRepository.save(order);

        DefaultPaymentUseCase useCase = new DefaultPaymentUseCase(
                paymentPort,
                paymentRepository,
                orderRepository,
                new PaymentService(),
                orderService);

        String result = useCase.processPayment(
                order.getId().toString(),
                BigDecimal.TEN);

        assertEquals("PAYMENT_ACCEPTED", result);
        assertEquals(OrderStatus.PAID, order.getStatus());
        assertEquals(
                application.domain.enums.PaymentStatus.PAID,
                paymentRepository.findByOrderId(order.getId()).orElseThrow().getStatus());
    }

    @Test
    void rejectsPaymentForCartOrder() {
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryPaymentRepositoryAdapter paymentRepository = new InMemoryPaymentRepositoryAdapter();
        PaymentPort paymentPort = (orderId, amount) -> "PAYMENT_ACCEPTED";

        Order order = new Order();
        order.setId(1L);
        order.setBuyer(buyer());
        order.setProducts(java.util.List.of(new application.domain.entities.Product()));
        order.setStatus(OrderStatus.CART);
        orderRepository.save(order);

        DefaultPaymentUseCase useCase = new DefaultPaymentUseCase(
                paymentPort,
                paymentRepository,
                orderRepository,
                new PaymentService(),
                new OrderService());

        assertThrows(IllegalStateException.class,
                () -> useCase.processPayment("1", BigDecimal.TEN));
    }

    private Buyer buyer() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);
        return buyer;
    }
}
