package application.adapters.useCases;

import application.domain.entities.Refund;
import application.domain.entities.ReturnRequest;
import application.domain.ports.in.ProcessRefundUseCase;
import application.domain.ports.out.RefundRepositoryPort;
import application.domain.ports.out.ReturnRepositoryPort;
import application.domain.services.RefundService;

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
    public Refund process(Refund refund) {
        if (refund == null || refund.getReturnRequest() == null) {
            throw new IllegalArgumentException("Return request is required.");
        }
        ReturnRequest request = returnRepositoryPort.findById(refund.getReturnRequest().getId())
                .orElseThrow(() -> new IllegalArgumentException("Return request not found."));

        return refundRepositoryPort.save(
                refundService.process(
                        request,
                        refund.getAmount() == null ? request.getAmount() : refund.getAmount()));
    }
}
