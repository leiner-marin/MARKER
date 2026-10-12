# AdministrativeReportService

## Purpose
Coordinates administrative reporting rules.

## Responsibilities
Report data access is abstracted behind ReportPort.

## Integration
Supported report types are handled by the application use case.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
