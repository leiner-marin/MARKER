package application.ports.out;

import application.domain.entities.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Product update(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findBySellerId(Long sellerId);
}
