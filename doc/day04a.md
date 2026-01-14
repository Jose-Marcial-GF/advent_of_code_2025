# Advent of Code 2025 - Día 4: Printing Department

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), donde usando **Programación Funcional** resolvemos problemas de lógica espacial eliminando la complejidad ciclomática 


### 1. Orientación Funcional
El reto principal  suele resolverse con bucles `for` anidados 
* **Solución Implementada:** Se ha utilizado `IntStream.range` sobre el tamaño total de la matriz (`filas * columnas`), tratando la estructura 2D como un flujo lineal de datos.
* **Beneficio:** Esto permite encadenar operaciones declarativas (`filter(isRoll)`, `filter(neighbors <= bound)`) reduciendo la **Complejidad Ciclomática** drásticamente.

### 2. Alta Cohesión y SRP
* **`Main`:** lectura de ficheros.
* **`Grid`:** Encapsula toda la lógica espacial.

### 3. Abstracción y Robustez
* **Inmutabilidad:** La clase `Grid` se ha implementado como un `Java Record`. Esto garantiza que el estado del almacén sea inmutable.
Además grid utiliza métodos auxiliares privados (`rowOf`, `columnOf`) para traducir el índice lineal del Stream a coordenadas cartesianas, ocultando esa complejidad aritmética al resto del sistema.