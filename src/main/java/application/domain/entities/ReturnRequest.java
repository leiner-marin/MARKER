package application.domain.entities;

import application.domain.enums.ReturnStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnRequest {
    private Long id;
    private Order order;
    private Product product;
    private String reason;
    private LocalDateTime requestDate;
    private ReturnStatus status;
    private BigDecimal amount;
}
