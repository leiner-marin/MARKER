package application.services;

import application.domain.entities.Invoice;
import application.domain.entities.Order;
import application.domain.enums.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    

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
        invoice.setPaymentStatus(PaymentStatus.PENDING);
        return invoice;
    }

    public Invoice registerPayment(Invoice invoice, PaymentStatus paymentStatus) {
        if (invoice == null) {
            throw new IllegalArgumentException("Invoice cannot be null.");
        }
        if (paymentStatus == null) {
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

