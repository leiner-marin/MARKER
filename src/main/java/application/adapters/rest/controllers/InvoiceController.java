package application.adapters.rest.controllers;

import application.domain.entities.Invoice;
import application.domain.ports.in.GenerateInvoiceUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final GenerateInvoiceUseCase generateInvoiceUseCase;

    public InvoiceController(GenerateInvoiceUseCase generateInvoiceUseCase) {
        this.generateInvoiceUseCase = generateInvoiceUseCase;
    }

    @PostMapping
    public ResponseEntity<Invoice> generate(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(generateInvoiceUseCase.generate(invoice));
    }
}
