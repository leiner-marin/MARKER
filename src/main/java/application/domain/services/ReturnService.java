package application.domain.services;

import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.entities.ReturnRequest;
import application.domain.enums.ReturnStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReturnService {
    public ReturnRequest request(Order order, Product product, String reason, BigDecimal amount) {
        if (order == null || order.getId() == null) {
            throw new IllegalArgumentException("Order is required for a return.");
        }
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Product is required for a return.");
        }
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Return reason is required.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Return amount must be valid.");
        }

        ReturnRequest request = new ReturnRequest();
        request.setOrder(order);
        request.setProduct(product);
        request.setReason(reason);
        request.setAmount(amount);
        request.setRequestDate(LocalDateTime.now());
        request.setStatus(ReturnStatus.REQUESTED);
        return request;
    }
}
