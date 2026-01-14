# Advent of Code 2025 - Día 4: Printing Department

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC, utilizando **Programación Funcional** pura para resolver problemas de lógica espacial sin complejidad ciclomática.

## Diferencias Parte A vs Parte B

* **Parte A :** El objetivo era identificar elementos en una matriz 2D basándose en su vecindad inmediata.
* **Parte B :** Los elementos identificados se eliminan iterativamente hasta que el sistema se estabiliza.

### Evolución Arquitectónica

Gracias al diseño basado en **Records Inmutables** (`Grid`) y **Streams**, la adaptación fue natural:

1.  **Reutilización del Dominio (OCP):** La lógica de detección de vecinos (aplanada mediante `IntStream` y ventanas deslizantes) se reutilizó intacta. No fue necesario modificar cómo el `Grid` entiende el espacio.
2.  **De Estático a Flujo Infinito:** Para la Parte B, en lugar de introducir bucles `while` o gestión de estados mutables, se utilizó `Stream.iterate` combinado con `takeWhile` y se modificó la clase `grid` para que eliminara aquellos rollos que tenían que ser eliminados.

