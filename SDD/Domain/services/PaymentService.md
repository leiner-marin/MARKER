# PaymentService

## Purpose
Validates payment business data.

## Responsibilities
Requires a valid order and a positive payment amount.

## Integration
External payment processing is performed through PaymentPort.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
