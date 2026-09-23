package application.domain.entities;

import application.domain.enums.CommercialStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer extends User {
    private String primaryAddress;
    private List<String> additionalAddresses;
    private CommercialStatus commercialStatus;
    private boolean activeCart;
    private List<Order> orderHistory;
}

