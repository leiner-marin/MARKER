package application.domain.services;

import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.enums.OrderStatus;
import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
import java.time.LocalDateTime;
import java.util.List;

public class OrderService {

    public Order create(Order order) {
        validateForCreation(order);
        if (order.getCreationDate() == null) {
            order.setCreationDate(LocalDateTime.now());
        }
        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.CART);
        }
        return order;
    }

    public Order confirmFromCart(Order order) {
        Order created = create(order);
        if (created.getStatus() != OrderStatus.CART) {
            throw new IllegalStateException("Only cart orders can be confirmed.");
        }
        return updateStatus(created, OrderStatus.PENDING_PAYMENT);
    }

    public Order updateStatus(Order order, OrderStatus newStatus) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("Order status is required.");
        }
        if (order.getStatus() == OrderStatus.FINALIZED) {
            throw new IllegalStateException("A finalized order cannot be modified.");
        }
        if (!isValidTransition(order.getStatus(), newStatus)) {
            throw new IllegalStateException("Invalid order status transition.");
        }
        order.setStatus(newStatus);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public Order finalizeDigitalOrder(Order order) {
        if (order == null || order.getId() == null) {
            throw new IllegalArgumentException("Order is required.");
        }
        if (order.getStatus() != OrderStatus.PAID) {
            throw new IllegalStateException("Only paid orders can be finalized digitally.");
        }
        if (requiresPhysicalDelivery(order)) {
            throw new IllegalStateException("Orders requiring physical delivery cannot be finalized digitally.");
        }
        order.setStatus(OrderStatus.FINALIZED);
        order.setUpdateDate(LocalDateTime.now());
        return order;
    }

    public boolean requiresPhysicalDelivery(Order order) {
        if (order == null || order.getProducts() == null || order.getProducts().isEmpty()) {
            return false;
        }
        return order.getProducts().stream()
                .anyMatch(product -> product != null && product.getProductType() == ProductType.PHYSICAL);
    }

    public boolean isValidTransition(OrderStatus current, OrderStatus target) {
        if (current == null || target == null) {
            return false;
        }
        return switch (current) {
            case CART -> target == OrderStatus.PENDING_PAYMENT;
            case PENDING_PAYMENT -> target == OrderStatus.PAID;
            case PAID -> target == OrderStatus.DISPATCHED;
            case DISPATCHED -> target == OrderStatus.DELIVERED;
            case DELIVERED -> target == OrderStatus.FINALIZED;
            case FINALIZED -> false;
        };
    }

    private void validateForCreation(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getBuyer() == null || order.getBuyer().getId() == null) {
            throw new IllegalArgumentException("Buyer is required for the order.");
        }
        if (order.getStatus() != null && order.getStatus() != OrderStatus.CART) {
            throw new IllegalArgumentException("A new order must start in CART state.");
        }
        if (order.getProducts() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one product.");
        }
        List<Product> products = order.getProducts();
        if (products.stream().anyMatch(product -> product == null
                || product.getId() == null
                || product.getStatus() != ProductStatus.PUBLISHED)) {
            throw new IllegalArgumentException("All order products must be published and identified.");
        }
    }
}
