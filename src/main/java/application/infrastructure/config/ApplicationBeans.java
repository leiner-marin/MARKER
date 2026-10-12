package application.infrastructure.config;

import application.adapters.persistence.InMemorySellerRepositoryAdapter;
import application.adapters.persistence.InMemoryWarehouseRepositoryAdapter;
import application.adapters.useCases.DefaultInventoryUseCase;
import application.adapters.useCases.DefaultBuyerUseCase;
import application.adapters.persistence.InMemoryBuyerRepositoryAdapter;
import application.adapters.persistence.InMemoryCartRepositoryAdapter;
import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.adapters.useCases.DefaultCartUseCase;
import application.adapters.useCases.DefaultOrderUseCase;
import application.domain.ports.out.CartRepositoryPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.services.CartService;
import application.domain.services.OrderService;
import application.domain.ports.out.BuyerRepositoryPort;
import application.domain.services.CompradorService;
import application.adapters.useCases.DefaultProductUseCase;
import application.adapters.useCases.DefaultSellerUseCase;
import application.adapters.useCases.DefaultWarehouseUseCase;
import application.adapters.useCases.DefaultPaymentUseCase;
import application.adapters.useCases.DefaultInvoiceUseCase;
import application.adapters.useCases.DefaultShipmentUseCase;
import application.adapters.useCases.DefaultDeliveryUseCase;
import application.adapters.useCases.DefaultReturnUseCase;
import application.adapters.useCases.DefaultRefundUseCase;
import application.adapters.useCases.DefaultReportUseCase;
import application.adapters.persistence.InMemoryInvoiceRepositoryAdapter;
import application.adapters.persistence.InMemoryShipmentRepositoryAdapter;
import application.adapters.persistence.InMemoryReturnRepositoryAdapter;
import application.adapters.persistence.InMemoryRefundRepositoryAdapter;
import application.domain.ports.out.InvoicePort;
import application.domain.ports.out.InvoiceRepositoryPort;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.ports.out.ReturnRepositoryPort;
import application.domain.ports.out.RefundRepositoryPort;
import application.domain.ports.out.PaymentPort;
import application.domain.ports.out.ReportPort;
import application.domain.services.PaymentService;
import application.domain.services.InvoiceService;
import application.domain.services.ShipmentService;
import application.domain.services.DeliveryService;
import application.domain.services.ReturnService;
import application.domain.services.RefundService;
import application.adapters.useCases.DefaultUserUseCase;
import application.adapters.persistence.InMemoryUserRepositoryAdapter;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.services.UsuarioService;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.ports.out.SellerRepositoryPort;
import application.domain.ports.out.WarehouseRepositoryPort;
import application.domain.services.SellerOnboardingService;
import application.domain.services.SellerService;
import application.domain.services.WarehouseAssignmentService;
import application.domain.services.WarehouseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {

    @Bean
    public UserRepositoryPort userRepositoryPort() {
        return new InMemoryUserRepositoryAdapter();
    }

    @Bean
    public UsuarioService userService() {
        return new UsuarioService();
    }

    @Bean
    public CartRepositoryPort cartRepositoryPort() {
        return new InMemoryCartRepositoryAdapter();
    }

    @Bean
    public OrderRepositoryPort orderRepositoryPort() {
        return new InMemoryOrderRepositoryAdapter();
    }

    @Bean
    public CartService cartService() {
        return new CartService();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public DefaultCartUseCase defaultCartUseCase(
            CartRepositoryPort cartRepositoryPort,
            CartService cartService) {
        return new DefaultCartUseCase(cartRepositoryPort, cartService);
    }

    @Bean
    public DefaultOrderUseCase defaultOrderUseCase(
            OrderRepositoryPort orderRepositoryPort,
            OrderService orderService) {
        return new DefaultOrderUseCase(orderRepositoryPort, orderService);
    }

    @Bean
    public BuyerRepositoryPort buyerRepositoryPort() {
        return new InMemoryBuyerRepositoryAdapter();
    }

    @Bean
    public CompradorService buyerService() {
        return new CompradorService();
    }

    @Bean
    public DefaultBuyerUseCase defaultBuyerUseCase(
            BuyerRepositoryPort buyerRepositoryPort,
            CompradorService buyerService) {
        return new DefaultBuyerUseCase(buyerRepositoryPort, buyerService);
    }

    @Bean
    public DefaultUserUseCase defaultUserUseCase(
            UserRepositoryPort userRepositoryPort,
            UsuarioService userService) {
        return new DefaultUserUseCase(userRepositoryPort, userService);
    }

    @Bean
    public DefaultProductUseCase defaultProductUseCase(ProductRepositoryPort productRepositoryPort) {
        return new DefaultProductUseCase(productRepositoryPort);
    }

    @Bean
    public DefaultInventoryUseCase defaultInventoryUseCase(InventoryRepositoryPort inventoryRepositoryPort) {
        return new DefaultInventoryUseCase(inventoryRepositoryPort);
    }

    @Bean
    public InvoiceRepositoryPort invoiceRepositoryPort() {
        return new InMemoryInvoiceRepositoryAdapter();
    }

    @Bean
    public ShipmentRepositoryPort shipmentRepositoryPort() {
        return new InMemoryShipmentRepositoryAdapter();
    }

    @Bean
    public ReturnRepositoryPort returnRepositoryPort() {
        return new InMemoryReturnRepositoryAdapter();
    }

    @Bean
    public RefundRepositoryPort refundRepositoryPort() {
        return new InMemoryRefundRepositoryAdapter();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public InvoiceService invoiceService() {
        return new InvoiceService();
    }

    @Bean
    public ShipmentService shipmentService() {
        return new ShipmentService();
    }

    @Bean
    public DeliveryService deliveryService() {
        return new DeliveryService();
    }

    @Bean
    public ReturnService returnService() {
        return new ReturnService();
    }

    @Bean
    public RefundService refundService() {
        return new RefundService();
    }

    @Bean
    public DefaultPaymentUseCase defaultPaymentUseCase(
            PaymentPort paymentPort,
            OrderRepositoryPort orderRepositoryPort,
            PaymentService paymentService) {
        return new DefaultPaymentUseCase(paymentPort, orderRepositoryPort, paymentService);
    }

    @Bean
    public DefaultInvoiceUseCase defaultInvoiceUseCase(
            InvoicePort invoicePort,
            InvoiceRepositoryPort invoiceRepositoryPort,
            InvoiceService invoiceService) {
        return new DefaultInvoiceUseCase(invoicePort, invoiceRepositoryPort, invoiceService);
    }

    @Bean
    public DefaultShipmentUseCase defaultShipmentUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            ShipmentService shipmentService) {
        return new DefaultShipmentUseCase(shipmentRepositoryPort, shipmentService);
    }

    @Bean
    public DefaultDeliveryUseCase defaultDeliveryUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            DeliveryService deliveryService) {
        return new DefaultDeliveryUseCase(shipmentRepositoryPort, deliveryService);
    }

    @Bean
    public DefaultReturnUseCase defaultReturnUseCase(
            ReturnRepositoryPort returnRepositoryPort,
            ReturnService returnService) {
        return new DefaultReturnUseCase(returnRepositoryPort, returnService);
    }

    @Bean
    public DefaultRefundUseCase defaultRefundUseCase(
            ReturnRepositoryPort returnRepositoryPort,
            RefundRepositoryPort refundRepositoryPort,
            RefundService refundService) {
        return new DefaultRefundUseCase(returnRepositoryPort, refundRepositoryPort, refundService);
    }

    @Bean
    public DefaultReportUseCase defaultReportUseCase(ReportPort reportPort) {
        return new DefaultReportUseCase(reportPort);
    }

    @Bean
    public SellerRepositoryPort sellerRepositoryPort() {
        return new InMemorySellerRepositoryAdapter();
    }

    @Bean
    public WarehouseRepositoryPort warehouseRepositoryPort() {
        return new InMemoryWarehouseRepositoryAdapter();
    }

    @Bean
    public SellerService sellerService() {
        return new SellerService();
    }

    @Bean
    public SellerOnboardingService sellerOnboardingService() {
        return new SellerOnboardingService();
    }

    @Bean
    public WarehouseAssignmentService warehouseAssignmentService() {
        return new WarehouseAssignmentService();
    }

    @Bean
    public WarehouseService warehouseService() {
        return new WarehouseService();
    }

    @Bean
    public DefaultSellerUseCase defaultSellerUseCase(
            SellerRepositoryPort sellerRepositoryPort,
            SellerOnboardingService sellerOnboardingService,
            WarehouseAssignmentService warehouseAssignmentService,
            SellerService sellerService) {
        return new DefaultSellerUseCase(
                sellerRepositoryPort,
                sellerOnboardingService,
                warehouseAssignmentService,
                sellerService);
    }

    @Bean
    public DefaultWarehouseUseCase defaultWarehouseUseCase(
            WarehouseRepositoryPort warehouseRepositoryPort,
            WarehouseService warehouseService) {
        return new DefaultWarehouseUseCase(warehouseRepositoryPort, warehouseService);
    }
}
