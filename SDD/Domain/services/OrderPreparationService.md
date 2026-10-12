# OrderPreparationService

## Purpose
Prepares a paid order for dispatch.

## Responsibilities
Only paid orders may enter preparation/dispatch.

## Integration
Keeps preparation rules in the domain.

## Architecture
This is a domain service. It must remain independent from Spring, JPA, REST, HTTP, and database implementations.
