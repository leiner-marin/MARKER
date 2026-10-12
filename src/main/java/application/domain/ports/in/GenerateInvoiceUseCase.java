package application.domain.ports.in;

import application.domain.entities.Invoice;

public interface GenerateInvoiceUseCase {
    Invoice generate(Invoice invoice);
}
