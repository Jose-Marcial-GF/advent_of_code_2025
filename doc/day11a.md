# Advent of Code 2025 - Día 11: Factory Maintenance

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), aplicando técnicas de **Programación Dinámica** sobre Grafos Dirigidos Acíclicos (DAG) para resolver problemas de combinatoria de caminos de forma eficiente.


### 1. Algoritmia: DFS con Memoización 
El problema solicita encontrar el número total de caminos distintos entre dos nodos. En un grafo complejo, el número de caminos puede crecer exponencialmente, haciendo inviable una búsqueda por fuerza bruta.
* **Solución:** Se implementa un algoritmo de **Búsqueda en Profundidad (DFS)** asistido por una tabla de **Memoización** (`Map<String, Long> memo`).
* **Lógica:**
    * Si ya hemos calculado cuántos caminos llevan desde el nodo $A$ hasta el final, reutilizamos ese valor ($O(1)$) en lugar de volver a recorrer todo el subgrafo.
    * Esto reduce la complejidad temporal drásticamente, pasando de exponencial a lineal respecto al número de conexiones ($O(V+E)$).

### 2. Estructuras de Datos: Grafos Dirigidos
* **Representación:** El grafo se modela mediante **Listas de Adyacencia** encapsuladas en un `Map<String, Device>`.
* **Inmutabilidad:** Los nodos (`Device`) y el grafo (`DeviceGraph`) son registros inmutables. Una vez parseada la entrada, la estructura de la red no puede ser alterada, lo que garantiza la integridad durante la ejecución recursiva del algoritmo.

### 3. Single Responsibility Principle
La arquitectura desacopla estrictamente las fases del procesamiento:
* **`GraphBuilder` (Parsing):** Se encarga de transformar la entrada de texto crudo (`"aaa: bbb ccc"`) en objetos de dominio. Utiliza `flatMap` y `Collectors.toMap` para construir el grafo de una sola pasada.
* **`PathFinder` (Logic):** Contiene exclusivamente el algoritmo de conteo de caminos. Es un servicio puro que recibe el grafo y devuelve el resultado, gestionando su propia memoria caché (memoización).

### 4. Programación Funcional
La recursividad del algoritmo se expresa mediante Streams:
* En lugar de bucles imperativos, se utiliza `stream().mapToLong(...).sum()` para agregar los caminos provenientes de los nodos vecinos. Esto hace que la definición matemática de la solución ("caminos desde aquí = suma de caminos de mis vecinos") se traduzca literalmente a código.