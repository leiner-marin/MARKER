package application.ports.output;

import java.util.Optional;

public interface ReembolsoRepository {
    Object save(Object refund);
    Object update(Object refund);
    Optional<Object> findById(Long id);
    Optional<Object> findByDevolutionId(Long devolutionId);
}
