package application.domain.ports;

import application.domain.models.Invoice;
import application.domain.models.Order;
import java.math.BigDecimal;

public interface BillingPort {
    Invoice generateInvoice(Order order, BigDecimal total);
    Invoice registerPayment(Invoice invoice, String paymentStatus);
    boolean isValidAmount(Invoice invoice);
}
