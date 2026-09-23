package application.infrastructure.repositories;

import application.ports.out.ProductRepository;
import application.domain.entities.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final ConcurrentMap<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId.getAndIncrement());
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Product update(Product product) {
        if (product.getId() == null || !products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product must exist before it can be updated.");
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream()
            .sorted(Comparator.comparing(product -> product.getId(),
                Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
    }

    @Override
    public List<Product> findBySellerId(Long sellerId) {
        if (sellerId == null) {
            return new ArrayList<>();
        }
        return products.values().stream()
                .filter(product -> product.getSeller() != null
                        && sellerId.equals(product.getSeller().getId()))
                .sorted(Comparator.comparing(product -> product.getId(),
                    Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
    }
}
