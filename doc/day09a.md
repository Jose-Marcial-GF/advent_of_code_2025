#  Advent of Code 2025 - Día 9: Largest Rectangle

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), destacando la aplicación del **Patrón Builder** para la construcción de objetos geométricos y el uso de **Programación Funcional** para resolver problemas de combinatoria espacial.


### 1. Patrón de Diseño: Builder
El problema requiere instanciar objetos `Rectangle` derivados de dos puntos arbitrarios. Dado que un rectángulo posee atributos calculados (area), se ha aplicado el patrón **Builder**.
* **Implementación:** La clase `RectangleBuilder` encapsula la aritmética de coordenadas (`Math.abs(...) + 1`).
* **Beneficio:** Mantiene la inmutabilidad del record `Rectangle` y asegura el **Principio de Responsabilidad Única (SRP)**: el rectángulo almacena datos, el constructor sabe cómo calcularlos.

### 2. Algoritmia: 
El objetivo es encontrar el rectángulo de mayor área posible formado por cualquier par de puntos de la lista.
* **Reducción:** el stream de rectángulos candidatos,  se reduce utilizando `max(Comparator.comparingLong(Rectangle::area))`, delegando la optimización a la API de Streams.

### 3. Value Objects y Parsing
* **Inmutabilidad:** Las coordenadas se modelan mediante el record `Point`, actuando como un **Value Object** puro.
* **Factory Method:** Se utiliza un método estático `Point.of(String[])` para encapsular la lógica de parsing, ocultando la complejidad de la conversión de tipos (`Long.parseLong`) al resto del dominio.