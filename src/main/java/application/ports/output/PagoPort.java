package application.ports.output;

import java.math.BigDecimal;
import java.util.Optional;

public interface PagoPort {
    boolean procesarPago(Object payment);
    boolean validarPago(Long paymentId);
    Optional<String> obtenerEstado(Long paymentId);
    boolean ejecutarReembolso(Long paymentId, BigDecimal amount);
}
