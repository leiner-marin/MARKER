# UC-13 Process Payment

**Primary actor:** Buyer

**Goal:** Process payment for a valid order.

**Preconditions**
- The order exists.
- The payment amount is valid.
- The order is awaiting payment.

**Main flow**
1. Payment information is received.
2. The payment is validated.
3. The external payment contract is invoked.
4. On acceptance, the order becomes PAID.
5. The result is returned.
