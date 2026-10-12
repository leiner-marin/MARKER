package application.adapters.useCases;

import application.domain.entities.Order;
import application.domain.entities.Refund;
import application.domain.entities.ReturnRequest;
import application.domain.enums.ReturnStatus;
import application.domain.ports.in.ProcessRefundUseCase;
import application.domain.ports.out.RefundRepositoryPort;
import application.domain.ports.out.ReturnRepositoryPort;
import application.domain.services.RefundService;
import java.math.BigDecimal;

public class DefaultRefundUseCase implements ProcessRefundUseCase {
    private final ReturnRepositoryPort returnRepositoryPort;
    private final RefundRepositoryPort refundRepositoryPort;
    private final RefundService refundService;

    public DefaultRefundUseCase(
            ReturnRepositoryPort returnRepositoryPort,
            RefundRepositoryPort refundRepositoryPort,
            RefundService refundService) {
        this.returnRepositoryPort = returnRepositoryPort;
        this.refundRepositoryPort = refundRepositoryPort;
        this.refundService = refundService;
    }

    @Override
    public Order process(Order order) {
        if (order == null || order.getId() == null) {
            throw new IllegalArgumentException("Order is required.");
        }
        ReturnRequest request = returnRepositoryPort.findByOrderId(order.getId())
                .orElseThrow(() -> new IllegalArgumentException("Return request not found."));

        request.setStatus(ReturnStatus.APPROVED);
        returnRepositoryPort.update(request);

        Refund refund = refundService.process(
                request,
                request.getAmount() == null ? BigDecimal.ZERO : request.getAmount());
        refundRepositoryPort.save(refund);
        return order;
    }
}
