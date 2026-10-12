package application.adapters.rest.controllers;

import application.adapters.rest.dtos.user.UserRequest;
import application.adapters.rest.dtos.user.UserResponse;
import application.adapters.rest.mappers.UserRestMapper;
import application.domain.entities.User;
import application.domain.ports.in.ManageUserUseCase;
import application.domain.ports.in.RegisterUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;
    private final ManageUserUseCase manageUserUseCase;

    public UserController(
            RegisterUserUseCase registerUserUseCase,
            ManageUserUseCase manageUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.manageUserUseCase = manageUserUseCase;
    }

    @PostMapping
    public UserResponse register(@RequestBody UserRequest request) {
        return UserRestMapper.toResponse(
                registerUserUseCase.register(UserRestMapper.toDomain(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                UserRestMapper.toResponse(manageUserUseCase.findById(id)));
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest request) {
        User user = UserRestMapper.toDomain(request);
        user.setId(id);
        return UserRestMapper.toResponse(manageUserUseCase.update(user));
    }
}
