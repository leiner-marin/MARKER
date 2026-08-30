package application.domain.models;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    private Long id;
    private Order order;
    private Warehouse originWarehouse;
    private String deliveryAddress;
    private String shipmentStatus;
    private LocalDateTime dispatchDate;
    private LocalDateTime deliveryDate;
}
