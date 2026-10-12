# ReturnService

## Purpose
Creates return requests for order products.

## Responsibilities
Requires an order, product, reason, and valid amount.

## Integration
Return persistence is isolated behind ReturnRepositoryPort.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
