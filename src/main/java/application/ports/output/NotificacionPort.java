package application.ports.output;

public interface NotificacionPort {
    void enviarConfirmacionPedido(Long orderId);
    void enviarConfirmacionPago(Long paymentId);
    void enviarEstadoEnvio(String trackingNumber);
    void enviarReembolso(Long refundId);
}
