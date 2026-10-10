package application.domain.ports.in;

import application.domain.entities.Order;

public interface ProcessRefundUseCase {
    Order process(Order order);
}
