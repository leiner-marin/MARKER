# InventoryService

## Purpose
Validates and adjusts inventory.

## Responsibilities
Prevents negative available stock.

## Integration
Provides the common inventory adjustment rule used by inventory operations.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
