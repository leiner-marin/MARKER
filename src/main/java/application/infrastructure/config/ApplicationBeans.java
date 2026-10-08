package application.infrastructure.config;

import application.adapters.useCases.DefaultInventoryUseCase;
import application.adapters.useCases.DefaultProductUseCase;
import application.domain.ports.out.InventoryPort;
import application.domain.ports.out.ProductPort;
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
}
