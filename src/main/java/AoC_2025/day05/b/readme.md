# Advent of Code 2025 - Día 5: Cafeteria

Solución diseñada bajo los principios de **Ingeniería del Software II** en la ULPGC, priorizando la **cohesión**, el **Domain-Driven Design (DDD)** y la eficiencia algorítmica sobre la implementación ingenua.

## Diferencias Parte A vs Parte B

* **Parte A (Verificación Discreta):** Comprobar si una lista de IDs específicos pertenecía a alguno de los rangos dados.
* **Parte B (Cálculo Volumétrico):** Calcular total de IDs válidos que existen dentro de la unión de todos los rangos.

### Evolución y Reutilización
Gracias a la encapsulación de la lógica de fusión en `Range` y `RangeList`, la transición fue inmediata:

Para la Parte B, simplemente se añadió el método `numbersInRange()` al record `Range` y una agregación final en RangeList  usando las streams de java para `ranges.stream().mapToLong(Range::numbersInRange).sum()`

El sistema pasó de "validar existencias" a "calcular volúmenes" cambiando únicamente la operación terminal del Stream, respetando el **Principio Open/Closed**.