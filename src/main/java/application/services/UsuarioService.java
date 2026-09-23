package application.services;

import application.domain.entities.Buyer;
import application.domain.entities.User;
import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Buyer registerUser(Buyer user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User email is required.");
        }
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.ACTIVE);
        }
        if (user.getRole() == null) {
            user.setRole(UserRole.BUYER);
        }
        return user;
    }

    public boolean authenticateUser(String email, String password) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return password != null && !password.isBlank();
    }

    public String getUserStatus(User user) {
        if (user == null) {
            return "UNKNOWN";
        }
        return Objects.toString(user.getStatus(), "UNKNOWN");
    }

    public User updateUserStatus(User user, UserStatus newStatus) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("User status is required.");
        }
        user.setStatus(newStatus);
        return user;
    }
}

