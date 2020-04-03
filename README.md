## [Proyecto Movetto (com.movetto)](http://www.movetto.com)
## Back End - API REST (com.movetto.api)
API REST con Spring Boot (API, test)
## Estado del Proyecto
[![Build Status](https://travis-ci.org/gusguma/movetto-backend-api.svg?branch=develop)](https://travis-ci.org/gusguma/movetto-backend-api)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.movetto%3Aapi&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.movetto%3Aapi)
[![BCH compliance](https://bettercodehub.com/edge/badge/gusguma/movetto-backend-api?branch=develop)](https://bettercodehub.com/)
[![Heroku broken](https://movetto-backend-api.herokuapp.com/system/version-badge)](https://movetto-backend-api.herokuapp.com/swagger-ui.html)
## Tecnologías Necesarias
* Java
* Maven
* Logs
* JUnit5
* IntelliJ
* GitHub
* Travis-CI
* Sonar Cloud
* Better Code Hub
* Spring
* Heroku
* MySQL
* OpenAPI-Swagger
## Documentación del Proyecto
> Este proyecto es la parte del Back-End, del proyecto movetto Se parte de un API Rest desarrollado mediante Spring Boot
  
El objetivo del presente proyecto es el soporte back-end de una aplicación android, 
cuyo proyecto esta siendo realizado en el repositorio movetto-android.

## Responsabilidades
* `rest_controllers` Clases que conforman el **API**.
   * Define el path del recurso.
   * Deben organizar la recepción de datos de la petición.
   * Delega en los **dtos** la validación de campos.
   * Delega en los **bussines_controllers** la ejecución de la petición.
* `bussines_controllers` Clases que procesan la petición.
   * Desarrollan el proceso que conlleva la ejecución de la petición.
   * Construye los **entity** a partir de los **dtos** de entrada.
   * Delega en los **dtos** la construcción de las **entity** de respuesta.
   * Delega en los **daos** el acceso básico a las BD.
* `daos` Clases de acceso a BD mediante el patrón DAO.
   * Operaciones CRUD sobre BD.
   * Consultas a BD.
* `entity` Clases con las tablas persistentes en BD y utilidades.
* `dtos` Clases con los objetos de transferencia del API.
   * Validación de datos de entrada.





