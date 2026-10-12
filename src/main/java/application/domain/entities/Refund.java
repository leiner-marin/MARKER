package application.domain.entities;

import application.domain.enums.RefundStatus;
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
public class Refund {
    private Long id;
    private ReturnRequest returnRequest;
    private BigDecimal amount;
    private LocalDateTime date;
    private RefundStatus status;
}
