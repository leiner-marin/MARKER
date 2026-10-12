package application.adapters.persistence;

import application.domain.entities.ReturnRequest;
import application.domain.ports.out.ReturnRepositoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryReturnRepositoryAdapter implements ReturnRepositoryPort {
    private final Map<Long, ReturnRequest> returns = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public ReturnRequest save(ReturnRequest request) {
        validate(request);
        if (request.getId() == null) {
            request.setId(nextId.getAndIncrement());
        }
        returns.put(request.getId(), request);
        return request;
    }

    @Override
    public ReturnRequest update(ReturnRequest request) {
        validate(request);
        if (request.getId() == null || !returns.containsKey(request.getId())) {
            throw new IllegalArgumentException("Return request must exist before it can be updated.");
        }
        returns.put(request.getId(), request);
        return request;
    }

    @Override
    public Optional<ReturnRequest> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(returns.get(id));
    }

    @Override
    public Optional<ReturnRequest> findByOrderId(Long orderId) {
        return returns.values().stream()
                .filter(r -> r.getOrder() != null && orderId != null
                        && orderId.equals(r.getOrder().getId()))
                .findFirst();
    }

    private void validate(ReturnRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Return request cannot be null.");
        }
    }
}
