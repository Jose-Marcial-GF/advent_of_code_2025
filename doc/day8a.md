# Advent of Code 2025 - Día 8: Playground

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), aplicando conceptos de **Teoría de Grafos** de la manera mas legible posible gracias a la  **Programación declarativa** .


### 1. Modelado de Grafos (Componentes Conexas)
El problema plantea encontrar grupos aislados (circuitos) en un conjunto de nodos (cajas de conexiones).
* **Representación:** Se ha evitado el uso de matrices de adyacencia complejas. En su lugar, se utiliza una lista de conjuntos: `List<Set<Point>>` en `CircuitManager`.
    * Cada `Set<Point>` representa un componente conexo (un circuito).
    * Al conectar dos puntos, se fusionan sus conjuntos correspondientes.

### 2. Generación Combinatoria Funcional
Para calcular las distancias entre todos los pares posibles sin duplicidad ni bucles anidados imperativos:
* **Estrategia:** Se utiliza un **Doble Stream** triangular:
    ```java
    IntStream.range(0, N).flatMap(i -> IntStream.range(i + 1, N)...)
    ```
* **Resultado:** Esto genera el conjunto exacto de aristas no dirigidas posibles ($N \times (N-1) / 2$) de forma declarativa y eficiente.

### 3. Principios SOLID: SRP (Responsabilidad Única)
La lógica está estrictamente separada:
* **`Point` / `Path` (Value Objects):** Encapsulan la geometría y la métrica (distancia euclídea 3D).
* **`CircuitManager` (Domain Service):** Gestiona la integridad de los circuitos (fusión de conjuntos, búsqueda de pertenencia). No sabe nada de distancias ni límites de 1000 conexiones.
* **`PathFinder` (Application Service):** Orquesta el algoritmo: genera caminos, los ordena por peso (distancia), selecciona los 1000 mejores y delega la fusión al Manager.

### 4. Algoritmo "Greedy" (Kruskal simplificado)
La solución implementa una variante del algoritmo de Kruskal para árboles de expansión mínima:
* Se ordenan todas las aristas posibles por distancia ascendente (`sorted(Comparator.comparingDouble)`).
* Se procesan (unen) estrictamente las primeras 1000 aristas (`limit(1000)`), simulando el proceso físico de conectar los cables más cortos disponibles.