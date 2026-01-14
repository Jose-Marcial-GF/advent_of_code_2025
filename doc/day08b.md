# Advent of Code 2025 - Día 8: Playground

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC, aplicando **Teoría de Grafos** y procesamiento de flujos para resolver problemas de conectividad espacial.

## Diferencias Parte A vs Parte B

* **Parte A :** El objetivo era realizar una cantidad fija de conexiones  y optener los tres caminos mas largos.
* **Parte B :** El requisito evoluciona a conectar los nodos hasta formar un **único componente conexo**. Se busca identificar la arista crítica que completa la red (unifica el grafo).

### Evolución Arquitectónica

La adaptación del sistema se centró en la clase `CircuitManager`, pasando de un procesador pasivo a un monitor de estado activo:

1.  **Cambio de Criterio de Parada:**
    * En la **Parte A**, el límite era un contador fijo (`limit(1000)`).
    * En la **Parte B**, el límite es topológico: "detenerse cuando el número de circuitos sea 1".

2.  **Implementación con Streams (Stateful Filter):**
    * El método `getTheLastPath` utiliza `filter(this::isTheLastUnion).findFirst()`.
    * **Efecto:** El stream procesa aristas infinitamente (ordenadas por distancia) y las fusiona en tiempo real. En el instante exacto en que `circuits.size() == 1`, el filtro se activa, detiene el procesamiento y devuelve la arista ganadora.


### Gestión de Conjuntos Disjuntos (Union-Find)
La clase `CircuitManager` actúa como una estructura de datos **Union-Find** orientada a objetos:
* **Find:** `circuitWith(point)` localiza a qué conjunto pertenece un nodo.
* **Union:** `mergeCircuits` fusiona dos conjuntos `Set<Point>` y elimina el redundante de la lista maestra.

### Principio Open/Closed
La infraestructura base (`Point`, `Path`, `generateAllPaths`) se mantuvo intacta. Solo se extendió el `PathFinder` para solicitar una estrategia de resolución diferente (`lastPath` vs `solve` antiguo) y el `CircuitManager` para responder a preguntas de estado (`isTheLastUnion`), demostrando un diseño abierto a la extensión pero cerrado a la modificación destructiva.