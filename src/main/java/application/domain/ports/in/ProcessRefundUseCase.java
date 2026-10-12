package application.domain.ports.in;

import application.domain.entities.Refund;

public interface ProcessRefundUseCase {
    Refund process(Refund refund);
}
