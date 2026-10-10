package application.infrastructure.config;

import application.adapters.useCases.DefaultInventoryUseCase;
import application.adapters.useCases.DefaultProductUseCase;
import application.domain.ports.out.InventoryRepositoryPort;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.services.BodegaService;
import application.domain.services.VendedorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {

    @Bean
    public DefaultProductUseCase defaultProductUseCase(ProductRepositoryPort productRepositoryPort) {
        return new DefaultProductUseCase(productRepositoryPort);
    }

    @Bean
    public DefaultInventoryUseCase defaultInventoryUseCase(InventoryRepositoryPort inventoryRepositoryPort) {
        return new DefaultInventoryUseCase(inventoryRepositoryPort);
    }

    @Bean
    public BodegaService bodegaService() {
        return new BodegaService();
    }

    @Bean
    public VendedorService vendedorService() {
        return new VendedorService();
    }
}
