package application.domain.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Long id;
    private Product product;
    private Warehouse warehouse;
    private Integer availableQuantity;
    private String movementType; // INGRESS / RESERVE / OUT / ADJUST / RETURN
    private LocalDateTime movementDate;
}
