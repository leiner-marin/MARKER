package application.domain.ports.out;

import application.domain.models.SellerModel;
import java.util.List;
import java.util.Optional;

public interface SellerPort {
    SellerModel save(SellerModel seller);
    SellerModel update(SellerModel seller);
    Optional<SellerModel> findById(Long id);
    List<SellerModel> findAll();
}
