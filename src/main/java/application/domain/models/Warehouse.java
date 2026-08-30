package application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private Long id;
    private String name;
    private String location;
    private String type; // Marketplace / Seller
    private Seller ownerSeller;
}
