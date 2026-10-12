package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Buyer;
import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.enums.OrderStatus;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    private final OrderService service = new OrderService();

    @Test
    void createsOrderInCartState() {
        Order order = validOrder();

        Order result = service.create(order);

        assertEquals(OrderStatus.CART, result.getStatus());
    }

    @Test
    void acceptsValidOrderLifecycleTransition() {
        Order order = validOrder();
        service.create(order);

        service.updateStatus(order, OrderStatus.PENDING_PAYMENT);
        service.updateStatus(order, OrderStatus.PAID);
        service.updateStatus(order, OrderStatus.DISPATCHED);
        service.updateStatus(order, OrderStatus.DELIVERED);
        service.updateStatus(order, OrderStatus.FINALIZED);

        assertEquals(OrderStatus.FINALIZED, order.getStatus());
    }

    @Test
    void rejectsModificationAfterFinalization() {
        Order order = validOrder();
        order.setStatus(OrderStatus.FINALIZED);

        assertThrows(IllegalStateException.class,
                () -> service.updateStatus(order, OrderStatus.PAID));
    }

    @Test
    void rejectsInvalidTransition() {
        Order order = validOrder();
        order.setStatus(OrderStatus.CART);

        assertThrows(IllegalStateException.class,
                () -> service.updateStatus(order, OrderStatus.PAID));
    }

    private Order validOrder() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Product product = new Product();
        product.setId(1L);

        Order order = new Order();
        order.setBuyer(buyer);
        order.setProducts(List.of(product));
        return order;
    }
}
