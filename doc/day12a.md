#  Advent of Code 2025 - Día 12: Christmas Tree Farm

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), abordando un problema clásico de **Satisfacción de Restricciones (CSP)** y empaquetado geométrico mediante algoritmos de **Backtracking**.


### 1. Algoritmia: Backtracking con Heurística (Fail-Fast)
El problema consiste en determinar si un conjunto de formas irregulares ("regalos") puede encajar perfectamente en una cuadrícula ("región").
* **Estrategia:** Se utiliza un algoritmo recursivo de **fuerza bruta inteligente**.
    * Intenta colocar la pieza actual en todas las coordenadas $(x, y)$ posibles.
    * Si encaja, marca la rejilla y desciende un nivel en la recursión.
    * Si llega a un callejón sin salida, deshace el paso (**Backtrack**) y prueba la siguiente posición.
* **Optimización (Largest First):** Las piezas se ordenan por área ascendente y se procesan desde el final (`getLast()`). Colocar primero las piezas más grandes reduce drásticamente el árbol de búsqueda, ya que son las que más probabilidades tienen de generar conflictos tempranos.

### 2. Modelado de Dominio y Geometría
* **Generación de Variantes:** La clase `Shape` no almacena solo la forma base, sino que genera funcionalmente todas las permutaciones isométricas válidas (rotaciones y reflexiones) utilizando Streams.
* **Validación Espacial:** La clase `Region` actúa como el tablero de juego. Utiliza una matriz de booleanos (`boolean[][] grid`) para verificaciones de colisión en tiempo constante $O(1)$, evitando la sobrecarga de calcular intersecciones geométricas complejas.

### 5. Principios SOLID
* **SRP (Single Responsibility Principle):**
    * `Shape`: Responsable de la definición geométrica y sus variantes.
    * `Region`: Responsable de mantener el estado de ocupación del tablero.
    * `PuzzleSolver`: Responsable exclusivamente de la lógica de orquestación recursiva, sin conocer los detalles de cómo se parsea el input o cómo se guardan los bits en la matriz.