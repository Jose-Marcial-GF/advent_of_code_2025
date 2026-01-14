# Advent of Code 2025 - Día 7: Light Reflexion

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), donde se ha priorizado la **Separación de Responsabilidades (SRP)** y la **Alta Cohesión** mediante un enfoque puramente funcional.

## Diferencias Parte A vs Parte B

* **Parte A:** El objetivo era contar número total de reflexiones.
* **Parte B:** El requisito es calcular el número total de caminos posibles.

### Evolución Arquitectónica: De la Presencia a la Densidad

El cambio fundamental no reside en la lógica de movimiento, sino en la **Estructura de Datos** utilizada para representar el estado del mundo:

1.  **De `Set<Integer>` a `Map<Integer, Long>`:**
    * En la **Parte A**, solo importaba dónde había luz para saber si podía intesectar con un prisma.
    * En la **Parte B**, necesitamos saber cuánta luz hay en cada punto. El mapa almacena `Posición con luz -> Cantidad de haces de luz que pasan por ahí`, de forma que si 100 rayos convergen en la posición 5, gestionamos una sola entrada `{5: 100}` en `timelines`


### 2. Lógica de coliciones
La lógica de colisión y agrupación se resuelve mediante Streams:
hacemos un `splitLightIfRequire` y que luego acagrupamos con un colector con la función(`Long::sum`) para almacenar todas las líneas temporales