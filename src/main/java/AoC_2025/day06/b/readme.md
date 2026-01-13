# Advent of Code 2025 - Día 6: Trash Compactor

Solución diseñada bajo los principios de **Ingeniería del Software II** (ULPGC), donde se ha priorizado la **Separación de Responsabilidades (SRP)** y la **Alta Cohesión** mediante un enfoque puramente funcional.

## Diferencias Parte A vs Parte B

* **Parte A:** Los problemas matemáticos se presentaban en filas. 
* **Parte B:** Los números se forman leyendo las columnas de arriba a abajo

### Cambio y Evolución Arquitectónica
 El groso de la modificación estuvo en la clase `MathWorkSheet`.
Para soportar la lectura vertical de ancho variable, se implementó `mapNumbersInColumnsToX` que detecta cuantas cifras tiene cada número 
