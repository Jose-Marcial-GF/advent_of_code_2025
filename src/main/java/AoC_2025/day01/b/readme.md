# Advent of Code 2025 - Día 1: Secret Entrance

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC priorizando
la robustez arquitectónica y la legibilidad sobre la implementación directa.

## Diferencias Parte A vs Parte B

La evolución de los requisitos entre las partes ilustra la flexibilidad del diseño:
* **Parte A:** Contabilizaba paradas estáticas en la posición 0.
* **Parte B:** Contabiliza **cruces dinámicos** por la posición 0 (vueltas completas).
### Cambios

Los cambios necesarios para esta implementacion se han realizado en el método `updateCount` 