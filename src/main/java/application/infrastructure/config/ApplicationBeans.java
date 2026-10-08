package application.infrastructure.config;

import application.adapters.useCases.DefaultInventoryUseCase;
import application.adapters.useCases.DefaultProductUseCase;
import application.domain.ports.out.InventoryPort;
import application.domain.ports.out.ProductPort;
import application.domain.services.BodegaService;
import application.domain.services.VendedorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {

    @Bean
    public DefaultProductUseCase defaultProductUseCase(ProductPort productPort) {
        return new DefaultProductUseCase(productPort);
    }

    @Bean
    public DefaultInventoryUseCase defaultInventoryUseCase(InventoryPort inventoryPort) {
        return new DefaultInventoryUseCase(inventoryPort);
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
