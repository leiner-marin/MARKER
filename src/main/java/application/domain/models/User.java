package application.domain.models;
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
    private String role;
    private String status;
}
