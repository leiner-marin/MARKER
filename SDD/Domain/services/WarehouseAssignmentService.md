# WarehouseAssignmentService

## Purpose
Associates a warehouse with a seller.

## Responsibilities
Prevents invalid seller or warehouse relationships and duplicate assignments.

## Integration
Used by seller onboarding workflows.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
