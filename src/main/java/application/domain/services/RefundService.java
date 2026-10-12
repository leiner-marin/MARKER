package application.domain.services;

import application.domain.entities.Refund;
import application.domain.entities.ReturnRequest;
import application.domain.enums.RefundStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RefundService {
    public Refund process(ReturnRequest request, BigDecimal amount) {
        if (request == null || request.getId() == null) {
            throw new IllegalArgumentException("Return request is required.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Refund amount must be valid.");
        }

        Refund refund = new Refund();
        refund.setReturnRequest(request);
        refund.setAmount(amount);
        refund.setDate(LocalDateTime.now());
        refund.setStatus(RefundStatus.PROCESSED);
        return refund;
    }
}
