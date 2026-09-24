package application.ports.output;

import application.domain.entities.Order;
import java.util.Optional;

public interface DevolucionRepository {
    Order save(Order refundRequest);
    Order update(Order refundRequest);
    Optional<Order> findById(Long id);
    Optional<Order> findByOrderId(Long orderId);
}
