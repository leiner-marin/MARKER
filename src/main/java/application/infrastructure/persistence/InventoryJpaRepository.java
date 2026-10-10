package application.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, Long> {
    List<InventoryEntity> findByProductId(Long productId);
    Optional<InventoryEntity> findFirstByProductId(Long productId);
}