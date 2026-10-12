package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import org.junit.jupiter.api.Test;

class OrderPreparationServiceTest {
    private final OrderPreparationService service = new OrderPreparationService();

    @Test
    void preparesPaidOrder() {
        Order order = new Order();
        order.setStatus(OrderStatus.PAID);

        service.prepare(order);

        assertEquals(OrderStatus.DISPATCHED, order.getStatus());
    }

    @Test
    void rejectsUnpaidOrder() {
        Order order = new Order();
        order.setStatus(OrderStatus.PENDING_PAYMENT);

        assertThrows(IllegalStateException.class, () -> service.prepare(order));
    }
}
