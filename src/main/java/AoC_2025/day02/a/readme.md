# Advent of Code 2025 - Día 2: Gift Shop Database


Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC priorizando
la robustez arquitectónica y la legibilidad sobre la implementación directa.

### 1. Orientación Funcional
El problema de este día se presta mucho al uso de **Streams, funciones lambdas y Method Reference**. Logrando así una 
mejor comprensión del código reduciendo la complejidad ciclomática a 0.

### 2.Principios de Diseño SRP
Se para aplicar el **Principio de Responsabilidad Única** se ha desacoplando el problema en tres capas especializadas:
* **`Main`:** Se limita a la lectura del sistema de ficheros.
* **`IdChecker`:** Se encarga de interpretar el formato de entrada y coordinar la validación.
* **`InvalidIdProvider`:** Su única responsabilidad es saber si un número cumple el criterio de ser "inválido".

### 3. Abstracción y Legibilidad
A través del **Good Naming y encapsulamiento** se ha tratado de hacer un código autoexplicativo 
* **Good Naming**, (`getInvalidCodesSum`, `isInvalid`)
* **Encapsulamiento:** Métodos como `toLong` o la sobrecarga privada de `isInValid` ocultan los detalles de implementación