# Advent of Code 2025 - Día 5: Cafeteria
Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), aplicando **Domain-Driven Design (DDD)** y optimización algorítmica para resolver un problema de gestión de intervalos de forma eficiente y legible.

## Mapa de Conceptos Aplicados

### 1 Eficiencia
En lugar de comprobar cada ID contra todos los rangos, se implementó un algoritmo de **fusión de intervalos**.

Se ordenan los rangos por su inicio `sorted(Comparator.comparingLong(Range::from))` y se fusionan.

### 2. Domain-Driven Design  y Cohesión
Se ha evitado la "Obsesión por los Primitivos". Un rango no es un `long[]`, es un **Value Object** métodos propios como `Range::contains` y `Range::mergeOrConcat`.


De forma que la Clase `Range` encapsula la lógica de interseccion.
cabe resaltar que el método `mergeOrConcat` contiene la inteligencia para decidir si dos rangos se convierten en uno solo o permanecen separados, cumpliendo el principio de **"Tell, Don't Ask"**.

### 3. Principios de Diseño: SRP y OCP
La arquitectura respeta estrictamente la responsabilidad única:
* **`Range`:** Sabe matemáticas de intervalos. No sabe nada sobre listas o parsing.
* **`RangeList`:** Gestiona la colección y coordina el algoritmo de reducción (`accumulate`).
* **`InventorySystem`:** organiza la entrada de datos.
