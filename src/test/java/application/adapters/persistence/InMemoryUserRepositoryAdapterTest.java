package application.adapters.persistence;

import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.User;
import application.domain.enums.UserRole;
import org.junit.jupiter.api.Test;

class InMemoryUserRepositoryAdapterTest {

    @Test
    void rejectsDuplicateEmailAndIdentifier() {
        InMemoryUserRepositoryAdapter repository = new InMemoryUserRepositoryAdapter();

        User first = new User();
        first.setFullName("First");
        first.setEmail("first@example.com");
        first.setRole(UserRole.BUYER);
        first.setId(1L);
        repository.save(first);

        User duplicateEmail = new User();
        duplicateEmail.setFullName("Second");
        duplicateEmail.setEmail("first@example.com");
        duplicateEmail.setRole(UserRole.BUYER);
        assertThrows(IllegalArgumentException.class, () -> repository.save(duplicateEmail));

        User duplicateId = new User();
        duplicateId.setFullName("Third");
        duplicateId.setEmail("third@example.com");
        duplicateId.setRole(UserRole.BUYER);
        duplicateId.setId(1L);
        assertThrows(IllegalArgumentException.class, () -> repository.save(duplicateId));
    }
}
