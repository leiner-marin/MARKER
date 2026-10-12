package application.domain.services;

import application.domain.entities.Order;

public class OrderValidationService {
    public Order validate(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        if (order.getBuyer() == null || order.getBuyer().getId() == null) {
            throw new IllegalArgumentException("Buyer is required.");
        }
        if (order.getProducts() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one product.");
        }
        return order;
    }
}
