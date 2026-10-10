package application.domain.ports.out;

import application.domain.entities.Buyer;
import application.domain.entities.Order;
import java.util.Optional;

public interface CartRepositoryPort {
    Order save(Order cart);
    Order update(Order cart);
    Optional<Order> findById(Long id);
    Optional<Order> findByBuyer(Buyer buyer);
}