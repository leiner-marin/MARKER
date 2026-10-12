# InvoiceService

## Purpose
Creates invoice business data from a valid order.

## Responsibilities
Validates order and amount and initializes invoice state.

## Integration
External invoice handling is isolated behind ports.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
