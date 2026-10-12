# MARKER Software Design Documentation

The SDD documents MARKER from business requirements through implementation.

## Canonical Structure

- `01-business-rules/` — business requirements, rules, actors, and traceability
- `02-domain-model/` — domain entities, enums, relationships, value objects, and exceptions
- `03-use-cases/` — application use cases
- `04-ports/` — input and output port contracts
- `Domain/services/` — domain service documentation
- `05-architecture/` — architecture boundaries
- `06-data-model/` — persistence mapping
- `07-api/` — REST API contracts
- `08-testing/` — testing strategy
- `Completion-Roadmap.md` — completion status

## Architecture Reference

MARKER follows the architectural principles used by the reference project: a pure domain core, explicit ports, application use cases, adapters, infrastructure, and automated testing.

The reference project is used only as an architectural guide. MARKER preserves its own marketplace domain, requirements, rules, and business flows.

## Documentation Rule

All documentation uses English terminology and must remain synchronized with the implementation.
