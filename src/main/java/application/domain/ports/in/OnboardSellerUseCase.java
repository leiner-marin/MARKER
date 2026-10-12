package application.domain.ports.in;

import application.domain.entities.Seller;
import application.domain.entities.Warehouse;

public interface OnboardSellerUseCase {
    Seller onboard(Seller seller);
    Seller assignWarehouse(Seller seller, Warehouse warehouse);
}
