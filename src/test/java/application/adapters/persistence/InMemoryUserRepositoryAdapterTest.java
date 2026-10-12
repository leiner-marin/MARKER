package application.adapters.persistence;

import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.User;
import application.domain.enums.UserRole;
import org.junit.jupiter.api.Test;

class InMemoryUserRepositoryAdapterTest {

    @Test
    void rejectsDuplicateEmailIdentityDocumentAndIdentifier() {
        InMemoryUserRepositoryAdapter repository = new InMemoryUserRepositoryAdapter();

        User first = new User();
        first.setIdentityDocument("1001");
        first.setFullName("First");
        first.setEmail("first@example.com");
        first.setRole(UserRole.BUYER);
        first.setId(1L);
        repository.save(first);

        User duplicateEmail = new User();
        duplicateEmail.setIdentityDocument("1002");
        duplicateEmail.setFullName("Second");
        duplicateEmail.setEmail("first@example.com");
        duplicateEmail.setRole(UserRole.BUYER);
        assertThrows(IllegalArgumentException.class, () -> repository.save(duplicateEmail));

        User duplicateIdentity = new User();
        duplicateIdentity.setIdentityDocument("1001");
        duplicateIdentity.setFullName("Third");
        duplicateIdentity.setEmail("third@example.com");
        duplicateIdentity.setRole(UserRole.BUYER);
        assertThrows(IllegalArgumentException.class, () -> repository.save(duplicateIdentity));

        User duplicateId = new User();
        duplicateId.setIdentityDocument("1003");
        duplicateId.setFullName("Fourth");
        duplicateId.setEmail("fourth@example.com");
        duplicateId.setRole(UserRole.BUYER);
        duplicateId.setId(1L);
        assertThrows(IllegalArgumentException.class, () -> repository.save(duplicateId));
    }
}
