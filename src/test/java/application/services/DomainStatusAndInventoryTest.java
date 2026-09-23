package application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import application.domain.entities.Buyer;
import application.domain.entities.Invoice;
import application.domain.entities.Inventory;
import application.domain.entities.Order;
import application.domain.entities.Shipment;
import application.domain.enums.CommercialStatus;
import application.domain.enums.PaymentStatus;
import application.domain.enums.ShipmentStatus;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class DomainStatusAndInventoryTest {
    private final CompradorService buyerService = new CompradorService();
    private final FacturaService invoiceService = new FacturaService();
    private final EnvioService shipmentService = new EnvioService();
    private final InventarioService inventoryService = new InventarioService();

    @Test
    void assignsTypedDefaultStatuses() {
        Buyer buyer = new Buyer();
        buyer.setEmail("buyer@example.com");
        assertEquals(CommercialStatus.ACTIVE, buyerService.registerBuyer(buyer).getCommercialStatus());

        Invoice invoice = invoiceService.generateInvoice(new Order(), BigDecimal.TEN);
        assertEquals(PaymentStatus.PENDING, invoice.getPaymentStatus());

        Shipment shipment = shipmentService.createShipment(new Shipment());
        assertEquals(null, shipment.getShipmentStatus());
    }

    @Test
    void updatesTypedStatuses() {
        Invoice invoice = new Invoice();
        invoiceService.registerPayment(invoice, PaymentStatus.PAID);
        assertEquals(PaymentStatus.PAID, invoice.getPaymentStatus());

        Shipment shipment = new Shipment();
        shipmentService.updateShipmentStatus(shipment, ShipmentStatus.IN_TRANSIT);
        assertEquals(ShipmentStatus.IN_TRANSIT, shipment.getShipmentStatus());
    }

    @Test
    void rejectsInventoryAdjustmentThatWouldBecomeNegative() {
        Inventory inventory = new Inventory();
        inventory.setAvailableQuantity(2);

        assertThrows(IllegalStateException.class,
                () -> inventoryService.adjustInventory(inventory, -3));
        assertEquals(2, inventory.getAvailableQuantity());
    }
}