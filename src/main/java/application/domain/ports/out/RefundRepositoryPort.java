package application.domain.ports.out;

import application.domain.entities.Order;
import java.util.Optional;

public interface RefundRepositoryPort {
    Order save(Order refund);
    Order update(Order refund);
    Optional<Order> findById(Long id);
    Optional<Order> findByReturnId(Long returnId);
}