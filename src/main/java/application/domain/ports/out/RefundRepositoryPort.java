package application.domain.ports.out;

import application.domain.entities.Refund;
import java.util.Optional;

public interface RefundRepositoryPort {
    Refund save(Refund refund);
    Refund update(Refund refund);
    Optional<Refund> findById(Long id);
    Optional<Refund> findByReturnId(Long returnId);
