package application.domain.ports.in;

import application.domain.entities.Order;

public interface RequestReturnUseCase {
    Order request(Order order);
}
