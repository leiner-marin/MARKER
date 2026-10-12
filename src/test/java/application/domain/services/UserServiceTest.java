package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.User;
import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    private final UserService service = new UserService();

    @Test
    void registersUserWithExplicitRoleAndActiveStatus() {
        User user = new User();
        user.setFullName("Test User");
        user.setEmail("user@example.com");
        user.setRole(UserRole.BUYER);

        User result = service.register(user);

        assertEquals(UserRole.BUYER, result.getRole());
        assertEquals(UserStatus.ACTIVE, result.getStatus());
    }

    @Test
    void rejectsUserWithoutRole() {
        User user = new User();
        user.setFullName("Test User");
        user.setEmail("user@example.com");

        assertThrows(IllegalArgumentException.class, () -> service.register(user));
    }
}
