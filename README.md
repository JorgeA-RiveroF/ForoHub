# ForoHub
Es el challenge 3 de la formación backend de Oracle Next Education y Alura, el proyecto consiste en construir una API REST para un foro, donde los usuarios pueden crear, leer, actualizar y eliminar tópicos con Java y Spring Boot.

*[Índice](#índice)*
* [Descripción del proyecto](#descripción-del-proyecto)
* [Estado del proyecto](#estado-del-proyecto)
* [Acceso al proyecto](#acceso-al-proyecto)
* [Configuración del entorno](#configuración-del-entorno)
* [Tecnologías utilizadas](#tecnologías-utilizadas)
* [Desarrollador del proyecto](#desarrollador-del-proyecto)
* [Conclusión](#conclusión)

## Descripción del proyecto

ForoHub es una aplicación de foro desarrollada utilizando Java 17, Maven, Spring Boot y MySQL. La aplicación permite a los usuarios autenticarse, crear, listar, actualizar y eliminar tópicos. Además, implementa seguridad utilizando Spring Security y JWT para la autenticación de usuarios.

## Estado del proyecto

![Badge en Desarrollo](https://img.shields.io/badge/STATUS-EN%20DESARROLLO-green)

## Acceso al proyecto

Para ejecutar el proyecto, clona el repositorio y configura tu base de datos MySQL con los detalles proporcionados en el archivo `application.properties`. Luego, puedes compilar y ejecutar la aplicación utilizando Maven.

## Configuración del entorno

### Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas:

- Java JDK 17 o superior
- Maven 4 o superior
- MySQL 8 o superior
- IDE (opcional): IntelliJ IDEA

### Pasos para configurar el proyecto

1. **Clonar el repositorio:**


2. **Configurar la base de datos:**

    Crea una base de datos en MySQL llamada `forohub` y configura las credenciales en el archivo `src/main/resources/application.properties`:


3. **Construir y ejecutar la aplicación:**


## Tecnologías utilizadas

- **Java 17**
- **Maven**
- **Spring Boot 3**
- **MySQL 8**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **Lombok**
- **Flyway Migration**
- **IntelliJ IDEA (opcional)**

## Desarrollador del proyecto

Jorge A. Rivero Fragoso

## Conclusión

ForoHub es una aplicación backend de foro robusta y segura que permite la gestión eficiente de tópicos y usuarios, utilizando tecnologías modernas como Spring Boot y JWT para la autenticación y autorización de usuarios. Este proyecto proporciona una base sólida para la creación de aplicaciones web con funcionalidades de foro y gestión de contenido.
