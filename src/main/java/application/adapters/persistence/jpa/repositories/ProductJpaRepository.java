package application.adapters.persistence.jpa.repositories;

import application.adapters.persistence.jpa.entities.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findBySellerId(Long sellerId);
}
