# RefundService

## Purpose
Creates refund records for return requests.

## Responsibilities
Validates return request and refund amount and assigns the processed state.

## Integration
Refund persistence is isolated behind RefundRepositoryPort.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
