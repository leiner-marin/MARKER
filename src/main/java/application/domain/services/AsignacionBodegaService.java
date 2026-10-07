package application.services;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AsignacionBodegaService {

    public Warehouse asignarBodega(Seller seller, Warehouse warehouse) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse cannot be null.");
        }
        warehouse.setOwnerSeller(seller);
        if (seller.getAssociatedWarehouses() == null) {
            seller.setAssociatedWarehouses(new ArrayList<>());
        }
        if (!seller.getAssociatedWarehouses().contains(warehouse)) {
            seller.getAssociatedWarehouses().add(warehouse);
        }
        return warehouse;
    }

    public List<Warehouse> listarBodegas(Seller seller) {
        if (seller == null || seller.getAssociatedWarehouses() == null) {
            return new ArrayList<>();
        }
        return seller.getAssociatedWarehouses();
    }
}
