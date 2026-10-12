package application.domain.services;

import application.domain.enums.OrderStatus;

public class OrderStatusService {
    public boolean canTransition(OrderStatus current, OrderStatus target) {
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
            default -> false;
        };
    }
}
