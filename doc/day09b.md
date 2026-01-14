# Advent of Code 2025 - Día 9: Playground 

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), donde un problema de **Geometría Computacional** (contención de formas) se resuelve reutilizando lógica de intervalos y optimizaciones de barrido.

## Diferencias Parte A vs Parte B

* **Parte A:** Se buscaba el rectángulo más grande formado por dos puntos cualesquiera.
* **Parte B:** El rectángulo debe formarse entre dos "baldosas rojas" (vértices), pero **todo** su área debe estar cubierta por baldosas rojas o verdes (que forman un bucle y su interior).

## Mapa de Conceptos Aplicados

### 1. Geometría Computacional: Algoritmo Scan-line
Validar si un rectángulo está dentro de un polígono cóncavo es complejo. No basta con validar los 4 vértices.
* **Solución Implementada:** Se utiliza una variante del algoritmo de **Línea de Barrido** en la clase `Polygon`.
* **Lógica:** Para validar un rectángulo, "escaneamos" sus líneas horizontales críticas. Para cada línea $Y$, calculamos qué intervalos del eje $X$ están dentro del polígono (intersecando los bordes verticales del bucle). Si el ancho del rectángulo no encaja en esos intervalos seguros, el candidato se descarta.

### 2. Gestión de Intervalos y Fusión
La lógica de "baldosas verdes contiguas" se modela mediante la fusión de intervalos.
* **`IntervalChain`:** Una estructura de datos personalizada que actúa como una lista enlazada inteligente. Al añadir un nuevo intervalo, intenta fusionarlo automáticamente con el último si son adyacentes o se solapan.
* **Beneficio:** Convierte una lista fragmentada de coordenadas en regiones continuas de "espacio válido", simplificando la validación de contención.

### 3. Optimización: Caching y Niveles Críticos
Verificar cada píxel del rectángulo sería $O(Area)$, lo cual es inviable para coordenadas grandes.
* **Validación Discreta:** En `RectangleFinder`, solo validamos los niveles $Y$ que son estructuralmente relevantes: los bordes superior/inferior del rectángulo y cualquier vértice del polígono que caiga "dentro" del rango vertical del rectángulo.
* **Memoización:** `Polygon` utiliza un `rowCache` (`Map<Long, List<Interval>>`) para recordar la geometría de una fila $Y$ ya calculada, evitando recalcular intersecciones para rectángulos que comparten la misma altura.

### 4. Principios SOLID (Open/Closed)
La arquitectura de la Parte A (`Rectangle`, `Point`, `Builder`) se reutilizó intacta.
* La nueva restricción se inyectó simplemente añadiendo un filtro `isValid(rect, polygon)` en el flujo de procesamiento de `RectangleFinder`, demostrando que el sistema estaba abierto a la extensión (nuevas reglas de validación) sin modificar la generación de candidatos.
