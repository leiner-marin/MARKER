# UC-15 Generate Invoice

**Primary actor:** Administrator / Application

**Goal:** Generate an invoice for a valid order.

**Preconditions**
- The order exists.
- The invoice amount is valid.

**Main flow**
1. The application receives the order and amount.
2. Invoice data is created.
3. The invoice integration contract is invoked.
4. The invoice is stored.
5. The invoice is returned.
