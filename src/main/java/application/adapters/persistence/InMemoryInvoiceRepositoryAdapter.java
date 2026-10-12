package application.adapters.persistence;

import application.domain.entities.Invoice;
import application.domain.ports.out.InvoiceRepositoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryInvoiceRepositoryAdapter implements InvoiceRepositoryPort {
    private final Map<Long, Invoice> invoices = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Invoice save(Invoice invoice) {
        if (invoice == null) {
            throw new IllegalArgumentException("Invoice cannot be null.");
        }
        if (invoice.getId() == null) {
            invoice.setId(nextId.getAndIncrement());
        }
        invoices.put(invoice.getId(), invoice);
        return invoice;
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(invoices.get(id));
    }

    @Override
    public Optional<Invoice> findByOrderId(Long orderId) {
        return invoices.values().stream()
                .filter(invoice -> invoice.getOrder() != null
                        && orderId != null
                        && orderId.equals(invoice.getOrder().getId()))
                .findFirst();
    }
}
