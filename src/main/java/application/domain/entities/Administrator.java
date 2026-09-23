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
public class Administrator extends User {
    private List<Seller> administeredSellers;
    private List<Warehouse> administeredWarehouses;
    private List<String> refundPermissions;
}

