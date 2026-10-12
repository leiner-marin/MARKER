package application.adapters.rest.dtos.user;

public record UserResponse(
        Long id,
        String identityDocument,
        String fullName,
        String email,
        String role,
        String status) {
}
