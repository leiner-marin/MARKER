package application.adapters.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.adapters.persistence.InMemoryPaymentRepositoryAdapter;
import application.domain.entities.Buyer;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import application.domain.ports.out.PaymentPort;
import application.domain.services.OrderService;
import application.domain.services.PaymentService;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DefaultPaymentUseCaseTest {

    @Test
    void acceptsPaymentAndChangesPhysicalOrderToPaid() {
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryPaymentRepositoryAdapter paymentRepository = new InMemoryPaymentRepositoryAdapter();
        PaymentPort paymentPort = (orderId, amount) -> "PAYMENT_ACCEPTED";

        Order order = order();
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
    void finalizesDigitalOrderAfterAcceptedPayment() {
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryPaymentRepositoryAdapter paymentRepository = new InMemoryPaymentRepositoryAdapter();
        PaymentPort paymentPort = (orderId, amount) -> "PAYMENT_ACCEPTED";

        Order order = order();
        order.getProducts().get(0).setProductType(ProductType.DIGITAL);
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

        useCase.processPayment(order.getId().toString(), BigDecimal.TEN);

        assertEquals(OrderStatus.FINALIZED, orderRepository.findById(order.getId()).orElseThrow().getStatus());
    }

    @Test
    void rejectsPaymentForCartOrder() {
        InMemoryOrderRepositoryAdapter orderRepository = new InMemoryOrderRepositoryAdapter();
        InMemoryPaymentRepositoryAdapter paymentRepository = new InMemoryPaymentRepositoryAdapter();
        PaymentPort paymentPort = (orderId, amount) -> "PAYMENT_ACCEPTED";

        Order order = order();
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

    private Order order() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Product product = new Product();
        product.setId(1L);
        product.setStatus(ProductStatus.PUBLISHED);
        product.setProductType(ProductType.PHYSICAL);

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProducts(java.util.List.of(product));
        return order;
    }
}
