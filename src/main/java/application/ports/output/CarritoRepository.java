package application.ports.output;

import application.domain.entities.Order;
import java.util.Optional;

public interface CarritoRepository {
    Order save(Order cart);
    Order update(Order cart);
    Optional<Order> findById(Long id);
    Optional<Order> findByBuyerId(Long buyerId);
}
