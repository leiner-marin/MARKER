package application.domain.services;

import application.domain.entities.User;
import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;

public class UserService {
    public User register(User user) {
        validate(user);
        if (user.getRole() == null) {
            user.setRole(UserRole.BUYER);
        }
        if (user.getStatus() == null) {
            user.setStatus(UserStatus.ACTIVE);
        }
        return user;
    }

    public User updateStatus(User user, UserStatus status) {
        validate(user);
        if (status == null) {
            throw new IllegalArgumentException("User status is required.");
        }
        user.setStatus(status);
        return user;
    }

    public void validate(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getFullName() == null || user.getFullName().isBlank()) {
            throw new IllegalArgumentException("User full name is required.");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User email is required.");
        }
    }
}
