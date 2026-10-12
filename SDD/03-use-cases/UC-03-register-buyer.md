# Register Buyer

**Primary actor:** Administrator / Buyer

## Goal
Register buyer-specific information.

## Preconditions
- The actor is authenticated and authorized.
- Required domain information is valid.

## Main Flow
1. The actor requests the operation.
2. The application validates the request.
3. The use case invokes the required domain services.
4. Output ports handle persistence or external integrations.
5. The result is returned.

## Business Rules
The buyer requires valid identity data and a primary address.

## Architecture
The use case is exposed through an input port and implemented in the application layer. Business rules remain in domain services.
