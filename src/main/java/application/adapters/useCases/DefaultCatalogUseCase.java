package application.adapters.useCases;

import application.domain.entities.Product;
import application.domain.ports.in.QueryCatalogUseCase;
import application.domain.ports.out.ProductRepositoryPort;
import application.domain.services.CatalogService;
import java.util.List;

public class DefaultCatalogUseCase implements QueryCatalogUseCase {
    private final ProductRepositoryPort productRepositoryPort;
    private final CatalogService catalogService;

    public DefaultCatalogUseCase(
            ProductRepositoryPort productRepositoryPort,
            CatalogService catalogService) {
        this.productRepositoryPort = productRepositoryPort;
        this.catalogService = catalogService;
    }

    @Override
    public List<Product> getPublishedProducts() {
        return catalogService.publishedProducts(productRepositoryPort.findAll());
    }
}
