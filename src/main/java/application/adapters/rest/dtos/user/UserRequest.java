package application.adapters.rest.dtos.user;

public record UserRequest(
        String identityDocument,
        String fullName,
        String email,
        String role,
        String status) {
}
