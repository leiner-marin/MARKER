package application.ports.output;

import application.domain.entities.Invoice;
import java.util.Optional;

public interface FacturaRepository {
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(Long id);
    Optional<Invoice> findByOrderId(Long orderId);
}
