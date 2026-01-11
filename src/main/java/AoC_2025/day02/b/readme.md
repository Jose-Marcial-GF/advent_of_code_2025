# Advent of Code 2025 - Día 2: Gift Shop Database

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC priorizando
la robustez arquitectónica y la legibilidad sobre la implementación directa.

## Diferencias Parte A vs Parte B

* **Parte A (Validación de Mitades):** Se buscaban IDs formados por una secuencia repetida exactamente dos veces (ej: `123123`). 
* **Parte B (Patrones Repetitivos):** Se buscan IDs formados por cualquier patrón repetido (ej: `121212`).

# Cambio
Se ha cambiado el requisito de evaluacion y gracias a la modularidad del código la modificación se aisló exclusivamente en la clase de dominio `InvalidIdProvider`.