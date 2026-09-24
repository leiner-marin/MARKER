package application.ports.output;

import application.domain.entities.Product;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    Product save(Product product);
    Product update(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findBySellerId(Long sellerId);
}
