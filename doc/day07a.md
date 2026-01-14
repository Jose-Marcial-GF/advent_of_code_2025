# Advent of Code 2025 - Día 7: Light Reflexion

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), centrada en el modelado de estados inmutables y la programación funcional.

### 1. Patrón de diseño inmutable
* **Implementación:** Se utiliza la clase `World` como un **Record inmutable**.
* **Evolución:** En lugar de modificar el estado interno de un objeto, cada paso de la simulación genera una nueva instancia de `World`. Esto se orquesta mediante `Stream.reduce`, donde el acumulador es la función de transición de estado:

### 2. Principios SOLID: SRP
* **`LightEngine` :** Se encarga de la leer las capas y ejecutar el ciclo de vida de la simulación.
* **`World`:** guarda la lógica de como se refleja la luz.


### 3. Comprensión del Código:
* Se han utilizado **Factory Methods** con el fin de optener un código más legible

En definitiva es algo muy similar a lo que hicimos el dia 1

