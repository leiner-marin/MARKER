# InventoryAdjustmentService

## Purpose
Applies inventory quantity adjustments.

## Responsibilities
Rejects adjustments that would make available stock negative.

## Integration
Keeps adjustment behavior consistent across use cases.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
