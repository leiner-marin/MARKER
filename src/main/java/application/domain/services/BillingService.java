package application.domain.services;

import application.domain.models.Invoice;
import application.domain.models.Order;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    public Invoice generateInvoice(Order order, BigDecimal total) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (total == null || total.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invoice total must be valid.");
        }

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setAmount(total);
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setPaymentStatus("PENDING");
        return invoice;
    }

    public Invoice registerPayment(Invoice invoice, String paymentStatus) {
        if (invoice == null) {
            throw new IllegalArgumentException("Invoice cannot be null.");
        }
        if (paymentStatus == null || paymentStatus.isBlank()) {
            throw new IllegalArgumentException("Payment status is required.");
        }
        invoice.setPaymentStatus(paymentStatus);
        return invoice;
    }

    public boolean isValidAmount(Invoice invoice) {
        if (invoice == null || invoice.getAmount() == null) {
            return false;
        }
        return invoice.getAmount().compareTo(BigDecimal.ZERO) >= 0;
    }
}
