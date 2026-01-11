Advent of Code 2025 - Día 1: Secret Entrance

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC
priorizando la legibilidad y la robustez arquitectónica sobre la implementación directa y la orientación a Streams (Paradigma Funcional)

### Alta Cohesión y SRP
**`Dial`: ** Encapsula la lógica matemática y el estado (Posición/Password).
**`DialBuilder`: ** Crea los diales aplicando las transformaciones pertinentes.
**`Main`:** Se limita a la lectura de ficheros y entrada del sistema.

### Bajo Acoplamiento y Modularidad
* **Inmutabilidad:** Uso de `Java Records` para garantizar que los objetos no tengan efectos secundarios, facilitando el intercambio de componentes y el testing aislado.
* **Diseño por Contrato:** Las interacciones se realizan a través de métodos públicos claros (`move`, `create`), ocultando la complejidad interna.

### Abstracción y Legibilidad
* **Código Autodocumentado:**
* **Complejidad Ciclomática Nula:**
