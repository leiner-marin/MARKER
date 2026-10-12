package application.domain.ports.out;

import application.domain.entities.ReturnRequest;
import java.util.Optional;

public interface ReturnRepositoryPort {
    ReturnRequest save(ReturnRequest request);
    ReturnRequest update(ReturnRequest request);
    Optional<ReturnRequest> findById(Long id);
    Optional<ReturnRequest> findByOrderId(Long orderId);
}
