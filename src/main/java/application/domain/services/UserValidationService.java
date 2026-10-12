package application.domain.services;

import application.domain.entities.User;

public class UserValidationService {
    public void validate(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (user.getIdentityDocument() == null || user.getIdentityDocument().isBlank()) {
            throw new IllegalArgumentException("Identity document is required.");
        }
        if (user.getFullName() == null || user.getFullName().isBlank()) {
            throw new IllegalArgumentException("User full name is required.");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User email is required.");
        }
        if (user.getRole() == null) {
            throw new IllegalArgumentException("User role is required.");
        }
    }
}
