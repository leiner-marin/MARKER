package application.domain.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogisticsOperator extends User {
    private List<Warehouse> assignedWarehouses;
    private List<Order> ordersToDispatch;
    private List<Inventory> inventoryMovements;
}
