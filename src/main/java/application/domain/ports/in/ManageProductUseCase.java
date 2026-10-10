package application.domain.ports.in;

import application.domain.entities.Product;
import java.util.List;
import java.util.Optional;

public interface ManageProductUseCase {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
