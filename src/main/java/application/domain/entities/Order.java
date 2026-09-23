package application.domain.entities;

import application.domain.enums.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Buyer buyer;
    private List<Product> products;
    private OrderStatus status;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}

