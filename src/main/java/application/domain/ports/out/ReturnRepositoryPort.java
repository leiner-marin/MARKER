package application.domain.ports.out;

import application.domain.entities.Order;
import java.util.Optional;

public interface ReturnRepositoryPort {
    Order save(Order returnRequest);
    Order update(Order returnRequest);
    Optional<Order> findById(Long id);
    Optional<Order> findByOrderId(Long orderId);
}