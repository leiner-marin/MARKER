package application.adapters.useCases;

import application.domain.entities.User;
import application.domain.ports.in.ManageUserUseCase;
import application.domain.ports.in.RegisterUserUseCase;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.services.UsuarioService;

public class DefaultUserUseCase implements RegisterUserUseCase, ManageUserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    private final UsuarioService userService;

    public DefaultUserUseCase(UserRepositoryPort userRepositoryPort, UsuarioService userService) {
        this.userRepositoryPort = userRepositoryPort;
        this.userService = userService;
    }

    @Override
    public User register(User user) {
        return userRepositoryPort.save(userService.register(user));
    }

    @Override
    public User update(User user) {
        userService.register(user);
        return userRepositoryPort.update(user);
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
