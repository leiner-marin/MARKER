package application.services;

import application.domain.entities.Buyer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DireccionCompradorService {

    public Buyer registrarDireccionPrincipal(Buyer buyer, String direccion) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Address is required.");
        }
        buyer.setPrimaryAddress(direccion);
        return buyer;
    }

    public Buyer agregarDireccionAdicional(Buyer buyer, String direccion) {
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer cannot be null.");
        }
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Address is required.");
        }
        if (buyer.getAdditionalAddresses() == null) {
            buyer.setAdditionalAddresses(new ArrayList<>());
        }
        buyer.getAdditionalAddresses().add(direccion);
        return buyer;
    }

    public List<String> listarDirecciones(Buyer buyer) {
        if (buyer == null) {
            return new ArrayList<>();
        }
        if (buyer.getAdditionalAddresses() == null) {
            buyer.setAdditionalAddresses(new ArrayList<>());
        }
        return buyer.getAdditionalAddresses();
    }
}
