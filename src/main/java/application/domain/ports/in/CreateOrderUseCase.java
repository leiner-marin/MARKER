package application.domain.ports.in;

import application.domain.entities.Order;

public interface CreateOrderUseCase {
    Order create(Order order);
}
