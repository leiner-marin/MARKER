package application.adapters.persistence;

import application.domain.models.SellerModel;
import application.domain.ports.out.SellerPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemorySellerPortAdapter implements SellerPort {
    private final Map<Long, SellerModel> sellers = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public SellerModel save(SellerModel seller) {
        if (seller.getId() == null) {
            seller.setId(nextId.getAndIncrement());
        }
        sellers.put(seller.getId(), seller);
        return seller;
    }

    @Override
    public SellerModel update(SellerModel seller) {
        if (seller.getId() == null) {
            throw new IllegalArgumentException("Seller id is required for update.");
        }
        sellers.put(seller.getId(), seller);
        return seller;
    }

    @Override
    public Optional<SellerModel> findById(Long id) {
        return Optional.ofNullable(sellers.get(id));
    }

    @Override
    public List<SellerModel> findAll() {
        return new ArrayList<>(sellers.values());
    }
}
