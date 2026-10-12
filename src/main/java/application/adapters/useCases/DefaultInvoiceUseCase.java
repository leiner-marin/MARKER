package application.adapters.useCases;

import application.domain.entities.Invoice;
import application.domain.ports.in.GenerateInvoiceUseCase;
import application.domain.ports.out.InvoicePort;
import application.domain.ports.out.InvoiceRepositoryPort;
import application.domain.services.InvoiceService;
import java.math.BigDecimal;

public class DefaultInvoiceUseCase implements GenerateInvoiceUseCase {
    private final InvoicePort invoicePort;
    private final InvoiceRepositoryPort invoiceRepositoryPort;
    private final InvoiceService invoiceService;

    public DefaultInvoiceUseCase(
            InvoicePort invoicePort,
            InvoiceRepositoryPort invoiceRepositoryPort,
            InvoiceService invoiceService) {
        this.invoicePort = invoicePort;
        this.invoiceRepositoryPort = invoiceRepositoryPort;
        this.invoiceService = invoiceService;
    }

    @Override
    public Invoice generate(Invoice invoice) {
        if (invoice == null || invoice.getOrder() == null) {
            throw new IllegalArgumentException("Order is required for invoice.");
        }
        BigDecimal amount = invoice.getAmount();
        Invoice generated = invoiceService.generate(invoice.getOrder(), amount);
        Invoice external = invoicePort.generate(generated);
        return invoiceRepositoryPort.save(external);
    }
}
