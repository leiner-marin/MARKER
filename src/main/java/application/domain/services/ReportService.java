package application.domain.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public Map<String, Object> generateSalesReport(Integer totalOrders, Integer totalSales, Double averageTicket) {
        Map<String, Object> report = new HashMap<>();
        report.put("totalOrders", totalOrders == null ? 0 : totalOrders);
        report.put("totalSales", totalSales == null ? 0 : totalSales);
        report.put("averageTicket", averageTicket == null ? 0.0 : averageTicket);
        return report;
    }

    public Map<String, Object> generateInventoryReport(Integer availableProducts, Integer reservedProducts) {
        Map<String, Object> report = new HashMap<>();
        report.put("availableProducts", availableProducts == null ? 0 : availableProducts);
        report.put("reservedProducts", reservedProducts == null ? 0 : reservedProducts);
        return report;
    }

    public Map<String, Object> generateSellerPerformanceReport(Integer activeSellers, Integer processedOrders) {
        Map<String, Object> report = new HashMap<>();
        report.put("activeSellers", activeSellers == null ? 0 : activeSellers);
        report.put("processedOrders", processedOrders == null ? 0 : processedOrders);
        return report;
    }
}
