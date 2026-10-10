package application.domain.ports.out;

import application.domain.entities.Invoice;

public interface InvoicePort {
    Invoice generate(Invoice invoice);
}