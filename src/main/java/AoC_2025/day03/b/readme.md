# Advent of Code 2025 - Día 3: Emergency Batteries

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC priorizando
la robustez arquitectónica y la inmutabilidad sobre la implementación imperativa.

## Diferencias Parte A vs Parte B

* **Parte A (Secuencia Corta):** Se buscaba maximizar el voltaje seleccionando una secuencia de **2 dígitos**.
* **Parte B (Secuencia Extendida):** El requisito escala a encontrar la mejor secuencia de **12 dígitos**.

### Cambio
Gracias a la implementación del **Patrón Builder** (`BatteryBuilder`), la modificación se redujo a una **configuración de parámetros** (`lookingFor(12)`).

La lógica algorítmica encapsulada en `SearchState` y `Battery` permaneció inalterada (**Principio Open/Closed**), demostrando que el diseño era independiente de la longitud de la secuencia
