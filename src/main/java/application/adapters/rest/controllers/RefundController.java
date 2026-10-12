package application.adapters.rest.controllers;

import application.domain.entities.Order;
import application.domain.ports.in.ProcessRefundUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {
    private final ProcessRefundUseCase processRefundUseCase;

    public RefundController(ProcessRefundUseCase processRefundUseCase) {
        this.processRefundUseCase = processRefundUseCase;
    }

    @PostMapping
    public ResponseEntity<Order> process(@RequestBody Order order) {
        return ResponseEntity.ok(processRefundUseCase.process(order));
    }
}
