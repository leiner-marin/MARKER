package application.domain.ports.out;

import application.domain.entities.Buyer;
import application.domain.entities.Cart;
import java.util.Optional;

public interface CartRepositoryPort {
    Cart save(Cart cart);
    Cart update(Cart cart);
    Optional<Cart> findById(Long id);
    Optional<Cart> findByBuyer(Buyer buyer);
}
