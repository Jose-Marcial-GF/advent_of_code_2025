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

## 📂 Soluciones por Día

### 🔐 Día 1: Secret Entrance
**Parte A:** 
📑 [Documentación](./doc/day01a.md) | 💾 [Código](./src/main/java/AoC_2025/day01/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day01/a)

**Parte B:** 
📑 [Documentación](./doc/day01b.md) | 💾 [Código](./src/main/java/AoC_2025/day01/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day01/b)

---

### 🛂 Día 2: ID Classification
**Parte A:** 
📑 [Documentación](./doc/day02a.md) | 💾 [Código](./src/main/java/AoC_2025/day02/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day02/a)

**Parte B:** 
📑 [Documentación](./doc/day02b.md) | 💾 [Código](./src/main/java/AoC_2025/day02/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day02/b)

---

### 🔋 Día 3: Battery Maximization
**Parte A:** 
📑 [Documentación](./doc/day03a.md) | 💾 [Código](./src/main/java/AoC_2025/day03/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day03/a)

**Parte B:** 
📑 [Documentación](./doc/day03b.md) | 💾 [Código](./src/main/java/AoC_2025/day03/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day03/b)

---

### 🖨️ Día 4: Printing Department
**Parte A:** 
📑 [Documentación](./doc/day04a.md) | 💾 [Código](./src/main/java/AoC_2025/day04/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day04/a)

**Parte B:** 
📑 [Documentación](./doc/day04b.md) | 💾 [Código](./src/main/java/AoC_2025/day04/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day04/b)

---

### 📦 Día 5: Inventory Management
**Parte A:** 
📑 [Documentación](./doc/day05a.md) | 💾 [Código](./src/main/java/AoC_2025/day05/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day05/a)

**Parte B:** 
📑 [Documentación](./doc/day05b.md) | 💾 [Código](./src/main/java/AoC_2025/day05/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day05/b)

---

### 🐙 Día 6: Cephalopod Math Calculator
**Parte A:** 
📑 [Documentación](./doc/day06a.md) | 💾 [Código](./src/main/java/AoC_2025/day06/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day06/a)

**Parte B:** 
📑 [Documentación](./doc/day06b.md) | 💾 [Código](./src/main/java/AoC_2025/day06/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day06/b)

---

### 🔦 Día 7: Beam Management
**Parte A:** 
📑 [Documentación](./doc/day07a.md) | 💾 [Código](./src/main/java/AoC_2025/day07/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day07/a)

**Parte B:** 
📑 [Documentación](./doc/day07b.md) | 💾 [Código](./src/main/java/AoC_2025/day07/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day07/b)

---

### 🎀 Día 8: Christmas Decorations
**Parte A:** 
📑 [Documentación](./doc/day08a.md) | 💾 [Código](./src/main/java/AoC_2025/day08/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day08/a)

**Parte B:** 
📑 [Documentación](./doc/day08b.md) | 💾 [Código](./src/main/java/AoC_2025/day08/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day08/b)

---

### 🧩 Día 9: Tiles Manager
**Parte A:** 
📑 [Documentación](./doc/day09a.md) | 💾 [Código](./src/main/java/AoC_2025/day09/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day09/a)

**Parte B:** 
📑 [Documentación](./doc/day09b.md) | 💾 [Código](./src/main/java/AoC_2025/day09/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day09/b)

---

### ⚡ Día 10: Circuit Breaker & Joltage
**Parte A:** 
📑 [Documentación](./doc/day10a.md) | 💾 [Código](./src/main/java/AoC_2025/day10/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day10/a)

**Parte B:** 
📑 [Documentación](./doc/day10b.md) | 💾 [Código](./src/main/java/AoC_2025/day10/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day10/b)

---

### 🏭 Día 11: Factory Maintenance
**Parte A:** 
📑 [Documentación](./doc/day11a.md) | 💾 [Código](./src/main/java/AoC_2025/day11/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day11/a)

**Parte B:** 
📑 [Documentación](./doc/day11b.md) | 💾 [Código](./src/main/java/AoC_2025/day11/b) | 🛡️ [Tests](./src/test/java/AoC_2025/day11/b)

---

### 🎄 Día 12: Christmas Tree Farm
**Parte A:** 
📑 [Documentación](./doc/day12a.md) | 💾 [Código](./src/main/java/AoC_2025/day12/a) | 🛡️ [Tests](./src/test/java/AoC_2025/day12/a)

*Proyecto realizado como parte de la asignatura de Ingeniería del Software II - ULPGC.*
