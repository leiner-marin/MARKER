package application.domain.ports;

import java.util.Map;

public interface ReportPort {
    Map<String, Object> generateSalesReport(Integer totalOrders, Integer totalSales, Double averageTicket);
    Map<String, Object> generateInventoryReport(Integer availableProducts, Integer reservedProducts);
    Map<String, Object> generateSellerPerformanceReport(Integer activeSellers, Integer processedOrders);
}
