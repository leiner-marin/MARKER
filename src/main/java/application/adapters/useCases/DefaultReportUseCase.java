package application.adapters.useCases;

import application.domain.ports.in.GenerateAdministrativeReportUseCase;
import application.domain.ports.out.ReportPort;
import java.util.Map;

public class DefaultReportUseCase implements GenerateAdministrativeReportUseCase {
    private final ReportPort reportPort;

    public DefaultReportUseCase(ReportPort reportPort) {
        this.reportPort = reportPort;
    }

    @Override
    public Map<String, Object> generate(String reportType) {
        if (reportType == null || reportType.isBlank()) {
            throw new IllegalArgumentException("Report type is required.");
        }

        return switch (reportType.toUpperCase()) {
            case "SALES" -> reportPort.sales();
            case "INVENTORY" -> reportPort.inventory();
            case "ORDERS" -> reportPort.orders();
            case "SHIPMENTS" -> reportPort.shipments();
            default -> throw new IllegalArgumentException("Unsupported report type.");
        };
    }
}
