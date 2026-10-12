# UC-14 Manage Order

**Primary actor:** Administrator / Logistics Operator

**Goal:** Manage an order through its valid lifecycle.

**Preconditions**
- The order exists.
- The actor is authorized.

**Main flow**
1. The actor requests a valid status transition.
2. The current state is validated.
3. The order state changes.
4. The change is stored.
