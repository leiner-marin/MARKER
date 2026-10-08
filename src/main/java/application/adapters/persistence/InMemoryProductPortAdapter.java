package application.adapters.persistence;

import application.domain.models.ProductModel;
import application.domain.ports.out.ProductPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryProductPortAdapter implements ProductPort {
    private final Map<Long, ProductModel> products = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public ProductModel save(ProductModel product) {
        if (product.getId() == null) {
            product.setId(nextId.getAndIncrement());
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public ProductModel update(ProductModel product) {
        if (product.getId() == null) {
            throw new IllegalArgumentException("Product id is required for update.");
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<ProductModel> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<ProductModel> findBySellerId(Long sellerId) {
        return products.values().stream()
                .filter(product -> sellerId.equals(product.getSellerId()))
                .toList();
    }
}
