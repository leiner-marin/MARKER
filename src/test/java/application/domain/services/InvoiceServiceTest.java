package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Buyer;
import application.domain.entities.Invoice;
import application.domain.entities.Order;
import application.domain.enums.OrderStatus;
import application.domain.enums.PaymentStatus;
import org.junit.jupiter.api.Test;

class InvoiceServiceTest {
    private final InvoiceService service = new InvoiceService();

    @Test
    void generatesInvoiceForPaidOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setBuyer(new Buyer());
        order.setStatus(OrderStatus.PAID);

        Invoice invoice = service.generate(order, java.math.BigDecimal.TEN);

        assertEquals(PaymentStatus.PAID, invoice.getPaymentStatus());
        assertEquals(java.math.BigDecimal.TEN, invoice.getAmount());
    }

    @Test
    void rejectsInvoiceForUnpaidOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.PENDING_PAYMENT);

        assertThrows(IllegalStateException.class,
                () -> service.generate(order, java.math.BigDecimal.TEN));
    }
}
