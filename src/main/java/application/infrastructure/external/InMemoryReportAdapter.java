package application.infrastructure.external;

import application.domain.ports.out.ReportPort;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class InMemoryReportAdapter implements ReportPort {
    @Override
    public Map<String, Object> sales() {
        return new LinkedHashMap<>(Map.of("totalOrders", 0, "totalSales", 0));
    }

    @Override
    public Map<String, Object> inventory() {
        return new LinkedHashMap<>(Map.of("availableStock", 0, "reservedStock", 0));
    }

    @Override
    public Map<String, Object> orders() {
        return new LinkedHashMap<>(Map.of("totalOrders", 0));
    }

    @Override
    public Map<String, Object> shipments() {
        return new LinkedHashMap<>(Map.of("totalShipments", 0));
    }
}
