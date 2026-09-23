package application.domain.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor extends User {
    private List<String> scopeOfQuery;
    private boolean readOnlyPermissions;
}

