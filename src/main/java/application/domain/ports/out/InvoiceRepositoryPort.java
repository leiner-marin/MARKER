package application.domain.ports.out;

import application.domain.entities.Invoice;
import java.util.Optional;

public interface InvoiceRepositoryPort {
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(Long id);
    Optional<Invoice> findByOrderId(Long orderId);
}