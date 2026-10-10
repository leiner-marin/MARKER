package application.adapters.rest.controllers;

import application.domain.entities.Product;
import application.domain.ports.in.PublishProductUseCase;
import application.domain.ports.in.RegisterProductUseCase;
import application.domain.ports.in.ManageProductUseCase;
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

    public ProductController(
            RegisterProductUseCase registerProductUseCase,
            PublishProductUseCase publishProductUseCase,
            ManageProductUseCase manageProductUseCase) {
        this.registerProductUseCase = registerProductUseCase;
        this.publishProductUseCase = publishProductUseCase;
        this.manageProductUseCase = manageProductUseCase;
    }

    @GetMapping
    public List<Product> getAll() {
        return manageProductUseCase.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return manageProductUseCase.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return registerProductUseCase.register(product);
    }

    @PostMapping("/{id}/publish")
    public Product publish(@PathVariable Long id) {
        return publishProductUseCase.publish(id);
    }
}
