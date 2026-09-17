package application.domain.ports;

import application.domain.models.Administrator;
import application.domain.models.Seller;
import application.domain.models.Warehouse;

public interface SellerPort {
    Seller registerSeller(Seller seller, Administrator administrator);
    Seller assignWarehouse(Seller seller, Warehouse warehouse);
    Seller updateSellerName(Seller seller, String newName);
}
