# DeliveryService

## Purpose
Confirms shipment delivery.

## Responsibilities
Requires a dispatched or in-transit shipment before marking it delivered.

## Integration
Used by delivery confirmation.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
