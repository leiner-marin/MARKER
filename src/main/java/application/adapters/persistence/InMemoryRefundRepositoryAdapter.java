package application.adapters.persistence;

import application.domain.entities.Refund;
import application.domain.ports.out.RefundRepositoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRefundRepositoryAdapter implements RefundRepositoryPort {
    private final Map<Long, Refund> refunds = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Refund save(Refund refund) {
        validate(refund);
        if (refund.getId() == null) {
            refund.setId(nextId.getAndIncrement());
        }
        refunds.put(refund.getId(), refund);
        return refund;
    }

    @Override
    public Refund update(Refund refund) {
        validate(refund);
        if (refund.getId() == null || !refunds.containsKey(refund.getId())) {
            throw new IllegalArgumentException("Refund must exist before it can be updated.");
        }
        refunds.put(refund.getId(), refund);
        return refund;
    }

    @Override
    public Optional<Refund> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(refunds.get(id));
    }

    @Override
    public Optional<Refund> findByReturnId(Long returnId) {
        return refunds.values().stream()
                .filter(r -> r.getReturnRequest() != null && returnId != null
                        && returnId.equals(r.getReturnRequest().getId()))
                .findFirst();
    }

    private void validate(Refund refund) {
        if (refund == null) {
            throw new IllegalArgumentException("Refund cannot be null.");
        }
    }
