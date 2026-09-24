package application.ports.output;

import application.domain.entities.User;
import java.util.Optional;

public interface UsuarioRepository {
    User save(User user);
    User update(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
