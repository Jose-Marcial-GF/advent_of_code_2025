# Advent of Code 2025 - Día 6: Trash Compactor

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), donde se ha priorizado la **Separación de Responsabilidades (SRP)** y la **Alta Cohesión** mediante un enfoque puramente funcional.


### 1.  SRP y Cohesión Pura
Se ha realizado una refactorización arquitectónica clave para desacoplar el almacenamiento de datos de la lógica de negocio:
* **`MathWorkSheet`:** Su única responsabilidad es parsear la entrada y contener los datos. No contiene lógica matemática.
* **`Solver`:** Encapsula la lógica matemática. Recibe una hoja de trabajo y ejecuta las operaciones.

### 2. Compresión de Codigo:
Tanto en `MathWorkSheet` como en `Solver` tienen factory methods(`of` y `with` respectivamente).
Con el fin de cumplir tener una lectura mas cómoda del código

### 3. Calidad del Código:
* Se utiliza `flatMap(Optional::stream)` combinado con un método `parseNumber` que envuelve la conversión en un `Optional` evitando  errores y espacios vacíos de forma declarativa.
