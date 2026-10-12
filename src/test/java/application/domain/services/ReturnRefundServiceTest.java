package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import application.domain.entities.Order;
import application.domain.entities.Product;
import application.domain.entities.Refund;
import application.domain.entities.ReturnRequest;
import application.domain.enums.RefundStatus;
import application.domain.enums.ReturnStatus;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ReturnRefundServiceTest {
    private final ReturnService returnService = new ReturnService();
    private final RefundService refundService = new RefundService();

    @Test
    void createsReturnAndProcessesRefund() {
        Order order = new Order();
        order.setId(1L);

        Product product = new Product();
        product.setId(2L);

        ReturnRequest request = returnService.request(
                order, product, "Product damaged", BigDecimal.TEN);

        assertEquals(ReturnStatus.REQUESTED, request.getStatus());

        request.setId(1L);
        Refund refund = refundService.process(request, BigDecimal.TEN);

        assertEquals(RefundStatus.PROCESSED, refund.getStatus());
        assertEquals(BigDecimal.TEN, refund.getAmount());
    }
}
