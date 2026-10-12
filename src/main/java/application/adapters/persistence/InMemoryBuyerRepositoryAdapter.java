package application.adapters.persistence;

import application.domain.entities.Buyer;
import application.domain.ports.out.BuyerRepositoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryBuyerRepositoryAdapter implements BuyerRepositoryPort {
    private final Map<Long, Buyer> buyers = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Buyer save(Buyer buyer) {
        validate(buyer);
        if (buyer.getId() == null) {
            buyer.setId(nextId.getAndIncrement());
        }
        buyers.put(buyer.getId(), buyer);
        return buyer;
    }

    @Override
    public Buyer update(Buyer buyer) {
        validate(buyer);
        if (buyer.getId() == null || !buyers.containsKey(buyer.getId())) {
            throw new IllegalArgumentException("Buyer must exist before it can be updated.");
        }
        buyers.put(buyer.getId(), buyer);
        return buyer;
    }

    @Override
    public Optional<Buyer> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(buyers.get(id));
    }

    private void validate(Buyer buyer) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
    }
}
