package application.domain.ports.in;

import application.domain.entities.Order;

public interface ManageOrderUseCase {
    Order updateStatus(Order order);
    Order findById(Long id);
}
