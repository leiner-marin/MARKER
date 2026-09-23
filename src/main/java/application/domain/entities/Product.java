package application.domain.entities;

import application.domain.enums.ProductStatus;
import application.domain.enums.ProductType;
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
    private ProductType productType;
    private List<String> variants;
    private ProductStatus status;
    private Seller seller;
}

