package application.domain.entities;

import application.domain.enums.WarehouseType;
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
    private WarehouseType type;
    private Seller ownerSeller;
}

