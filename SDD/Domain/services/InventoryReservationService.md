# InventoryReservationService

## Purpose
Reserves available inventory.

## Responsibilities
Rejects zero or negative reservations and reservations above available stock.

## Integration
Updates available quantity after a valid reservation.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
