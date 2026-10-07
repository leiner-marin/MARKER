# IncorporacionVendedorService

## Objetivo
Gestionar la incorporación de vendedores al marketplace y definir su estado inicial dentro del sistema.

## Responsabilidad principal
Validar la información de un vendedor y activar o suspender su incorporación según el ciclo de negocio.

## Reglas de negocio
- El vendedor debe tener nombre y correo válidos.
- La fecha de incorporación se asigna automáticamente si no se envía.
- El estado por defecto debe ser activo en la etapa inicial.

## Métodos
- incorporarVendedor()
- activarVendedor()
- suspenderVendedor()
