package application.ports.output;

import application.domain.entities.Invoice;

public interface FacturacionPort {
    Invoice generarFactura(Invoice invoice);
    boolean anularFactura(Long invoiceId);
}
