package application.api;

import application.adapters.useCases.DefaultProductUseCase;
import application.domain.models.ProductModel;
import application.domain.ports.out.ProductPort;
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
    private final ProductPort productPort;
    private final DefaultProductUseCase productUseCase;

    public ProductController(ProductPort productPort, DefaultProductUseCase productUseCase) {
        this.productPort = productPort;
        this.productUseCase = productUseCase;
    }

    @GetMapping
    public List<ProductModel> getAll() {
        return productPort.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getById(@PathVariable Long id) {
        return productPort.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductModel create(@RequestBody ProductModel product) {
        return productUseCase.register(product);
    }

    @PostMapping("/{id}/publish")
    public ProductModel publish(@PathVariable Long id) {
        return productUseCase.publish(id);
    }
}
