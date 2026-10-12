package application.domain.ports.out;

import application.domain.entities.User;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    User update(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByIdentityDocument(String identityDocument);
}
