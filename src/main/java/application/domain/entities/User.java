package application.domain.entities;

import application.domain.enums.UserRole;
import application.domain.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private Long id;
    private String fullName;
    private String email;
    private UserRole role;
    private UserStatus status;
}

