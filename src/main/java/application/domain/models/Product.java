package application.domain.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String productType; // Physical / Digital
    private List<String> variants;
    private String status; // Published / Suspended / Discontinued
    private Seller seller;
}
