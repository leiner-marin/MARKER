package application.adapters.rest.controllers;

import application.adapters.rest.dtos.product.ProductRequest;
import application.adapters.rest.dtos.product.ProductResponse;
import application.adapters.rest.mappers.ProductRestMapper;
import application.domain.entities.Product;
import application.domain.ports.in.ManageProductUseCase;
import application.domain.ports.in.PublishProductUseCase;
import application.domain.ports.in.RegisterProductUseCase;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final RegisterProductUseCase registerProductUseCase;
    private final PublishProductUseCase publishProductUseCase;
    private final ManageProductUseCase manageProductUseCase;

    public ProductController(RegisterProductUseCase registerProductUseCase,
            PublishProductUseCase publishProductUseCase,
            ManageProductUseCase manageProductUseCase) {
        this.registerProductUseCase = registerProductUseCase;
        this.publishProductUseCase = publishProductUseCase;
        this.manageProductUseCase = manageProductUseCase;
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return manageProductUseCase.findAll().stream().map(ProductRestMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        return manageProductUseCase.findById(id).map(ProductRestMapper::toResponse)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return ProductRestMapper.toResponse(registerProductUseCase.register(ProductRestMapper.toDomain(request)));
    }

    @PostMapping("/{id}/publish")
    public ProductResponse publish(@PathVariable Long id) {
        return ProductRestMapper.toResponse(publishProductUseCase.publish(id));
    }

    @PostMapping("/{id}/suspend")
    public ProductResponse suspend(@PathVariable Long id) {
        return ProductRestMapper.toResponse(manageProductUseCase.suspend(id));
    }

    @PostMapping("/{id}/discontinue")
    public ProductResponse discontinue(@PathVariable Long id) {
        return ProductRestMapper.toResponse(manageProductUseCase.discontinue(id));
    }

    @PostMapping("/{id}/variants")
    public ProductResponse addVariant(@PathVariable Long id, @RequestBody VariantRequest request) {
        return ProductRestMapper.toResponse(manageProductUseCase.addVariant(id, request.variant()));
    }

    public record VariantRequest(String variant) {}
}
