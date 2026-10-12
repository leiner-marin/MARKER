package application.domain.services;

import application.domain.entities.Invoice;
import application.domain.entities.Order;
import application.domain.enums.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceService {
    public Invoice generate(Order order, BigDecimal amount) {
        if (order == null || order.getId() == null) {
            throw new IllegalArgumentException("Order is required.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invoice amount must be valid.");
        }

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setAmount(amount);
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setPaymentStatus(PaymentStatus.PENDING);
        return invoice;
    }
}
