package application.infrastructure.config;

import application.adapters.persistence.InMemoryBuyerRepositoryAdapter;
import application.adapters.persistence.InMemoryCartRepositoryAdapter;
import application.adapters.persistence.InMemoryInventoryMovementRepositoryAdapter;
import application.adapters.persistence.InMemoryInvoiceRepositoryAdapter;
import application.adapters.persistence.InMemoryOrderRepositoryAdapter;
import application.adapters.persistence.InMemoryPaymentRepositoryAdapter;
import application.adapters.persistence.InMemoryRefundRepositoryAdapter;
import application.adapters.persistence.InMemoryReturnRepositoryAdapter;
import application.adapters.persistence.InMemorySellerRepositoryAdapter;
import application.adapters.persistence.InMemoryShipmentRepositoryAdapter;
import application.adapters.persistence.InMemoryUserRepositoryAdapter;
import application.adapters.persistence.InMemoryWarehouseRepositoryAdapter;
import application.adapters.useCases.DefaultBuyerUseCase;
import application.adapters.useCases.DefaultCartUseCase;
import application.adapters.useCases.DefaultCatalogUseCase;
import application.adapters.useCases.DefaultDeliveryUseCase;
import application.adapters.useCases.DefaultInventoryUseCase;
import application.adapters.useCases.DefaultInvoiceUseCase;
import application.adapters.useCases.DefaultOrderUseCase;
import application.adapters.useCases.DefaultPaymentUseCase;
import application.adapters.useCases.DefaultProductUseCase;
import application.adapters.useCases.DefaultRefundUseCase;
import application.adapters.useCases.DefaultReportUseCase;
import application.adapters.useCases.DefaultReserveInventoryUseCase;
import application.adapters.useCases.DefaultReturnUseCase;
import application.adapters.useCases.DefaultSellerUseCase;
import application.adapters.useCases.DefaultShipmentUseCase;
import application.adapters.useCases.DefaultUserUseCase;
import application.adapters.useCases.DefaultWarehouseUseCase;
import application.domain.ports.out.BuyerRepositoryPort;
import application.domain.ports.out.CartRepositoryPort;
import application.domain.ports.out.InventoryMovementRepositoryPort;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.InvoicePort;
import application.domain.ports.out.InvoiceRepositoryPort;
import application.domain.ports.out.LogisticsPort;
import application.domain.ports.out.OrderRepositoryPort;
import application.domain.ports.out.PaymentPort;
import application.domain.ports.out.PaymentRepositoryPort;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.ports.out.RefundRepositoryPort;
import application.domain.ports.out.ReportPort;
import application.domain.ports.out.ReturnRepositoryPort;
import application.domain.ports.out.SellerRepositoryPort;
import application.domain.ports.out.ShipmentRepositoryPort;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.ports.out.WarehouseRepositoryPort;
import application.domain.services.AdministrativeReportService;
import application.domain.services.BuyerAddressService;
import application.domain.services.BuyerService;
import application.domain.services.CartService;
import application.domain.services.CatalogService;
import application.domain.services.DeliveryService;
import application.domain.services.InventoryAdjustmentService;
import application.domain.services.InventoryMovementService;
import application.domain.services.InventoryReservationService;
import application.domain.services.InventoryService;
import application.domain.services.InvoiceService;
import application.domain.services.OrderPreparationService;
import application.domain.services.OrderService;
import application.domain.services.PaymentService;
import application.domain.services.ProductPublicationService;
import application.domain.services.ProductService;
import application.domain.services.ProductVariantService;
import application.domain.services.RefundService;
import application.domain.services.ReturnService;
import application.domain.services.SellerOnboardingService;
import application.domain.services.SellerService;
import application.domain.services.ShipmentService;
import application.domain.services.UserService;
import application.domain.services.UserValidationService;
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
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public UserValidationService userValidationService() {
        return new UserValidationService();
    }

    @Bean
    public BuyerRepositoryPort buyerRepositoryPort() {
        return new InMemoryBuyerRepositoryAdapter();
    }

    @Bean
    public BuyerService buyerService() {
        return new BuyerService();
    }

    @Bean
    public BuyerAddressService buyerAddressService() {
        return new BuyerAddressService();
    }

    @Bean
    public CartRepositoryPort cartRepositoryPort() {
        return new InMemoryCartRepositoryAdapter();
    }

    @Bean
    public CartService cartService() {
        return new CartService();
    }

    @Bean
    public OrderRepositoryPort orderRepositoryPort() {
        return new InMemoryOrderRepositoryAdapter();
    }

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public OrderPreparationService orderPreparationService() {
        return new OrderPreparationService();
    }

    @Bean
    public ProductService productService() {
        return new ProductService();
    }

    @Bean
    public ProductPublicationService productPublicationService() {
        return new ProductPublicationService();
    }

    @Bean
    public ProductVariantService productVariantService() {
        return new ProductVariantService();
    }

    @Bean
    public CatalogService catalogService() {
        return new CatalogService();
    }

    @Bean
    public InventoryService inventoryService() {
        return new InventoryService();
    }

    @Bean
    public InventoryAdjustmentService inventoryAdjustmentService() {
        return new InventoryAdjustmentService();
    }

    @Bean
    public InventoryMovementService inventoryMovementService() {
        return new InventoryMovementService();
    }

    @Bean
    public InventoryReservationService inventoryReservationService() {
        return new InventoryReservationService();
    }

    @Bean
    public InventoryMovementRepositoryPort inventoryMovementRepositoryPort() {
        return new InMemoryInventoryMovementRepositoryAdapter();
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
    public PaymentRepositoryPort paymentRepositoryPort() {
        return new InMemoryPaymentRepositoryAdapter();
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
    public AdministrativeReportService administrativeReportService() {
        return new AdministrativeReportService();
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
    public DefaultUserUseCase defaultUserUseCase(
            UserRepositoryPort userRepositoryPort,
            UserService userService,
            UserValidationService userValidationService) {
        return new DefaultUserUseCase(userRepositoryPort, userService, userValidationService);
    }

    @Bean
    public DefaultBuyerUseCase defaultBuyerUseCase(
            BuyerRepositoryPort buyerRepositoryPort,
            UserRepositoryPort userRepositoryPort,
            BuyerService buyerService,
            BuyerAddressService buyerAddressService) {
        return new DefaultBuyerUseCase(
                buyerRepositoryPort,
                userRepositoryPort,
                buyerService,
                buyerAddressService);
    }

    @Bean
    public DefaultSellerUseCase defaultSellerUseCase(
            SellerRepositoryPort sellerRepositoryPort,
            UserRepositoryPort userRepositoryPort,
            WarehouseRepositoryPort warehouseRepositoryPort,
            SellerOnboardingService sellerOnboardingService,
            WarehouseAssignmentService warehouseAssignmentService,
            SellerService sellerService) {
        return new DefaultSellerUseCase(
                sellerRepositoryPort,
                userRepositoryPort,
                warehouseRepositoryPort,
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

    @Bean
    public DefaultProductUseCase defaultProductUseCase(
            ProductRepositoryPort productRepositoryPort,
            ProductService productService,
            ProductPublicationService productPublicationService,
            ProductVariantService productVariantService) {
        return new DefaultProductUseCase(
                productRepositoryPort,
                productService,
                productPublicationService,
                productVariantService);
    }

    @Bean
    public DefaultCatalogUseCase defaultCatalogUseCase(
            ProductRepositoryPort productRepositoryPort,
            CatalogService catalogService) {
        return new DefaultCatalogUseCase(productRepositoryPort, catalogService);
    }

    @Bean
    public DefaultInventoryUseCase defaultInventoryUseCase(
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort,
            InventoryService inventoryService,
            InventoryAdjustmentService inventoryAdjustmentService,
            InventoryMovementService inventoryMovementService) {
        return new DefaultInventoryUseCase(
                inventoryRepositoryPort,
                inventoryMovementRepositoryPort,
                inventoryService,
                inventoryAdjustmentService,
                inventoryMovementService);
    }

    @Bean
    public DefaultReserveInventoryUseCase defaultReserveInventoryUseCase(
            InventoryRepositoryPort inventoryRepositoryPort,
            InventoryMovementRepositoryPort inventoryMovementRepositoryPort,
            InventoryReservationService inventoryReservationService) {
        return new DefaultReserveInventoryUseCase(
                inventoryRepositoryPort,
                inventoryMovementRepositoryPort,
                inventoryReservationService);
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
    public DefaultPaymentUseCase defaultPaymentUseCase(
            PaymentPort paymentPort,
            PaymentRepositoryPort paymentRepositoryPort,
            OrderRepositoryPort orderRepositoryPort,
            PaymentService paymentService,
            OrderService orderService) {
        return new DefaultPaymentUseCase(
                paymentPort,
                paymentRepositoryPort,
                orderRepositoryPort,
                paymentService,
                orderService);
    }

    @Bean
    public DefaultInvoiceUseCase defaultInvoiceUseCase(
            InvoicePort invoicePort,
            InvoiceRepositoryPort invoiceRepositoryPort,
            InvoiceService invoiceService) {
        return new DefaultInvoiceUseCase(
                invoicePort,
                invoiceRepositoryPort,
                invoiceService);
    }

    @Bean
    public DefaultShipmentUseCase defaultShipmentUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            ShipmentService shipmentService,
            LogisticsPort logisticsPort,
            OrderRepositoryPort orderRepositoryPort,
            OrderPreparationService orderPreparationService,
            OrderService orderService) {
        return new DefaultShipmentUseCase(
                shipmentRepositoryPort,
                shipmentService,
                logisticsPort,
                orderRepositoryPort,
                orderPreparationService,
                orderService);
    }

    @Bean
    public DefaultDeliveryUseCase defaultDeliveryUseCase(
            ShipmentRepositoryPort shipmentRepositoryPort,
            DeliveryService deliveryService,
            LogisticsPort logisticsPort,
            OrderRepositoryPort orderRepositoryPort,
            OrderService orderService) {
        return new DefaultDeliveryUseCase(
                shipmentRepositoryPort,
                deliveryService,
                logisticsPort,
                orderRepositoryPort,
                orderService);
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
        return new DefaultRefundUseCase(
                returnRepositoryPort,
                refundRepositoryPort,
                refundService);
    }

    @Bean
    public DefaultReportUseCase defaultReportUseCase(
            ReportPort reportPort,
            AdministrativeReportService administrativeReportService) {
        return new DefaultReportUseCase(reportPort, administrativeReportService);
    }
}
