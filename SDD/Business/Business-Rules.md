# Business Rules

## Reglas de negocio
1. Un usuario debe tener correo válido y único.
2. Un producto no puede quedar sin vendedor asociado.
3. El inventario no puede quedar en cantidad negativa.
4. Una reserva solo se puede ejecutar si existe stock suficiente.
5. Un pedido no puede modificarse si ya fue finalizado o cancelado.
6. Toda entrega debe corresponder a un pedido válido.
7. La facturación requiere un pedido confirmado.
8. Las devoluciones y reembolsos requieren validación del estado del pedido.

## Alcance
Estas reglas deben implementarse en los servicios del dominio y validarse en los casos de uso.
