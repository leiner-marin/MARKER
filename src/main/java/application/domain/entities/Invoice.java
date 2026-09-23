package application.domain.entities;

import application.domain.enums.PaymentStatus;
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
public class Invoice {
    private Long id;
    private Order order;
    private BigDecimal amount;
    private LocalDateTime issueDate;
    private PaymentStatus paymentStatus;
}

