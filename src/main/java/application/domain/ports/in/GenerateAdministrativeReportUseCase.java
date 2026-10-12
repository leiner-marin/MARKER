package application.domain.ports.in;

import java.util.Map;

public interface GenerateAdministrativeReportUseCase {
    Map<String, Object> generate(String reportType);
}
