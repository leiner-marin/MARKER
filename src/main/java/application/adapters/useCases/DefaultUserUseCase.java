package application.adapters.useCases;

import application.domain.entities.User;
import application.domain.ports.in.ManageUserUseCase;
import application.domain.ports.in.RegisterUserUseCase;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.services.UserService;
import application.domain.services.UserValidationService;

public class DefaultUserUseCase implements RegisterUserUseCase, ManageUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final UserService userService;
    private final UserValidationService userValidationService;

    public DefaultUserUseCase(
            UserRepositoryPort userRepositoryPort,
            UserService userService,
            UserValidationService userValidationService) {
        this.userRepositoryPort = userRepositoryPort;
        this.userService = userService;
        this.userValidationService = userValidationService;
    }

    @Override
    public User register(User user) {
        userValidationService.validate(user);
        if (userRepositoryPort.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        if (userRepositoryPort.existsByIdentityDocument(user.getIdentityDocument())) {
            throw new IllegalArgumentException("Identity document is already registered.");
        }
        return userRepositoryPort.save(userService.register(user));
    }

    @Override
    public User update(User user) {
        userValidationService.validate(user);
        User current = findById(user.getId());
        if (!current.getEmail().equalsIgnoreCase(user.getEmail())
                && userRepositoryPort.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        if (!current.getIdentityDocument().equalsIgnoreCase(user.getIdentityDocument())
                && userRepositoryPort.existsByIdentityDocument(user.getIdentityDocument())) {
            throw new IllegalArgumentException("Identity document is already registered.");
        }
        return userRepositoryPort.update(userService.update(user));
    }

    @Override
    public User findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User id is required.");
        }
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
    }
}
