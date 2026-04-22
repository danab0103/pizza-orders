# Pizza Orders

A simple pizza ordering system that demonstrates two design patterns and utility of 4 unit tests.

## Design Patterns

### 1. Decorator Pattern

A pizza starts from a base (`Dough`) and gets built up by wrapping it in toppings. Each topping adds to the description and price without modifying the class underneath.

- `Pizza` — interface with `getDescription()` and `getPrice()`
- `Dough` — the base pizza
- `ToppingDecorator` — abstract base for all toppings
- `TomatoSauce` — adds tomato sauce (+2 RON)
- `Mozzarella` — adds mozzarella (+4.5 RON)
- `Ham` — adds pepperoni (+6 RON)
- `Mushrooms` — adds mushrooms (+3.5 RON)

### 2. Observer Pattern

When an order's status changes (RECEIVED → PREPARING → OUT_FOR_DELIVERY → DELIVERED), the customer is notified automatically. `PizzaOrder` has no knowledge of how notifications are handled.

- `OrderObserver` — interface with `onStatusChanged()`
- `CustomerNotifier` — notified on every status change, so the customer is always aware of where their order is
- `DeliveryNotifier` — notified only on OUT_FOR_DELIVERY and DELIVERED, since the delivery system only needs to know when the order has left the pizzeria and when it has arrived
- `PizzaOrder` — manages the observer list and notifies on `updateStatus()`
