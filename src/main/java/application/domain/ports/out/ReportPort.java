package application.domain.ports.out;

import java.util.Map;

public interface ReportPort {
    Map<String, Object> sales();
    Map<String, Object> inventory();
    Map<String, Object> orders();
    Map<String, Object> shipments();
}