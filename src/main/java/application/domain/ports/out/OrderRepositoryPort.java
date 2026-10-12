package application.domain.ports.out;

import application.domain.entities.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);
    Order update(Order order);
    Optional<Order> findById(Long id);
    List<Order> findByBuyerId(Long buyerId);
    List<Order> findAll();
}
