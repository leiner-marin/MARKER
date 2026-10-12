package application.adapters.persistence;

import application.domain.entities.Payment;
import application.domain.ports.out.PaymentRepositoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryPaymentRepositoryAdapter implements PaymentRepositoryPort {
    private final Map<Long, Payment> payments = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Payment save(Payment payment) {
        if (payment == null || payment.getOrder() == null || payment.getOrder().getId() == null) {
            throw new IllegalArgumentException("Payment and order are required.");
        }
        if (payment.getId() == null) {
            payment.setId(nextId.getAndIncrement());
        }
        payments.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(payments.get(id));
    }

    @Override
    public Optional<Payment> findByOrderId(Long orderId) {
        if (orderId == null) {
            return Optional.empty();
        }
        return payments.values().stream()
                .filter(payment -> payment.getOrder() != null
                        && orderId.equals(payment.getOrder().getId()))
                .findFirst();
    }
}
