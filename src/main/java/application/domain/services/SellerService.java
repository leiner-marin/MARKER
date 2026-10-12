package application.domain.services;

import application.domain.entities.Seller;

public class SellerService {
    public Seller validate(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Seller cannot be null.");
        }
        if (seller.getFullName() == null || seller.getFullName().isBlank()) {
            throw new IllegalArgumentException("Seller full name is required.");
        }
        if (seller.getEmail() == null || seller.getEmail().isBlank()) {
            throw new IllegalArgumentException("Seller email is required.");
        }
        return seller;
    }
}
