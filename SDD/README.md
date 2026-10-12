# MARKER Software Design Documentation

The SDD documents MARKER from business requirements through implementation.

## Canonical Structure

- `01-business-rules/` — business rules, actors, and traceability
- `02-domain-model/` — domain entities, enums, relationships, value objects, and exceptions
- `03-use-cases/` — application use cases
- `Domain/services/` — domain service documentation
- `05-architecture/` — architecture boundaries
- `06-data-model/` — persistence mapping
- `07-api/` — REST API contracts
- `08-testing/` — testing strategy
- `Completion-Roadmap.md` — completion status

## Documentation Rule

All documentation must use English terminology and remain synchronized with the implementation.

The application architecture is based on the same architectural principles used by the reference project: a pure domain core, explicit input and output ports, application use cases, adapters, infrastructure, and automated tests.

MARKER retains its own marketplace business domain and requirements.
