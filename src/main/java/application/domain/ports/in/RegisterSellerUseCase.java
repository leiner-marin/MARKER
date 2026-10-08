package application.domain.ports.in;

import application.domain.models.SellerModel;

public interface RegisterSellerUseCase {
    SellerModel register(SellerModel seller);
}
