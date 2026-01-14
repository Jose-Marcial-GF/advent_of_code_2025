#  Advent of Code 2025 - Soluciones de Ingeniería del Software

Este repositorio contiene las soluciones para el *Advent of Code 2025*, desarrolladas bajo un enfoque estricto de **Ingeniería del Software II (ULPGC)**.

Más allá de la resolución algorítmica de los puzzles, el objetivo principal de este proyecto es la aplicación práctica de **Principios SOLID**, **Clean Code** y **Arquitecturas Desacopladas** en un entorno de resolución de problemas complejos.

---

##  Filosofía de Diseño y Arquitectura
El proyecto se centra en tener una arquitectura estructurada, mantenible, inmutable, y un código comprensible.
### 1. Principios SOLID y Clean Code
Se ha priorizado la legibilidad y la mantenibilidad sobre la micro-optimización prematura.
>Donald Knuth "La optimización prematura es la raíz de todos los males".

* **Single Responsibility Principle (SRP):** Estricta separación entre capas.
    * *Parsing:* `InputParser`, `GraphBuilder`, `...` (Manejo de "IO").
    * *Dominio:* `State`, `Region`, `Device`, `...` (representación del dominio del problema inmutable).
    * *Aplicación:* `Solver`, `PathFinder`, `...` (Coordinación y algoritmos).
* **Open/Closed:** El diseño permite extender la funcionalidad (ej: nuevas reglas en la Parte B) sin modificar las clases base del dominio, utilizando composición y herencia de records.

### 2. Paradigma Funcional y Java Streams
Para reducir la **Complejidad Ciclomática** y los efectos secundarios, se ha adoptado un estilo declarativo:
* **Inmutabilidad:** Uso casi exclusivo de `Java Records` para garantizar la integridad de los datos en algoritmos recursivos.
* **Streams API:** Sustitución de estructuras de control imperativas (`for`, `while`, `if` anidados) por `Streams` de datos y aplicando metodos como `filter`, `map`, `reduce` `...`, haciendo el código más legible que facilite la abtracción y menos propenso a errores.
### 3. Patrones de Diseño Aplicados
* **Builder / Factory:** Para la construcción de grafos complejos desde texto plano (`GraphBuilder`) o simplemente para facilitar la legibilidad, en lugar de un `new` usar un `.with` .
* **Strategy:** Para intercambiar algoritmos de resolución entre la Parte A y B.
* **Memoization:** Implementada en aquellos `Solver` donde el tiempo de ejecución era muy elevado.



---
## Uso de la IA

Se a utilizado a la ia para los siguientes procesos:
* La asistencia en la redacción de la documentación.

* Al iniciar el proyecto la usé para descubrir formas de usar los Streams pues no tenia experiencia. Con la adquisición de experiencia se ha usado para corroborar la formulación de algunos streams más complejos.

---
*Proyecto realizado como parte de la asignatura de Ingeniería del Software II - ULPGC.*