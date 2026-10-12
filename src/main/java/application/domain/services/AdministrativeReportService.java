package application.domain.services;

public class AdministrativeReportService {
    public void validateReportType(String reportType) {
        if (reportType == null || reportType.isBlank()) {
            throw new IllegalArgumentException("Report type is required.");
        }
    }
}
