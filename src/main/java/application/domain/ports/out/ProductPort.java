package application.domain.ports.out;

import application.domain.models.ProductModel;
import java.util.List;
import java.util.Optional;

public interface ProductPort {
    ProductModel save(ProductModel product);
    ProductModel update(ProductModel product);
    Optional<ProductModel> findById(Long id);
    List<ProductModel> findAll();
    List<ProductModel> findBySellerId(Long sellerId);
}
