#  Advent of Code 2025 - Día 11: Factory Maintenance 

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), donde se aplica una evolución en el modelado del **Espacio de Estados** para resolver problemas de búsqueda de caminos con restricciones obligatorias (Waypoints).

## Diferencias Parte A vs Parte B

* **Parte A (Rutas Libres):** El objetivo era contar todos los caminos posibles entre un inicio y un fin. El estado de la búsqueda se definía únicamente por la **posición actual** (nodo).
* **Parte B (Rutas Restringidas):** Se introduce una restricción de negocio crítica: los caminos válidos deben pasar obligatoriamente por dos nodos específicos (`dac` y `fft`). Esto transforma el problema; llegar a un nodo $X$ no es suficiente contexto, necesitamos saber **qué hemos visitado antes**.

### Evolución Arquitectónica: Expansión del Espacio de Estados
Para acomodar las nuevas restricciones sin abandonar la eficiencia de la Programación Dinámica, se redefinió la clave de memoización:
* **Antes:** `Map<String, Long>` (Solo Nodo).
* **Ahora:** `Map<SearchState, Long>` (Nodo + Flags de Visita).


### 1. Modelado de Estado Compuesto (State Pattern)
Dado que el grafo contiene ciclos o caminos alternativos, llegar al mismo nodo con historias diferentes (ej: habiendo visitado `dac` vs no habiéndolo hecho) representa estados distintos en la recursión.
* **`SearchState` (Record):** Encapsula la posición actual y el progreso de los objetivos (`visitedDac`, `visitedFft`). Actúa como una clave compuesta inmutable para la caché.
* **Transiciones de Estado:** El método `SearchState.next` contiene la lógica de transición, actualizando los flags booleanos automáticamente al entrar en un nodo objetivo ("dac" o "fft").

### 2. Algoritmia: DP con Restricciones
El algoritmo DFS se adapta para validar las condiciones en el caso base:
* **Condición de Parada:** Al llegar al nodo final (`end`), no se retorna `1` automáticamente. Se ejecuta `isValidEnd(currentState)`, que verifica si ambos flags (`visitedDac` && `visitedFft`) son verdaderos.
* **Memoización Contextual:** La tabla hash `memo` ahora distingue entre "estar en `aaa` sin nada" y "estar en `aaa` con `dac` visitado", evitando podas incorrectas del árbol de búsqueda.

### 3. Principios SOLID 
Se mantiene la estricta separación de responsabilidades establecida en la Parte A:
* **`GraphBuilder`:** Construcción y parsing del grafo.
* **`DeviceGraph`:** Contenedor de datos de solo lectura.
* **`PathFinder`:** Lógica pura de búsqueda y conteo. La inyección de la lógica de "dac/fft" se aisló en `SearchState`, manteniendo el algoritmo de recorrido (`getTotalPaths`) limpio y agnóstico a las reglas específicas de los flags.