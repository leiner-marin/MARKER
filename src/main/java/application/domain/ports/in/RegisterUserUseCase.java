package application.domain.ports.in;

import application.domain.entities.User;

public interface RegisterUserUseCase {
    User register(User user);
}
