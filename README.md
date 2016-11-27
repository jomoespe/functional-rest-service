Un API REST Java con un *smell* functional con Spark-Java
=========================================================

[![Build Status](https://travis-ci.org/jomoespe/functional-rest-service.svg?branch=master)](https://travis-ci.org/jomoespe/functional-rest-service)

En el presente artículo os muestro un ejemplo de como implementar un servicio REST con un estilo más funcional, apoyandonos en
la librería [SparkJava](http://sparkjava.com/).

El presente proyecto es el codigo de un de [un artículo](./article.md) a publicar en diferentes blogs.

## Descripcion del proyecto


## Requisitos

En caso de que quieras descargarte y construir el proyecto el entorno necesita tener instalado y contigurado:

  - Git (2.x+)
  - Java 8 (JDK)
  - Un navegador o un cliente HTTP tipo `curl`


### Clonar y construir el proyecto

    $ git clone https://github.com/jomoespe/functional-rest-interface
    $ ./mvnw clean verify


### Ejecutar el proyecto

    $ # Ejecutar desde maven
    $ ./mvnw [clean verify] exec:java
    
    $ curl http://localhost:8080/api/v1/lemmings
    $ curl http://localhost:8080/api/v1/lemmings?q=cd
    $ curl http://localhost:8080/api/v1/lemmings/climber



