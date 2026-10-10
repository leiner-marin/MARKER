package application.domain.ports.in;

import application.domain.entities.Seller;

public interface ManageSellerUseCase {
    Seller update(Seller seller);
    Seller findById(Long id);
}
