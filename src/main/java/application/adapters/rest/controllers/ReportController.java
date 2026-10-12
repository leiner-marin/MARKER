package application.adapters.rest.controllers;

import application.domain.ports.in.GenerateAdministrativeReportUseCase;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final GenerateAdministrativeReportUseCase reportUseCase;

    public ReportController(GenerateAdministrativeReportUseCase reportUseCase) {
        this.reportUseCase = reportUseCase;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> generate(
            @RequestParam String type) {
        return ResponseEntity.ok(reportUseCase.generate(type));
    }
}
