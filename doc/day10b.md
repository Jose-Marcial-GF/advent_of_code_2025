#  Advent of Code 2025 - Día 10: Circuit Breaker & Joltage

Solución arquitectónica diseñada bajo los principios de **Ingeniería del Software II** (ULPGC). Este proyecto demuestra cómo una arquitectura desacoplada permite adaptar un sistema a requisitos radicalmente distintos (Parte A vs Parte B) maximizando la reutilización de código y la mantenibilidad.

### 1. Single Responsibility Principle (SRP)
Cada componente tiene una única razón para cambiar, facilitando el mantenimiento y la evolución del software:

* **Capa de Infraestructura (`GraphBuilder`):**
    * **Responsabilidad:** Aislar la complejidad de la entrada de datos ("Dirty IO"). Se encarga exclusivamente de interpretar el formato de texto mediante Expresiones Regulares (`Pattern`, `Matcher`).

* **Capa de Dominio (`State`, `Operator`):**
    * **Responsabilidad:** Modelar las reglas matemáticas puras del problema.

* **Capa de Aplicación (`Solver` / `Graph`):**
    * **Responsabilidad:** Orquestar la estrategia de resolución. Contiene los algoritmos de búsqueda y optimización, delegando las operaciones de bajo nivel al Dominio.

### 2. Inmutabilidad y Thread-Safety
Se ha optado por el uso extensivo de **Java Records**, para todas aquellas clases que forman parte del dominio del problema (`State`, `Operator`, `Graph`) :

### 3. Paradigma Funcional (Declarativo vs Imperativo)
Para minimizar la **Complejidad Ciclomática** y mejorar la legibilidad del código:
* **Eliminación de Control de Flujo:** Se evitan estructuras imperativas anidadas (`for`, `while`, `if`).
* **Streams API:** Se utiliza **Java Streams** para definir transformaciones de datos. La lógica de decisión se expresa mediante `filter` (predicados) y `map` (proyecciones), haciendo el código más expresivo y menos propenso a errores lógicos.

---

##  Evolución del Sistema

El cambio de requisitos entre la Parte A y la Parte B puso a prueba la flexibilidad de la arquitectura:

1.  **Reutilización:** Gracias al desacoplamiento, se reutilizó gran parte del código de Parsing (`GraphBuilder`) y las estructuras de datos (`Operator`).
2.  **Extensión:** La clase `State` se enriqueció con nuevas capacidades matemáticas (operaciones aritméticas para la Parte B) sin romper la lógica existente, respetando el principio Open/Closed.
3.  **Sustitución:** Se implementó un nuevo motor analítico (`Solver`) específico para el problema de paridad, sustituyendo al motor de búsqueda original sin afectar a los componentes de dominio.

---

> La idea del algoritmo implementado para la resolución del apartado b no fue idea mía, la encontré en 
> https://www.reddit.com/r/adventofcode/comments/1pk87hl/2025_day_10_part_2_bifurcate_your_way_to_victory