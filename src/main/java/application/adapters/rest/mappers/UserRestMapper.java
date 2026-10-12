package application.adapters.rest.mappers;

import application.adapters.rest.dtos.user.UserRequest;
import application.adapters.rest.dtos.user.UserResponse;
import application.domain.entities.User;
import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;

public final class UserRestMapper {
    private UserRestMapper() {}

    public static User toDomain(UserRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("User request is required.");
        }
        User user = new User();
        user.setIdentityDocument(request.identityDocument());
        user.setFullName(request.fullName());
        user.setEmail(request.email());
        if (request.role() != null && !request.role().isBlank()) {
            user.setRole(UserRole.valueOf(request.role().toUpperCase()));
        }
        if (request.status() != null && !request.status().isBlank()) {
            user.setStatus(UserStatus.valueOf(request.status().toUpperCase()));
        }
        return user;
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getIdentityDocument(),
                user.getFullName(),
                user.getEmail(),
                user.getRole() == null ? null : user.getRole().name(),
                user.getStatus() == null ? null : user.getStatus().name());
    }
}
