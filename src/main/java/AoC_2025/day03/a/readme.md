# Advent of Code 2025 - Día 3: Emergency Batteries

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), priorizando la **cohesión**, la **inmutabilidad** y el uso de **Patrones de Diseño** para resolver un problema algorítmico complejo tratando de no comprometer la limpieza del código.

## Fundamentos y Patrones Aplicados


### 1. Patrón Builder
Se ha implementado en  `BatteryBuilder` el **Patrón Builder** facilitando una fluent api.

### 2. Orientación Funcional
El núcleo del algoritmo se ha resuelto sin complejidad ciclomática explicita
* Se ha necesitado crear una clase `SearchState` para lograrlo.
aun así el estado de  búsqueda se encapsula y evoluciona paso a paso de forma inmutable, pasando de un `SearchState` otro nuevo.
### 3. Alta Cohesión y SRP
* **`BatteryBuilder`:** Transforma el texto en objetos del dominio del problema.
* **`Battery`:** Representa la entidad del dominio. Calcula su propio valor.
* **`SearchState`:** Encapsula la complejidad matemática (índices, ventanas de búsqueda). La clase `Battery` delega en ella los detalles de bajo nivel.

### 4. Inmutabilidad y Diseño por Contrato
* **Java Records:** Todos los componentes (`Battery`, `SearchState`, `BatteryBuilder`) están implementados como `records`. Esto garantiza la **inmutabilidad** de los datos por defecto.
