package application.adapters.persistence.jpa.repositories;

import application.adapters.persistence.jpa.entities.InventoryEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findFirstByProductId(Long productId);
}
