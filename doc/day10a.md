# Advent of Code 2025 - Día 10: State Space Search

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), aplicando algoritmos de **Inteligencia Artificial Clásica** (Búsqueda en Grafos) implementados mediante paradigmas funcionales en Java.

## Mapa de Conceptos Aplicados

### 1. Principios SOLID: Single Responsibility Principle (SRP)
La arquitectura divide estrictamente las responsabilidades para facilitar el mantenimiento y los tests:

* **`GraphBuilder` :** Su única responsabilidad es interpretar la entrada de datos
* **`Graph` :** Su única responsabilidad es la estrategia de búsqueda (BFS)
* **`State` :** Sabe la física de los botones. El método `apply` contiene la lógica de transición de estados ($Estado_A + Operador \rightarrow Estado_B$), aislándola de la lógica de exploración del grafo.

### 2. Patrón de Diseño inmutable
Para garantizar la integridad de la búsqueda y evitar efectos secundarios al explorar ramas paralelas:
* **Records:** `State` y `Operator` son inmutables.
* **Transiciones Puras:** El método `State::apply` no modifica la lista de luces actual, sino que retorna una **nueva instancia** de `State` con los bits invertidos (XOR) según la máscara del operador, utilizando `IntStream` para la transformación bit a bit.

### 3. Clean Code: 
La entrada del problema combina representaciones visuales (`[.#..]`) y listas numéricas (`(1,3,5)`).
* **Factory Method:** El método `GraphBuilder.of(String)` encapsula la creación del grafo, entregando al dominio un objeto `Graph` limpio y listo para ser ejecutado.
