package application.domain.services;

import application.domain.entities.Seller;
import application.domain.enums.SellerStatus;
import application.domain.enums.UserRole;
import java.time.LocalDate;

public class SellerOnboardingService {

    public Seller onboard(Seller seller) {
        validate(seller);
        seller.setRole(UserRole.SELLER);
        if (seller.getIncorporationDate() == null) {
            seller.setIncorporationDate(LocalDate.now());
        }
        if (seller.getSellerStatus() == null) {
            seller.setSellerStatus(SellerStatus.ACTIVE);
        }
        return seller;
    }

    public Seller activate(Seller seller) {
        validate(seller);
        seller.setSellerStatus(SellerStatus.ACTIVE);
        return seller;
    }

    public Seller suspend(Seller seller) {
        validate(seller);
        seller.setSellerStatus(SellerStatus.SUSPENDED);
        return seller;
    }

    private void validate(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (seller.getIdentityDocument() == null || seller.getIdentityDocument().isBlank()) {
            throw new IllegalArgumentException("Identity document is required.");
        }
        if (seller.getFullName() == null || seller.getFullName().isBlank()) {
            throw new IllegalArgumentException("Seller full name is required.");
        }
        if (seller.getEmail() == null || seller.getEmail().isBlank()) {
            throw new IllegalArgumentException("Seller email is required.");
        }
    }
}
