package application.infrastructure.external;

import application.domain.entities.Invoice;
import application.domain.ports.out.InvoicePort;
import org.springframework.stereotype.Component;

@Component
public class InMemoryInvoiceAdapter implements InvoicePort {
    @Override
    public Invoice generate(Invoice invoice) {
        return invoice;
    }
}
