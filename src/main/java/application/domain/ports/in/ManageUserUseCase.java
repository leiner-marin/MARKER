package application.domain.ports.in;

import application.domain.entities.User;

public interface ManageUserUseCase {
    User update(User user);
    User findById(Long id);
}
