package application.domain.services;

import application.domain.entities.Seller;
import application.domain.enums.SellerStatus;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class IncorporacionVendedorService {

    public Seller incorporarVendedor(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (seller.getFullName() == null || seller.getFullName().isBlank()) {
            throw new IllegalArgumentException("Seller full name is required.");
        }
        if (seller.getEmail() == null || seller.getEmail().isBlank()) {
            throw new IllegalArgumentException("Seller email is required.");
        }
        if (seller.getIncorporationDate() == null) {
            seller.setIncorporationDate(LocalDate.now());
        }
        if (seller.getSellerStatus() == null) {
            seller.setSellerStatus(SellerStatus.ACTIVE);
        }
        return seller;
    }

    public Seller activarVendedor(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        seller.setSellerStatus(SellerStatus.ACTIVE);
        return seller;
    }

    public Seller suspenderVendedor(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        seller.setSellerStatus(SellerStatus.SUSPENDED);
        return seller;
    }
}
