package application.adapters.rest.controllers;

import application.adapters.rest.dtos.product.ProductResponse;
import application.adapters.rest.mappers.ProductRestMapper;
import application.domain.ports.in.QueryCatalogUseCase;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    private final QueryCatalogUseCase queryCatalogUseCase;

    public CatalogController(QueryCatalogUseCase queryCatalogUseCase) {
        this.queryCatalogUseCase = queryCatalogUseCase;
    }

    @GetMapping
    public List<ProductResponse> getPublishedProducts() {
        return queryCatalogUseCase.getPublishedProducts().stream()
                .map(ProductRestMapper::toResponse)
                .toList();
    }
}
