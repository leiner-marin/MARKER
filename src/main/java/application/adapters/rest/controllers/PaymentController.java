package application.adapters.rest.controllers;

import application.domain.ports.in.ProcessPaymentUseCase;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final ProcessPaymentUseCase processPaymentUseCase;

    public PaymentController(ProcessPaymentUseCase processPaymentUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
    }

    @PostMapping
    public ResponseEntity<String> process(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(
                processPaymentUseCase.processPayment(request.orderId(), request.amount()));
    }

    public record PaymentRequest(String orderId, BigDecimal amount) {}
}
