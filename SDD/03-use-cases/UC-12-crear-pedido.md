# UC-12 Create Order

**Primary actor:** Buyer

**Goal:** Convert a valid cart into an order.

**Preconditions**
- The buyer exists.
- The cart contains at least one product.
- Inventory is available.

**Main flow**
1. The buyer confirms the cart.
2. The application validates the order.
3. Inventory is reserved as required.
4. The order is created.
5. The order is stored.
