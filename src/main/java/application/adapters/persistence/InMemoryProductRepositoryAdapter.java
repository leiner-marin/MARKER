package application.adapters.persistence;

import application.domain.entities.Product;
import application.domain.ports.out.ProductRepositoryPort;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryProductRepositoryAdapter implements ProductRepositoryPort {
    private final ConcurrentMap<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Product save(Product product) {
        validate(product);
        if (product.getId() == null) {
            product.setId(nextId.getAndIncrement());
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Product update(Product product) {
        validate(product);
        if (product.getId() == null || !products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product must exist before it can be updated.");
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream()
                .sorted(Comparator.comparing(Product::getId, Comparator.nullsLast(Comparator.naturalOrder())))
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
                .sorted(Comparator.comparing(Product::getId, Comparator.nullsLast(Comparator.naturalOrder())))
                .toList();
    }

    private void validate(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
    }
}
