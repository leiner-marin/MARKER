package application.domain.services;

import application.domain.entities.User;
import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ValidacionUsuarioService {

    public boolean validarEmail(String email) {
        return email != null && !email.isBlank() && email.contains("@");
    }

    public User validarUsuario(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getFullName() == null || user.getFullName().isBlank()) {
            throw new IllegalArgumentException("User full name is required.");
        }
        if (!validarEmail(user.getEmail())) {
            throw new IllegalArgumentException("User email is required.");
        }
        if (user.getRole() == null) {
            user.setRole(UserRole.BUYER);
        }
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.ACTIVE);
        }
        return user;
    }

    public String obtenerEstadoUsuario(User user) {
        return Objects.toString(user == null ? null : user.getStatus(), "UNKNOWN");
    }
}
