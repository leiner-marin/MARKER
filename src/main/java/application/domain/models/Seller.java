package application.domain.models;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User {
    private List<Warehouse> associatedWarehouses;
    private List<Product> productCatalog;
    private LocalDate incorporationDate;
    private String sellerStatus;
}
