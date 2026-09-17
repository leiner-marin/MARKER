package application.domain.services;

import application.domain.models.Buyer;
import application.domain.models.User;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Buyer registerUser(Buyer user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User email is required.");
        }
        if (user.getStatus() == null || user.getStatus().isBlank()) {
            user.setStatus("ACTIVE");
        }
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("BUYER");
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

    public User updateUserStatus(User user, String newStatus) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        user.setStatus(newStatus);
        return user;
    }
}
