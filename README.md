# Proyecto de Magneto

## Sobre el Proyecto de Magneto

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men, basándose en su secuencia de ADN.

* Recibirás, como parámetro, un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN
* Las letras de los Strings solo pueden ser: (A,T,C,G).
* Un humano es mutante, si se encuentra ​más de una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical.

ATGCGA

CAGTGC

TTATGT

AGAAGG

CCCCTA

TCACTG

### Ejemplos:

* ADN mutante: {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}
* ADN no mutante: {"ATGCAA","TAGTGC","TTGTGT","AGAAGG","CACTTA","TCACAG"}
* ADN inválido: {"ATGCGA","CAGTGC","TTHTGT","AGAAGG","CCCCTA","TCACTG"}

# Organización de Submódulos

El proyecto se divide en varios submódulos:

* **controller**:
Expone los end-points de la api.
* **services**:
Servicios que son consumidos por los controllers.
* **domain**:
Entidades que representan a las tablas de las bases de datos.
* **views**:
Objetos que representan la estructura de las peticiones (request) y/o los resultados de los mismos.


## Requerimientos

* JDK 11 (Oracle's JDK)
* Spring Boot 2.3.4
* Apache Maven 3.6.3
* Git

# Despliegue

Obtener código fuente:
```
git clone git@github.com:villalbapaezabelesteban/mutant.git
cd mutant
```
Construir usando Maven:
```
mvn clean package
```
URL del endpoint expuesto (POST):
```
localhost:2020/mutant
```

# Sobre Proyecto de Magneto

Challenge, realizado en Spring Boot, propuesto para evaluación técnica y de razonamiento en la resolución de problemas.