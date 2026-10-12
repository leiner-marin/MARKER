package application.domain.services;

import application.domain.entities.User;
import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;

public class UsuarioService {

    public User register(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getFullName() == null || user.getFullName().isBlank()) {
            throw new IllegalArgumentException("User full name is required.");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
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

    public User updateStatus(User user, UserStatus newStatus) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (newStatus == null) {
            throw new IllegalArgumentException("User status is required.");
        }
        user.setStatus(newStatus);
        return user;
    }

    public String getStatus(User user) {
        if (user == null || user.getStatus() == null) {
            return "UNKNOWN";
        }
        return user.getStatus().name();
    }
}
