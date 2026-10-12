package application.infrastructure.config;

import application.adapters.persistence.InMemorySellerRepositoryAdapter;
import application.adapters.persistence.InMemoryWarehouseRepositoryAdapter;
import application.adapters.useCases.DefaultInventoryUseCase;
import application.adapters.useCases.DefaultBuyerUseCase;
import application.adapters.persistence.InMemoryBuyerRepositoryAdapter;
import application.domain.ports.out.BuyerRepositoryPort;
import application.domain.services.CompradorService;
import application.adapters.useCases.DefaultProductUseCase;
import application.adapters.useCases.DefaultSellerUseCase;
import application.adapters.useCases.DefaultWarehouseUseCase;
import application.adapters.useCases.DefaultUserUseCase;
import application.adapters.persistence.InMemoryUserRepositoryAdapter;
import application.domain.ports.out.UserRepositoryPort;
import application.domain.services.UsuarioService;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.ports.out.SellerRepositoryPort;
import application.domain.ports.out.WarehouseRepositoryPort;
import application.domain.services.SellerOnboardingService;
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
    public SellerRepositoryPort sellerRepositoryPort() {
        return new InMemorySellerRepositoryAdapter();
    }

    @Bean
    public WarehouseRepositoryPort warehouseRepositoryPort() {
        return new InMemoryWarehouseRepositoryAdapter();
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
            WarehouseAssignmentService warehouseAssignmentService) {
        return new DefaultSellerUseCase(
                sellerRepositoryPort,
                sellerOnboardingService,
                warehouseAssignmentService);
    }

    @Bean
    public DefaultWarehouseUseCase defaultWarehouseUseCase(
            WarehouseRepositoryPort warehouseRepositoryPort,
            WarehouseService warehouseService) {
        return new DefaultWarehouseUseCase(warehouseRepositoryPort, warehouseService);
    }
}
