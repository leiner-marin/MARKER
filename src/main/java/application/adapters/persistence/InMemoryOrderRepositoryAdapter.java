package application.adapters.persistence;

import application.domain.entities.Order;
import application.domain.ports.out.OrderRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryOrderRepositoryAdapter implements OrderRepositoryPort {
    private final Map<Long, Order> orders = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public Order save(Order order) {
        validate(order);
        if (order.getId() == null) {
            order.setId(nextId.getAndIncrement());
        }
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Order update(Order order) {
        validate(order);
        if (order.getId() == null || !orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Order must exist before it can be updated.");
        }
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<Order> findByBuyerId(Long buyerId) {
        if (buyerId == null) {
            return List.of();
        }
        return new ArrayList<>(orders.values().stream()
                .filter(order -> order.getBuyer() != null
                        && buyerId.equals(order.getBuyer().getId()))
                .toList());
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    private void validate(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
    }
}
