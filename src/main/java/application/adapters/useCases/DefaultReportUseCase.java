package application.adapters.useCases;

import application.domain.ports.in.GenerateAdministrativeReportUseCase;
import application.domain.ports.out.ReportPort;
import application.domain.services.AdministrativeReportService;
import java.util.Map;

public class DefaultReportUseCase implements GenerateAdministrativeReportUseCase {
    private final ReportPort reportPort;
    private final AdministrativeReportService administrativeReportService;

    public DefaultReportUseCase(
            ReportPort reportPort,
            AdministrativeReportService administrativeReportService) {
        this.reportPort = reportPort;
        this.administrativeReportService = administrativeReportService;
    }

    @Override
    public Map<String, Object> generate(String reportType) {
        administrativeReportService.validateReportType(reportType);
        return switch (reportType.toUpperCase()) {
            case "SALES" -> reportPort.sales();
            case "INVENTORY" -> reportPort.inventory();
            case "ORDERS" -> reportPort.orders();
            case "SHIPMENTS" -> reportPort.shipments();
            default -> throw new IllegalArgumentException("Unsupported report type: " + reportType);
        };
    }
}
