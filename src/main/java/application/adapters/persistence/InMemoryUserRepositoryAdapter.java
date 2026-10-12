package application.adapters.persistence;

import application.domain.entities.User;
import application.domain.ports.out.UserRepositoryPort;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepositoryAdapter implements UserRepositoryPort {
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @Override
    public User save(User user) {
        validate(user);
        if (existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        if (user.getId() == null) {
            user.setId(nextId.getAndIncrement());
        } else if (users.containsKey(user.getId())) {
            throw new IllegalArgumentException("User identifier is already registered.");
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        validate(user);
        if (user.getId() == null || !users.containsKey(user.getId())) {
            throw new IllegalArgumentException("User must exist before it can be updated.");
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return id == null ? Optional.empty() : Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return users.values().stream()
                .filter(user -> email.equalsIgnoreCase(user.getEmail()))
                .findFirst();
    }

    @Override
    public boolean existsByEmail(String email) {
        return email != null && users.values().stream()
                .anyMatch(user -> email.equalsIgnoreCase(user.getEmail()));
    }

    private void validate(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
    }
}
