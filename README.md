# Price Service

## Tecnologías utilizadas

- Spring Boot 3
- Spring Data JPA
- Spring Validation
- Spring Web
- H2 Database (base de datos en memoria)
- Lombok
- Springdoc OpenAPI (generación de documentación API)
- Postman (colección de pruebas funcionales)
- Jacoco (cobertura de código)

## Configuración

### Requisitos previos

- Java 17
- Maven

### Pasos de instalación

1. Clona el repositorio: `git clone https://github.com/BlueJnr/price-service.git`
2. Navega al directorio del proyecto: `cd price-service`
3. Compila el proyecto: `mvn clean install`

### Ejecución del microservicio

1. Navega al directorio del proyecto: `cd price-service`
2. Ejecuta el comando: `mvn spring-boot:run`

El microservicio se ejecutará en `http://localhost:8080`.

## Endpoints

A continuación, se detallan los endpoints disponibles en el microservicio:

### GET /api/prices/{productId}

Descripción: Obtener el precio de un producto por ID.
Parámetros de ruta:

- `productId` (entero): ID del producto.

Parámetros de consulta:

- `applicationDate` (cadena): Fecha de aplicación en formato "yyyy-MM-dd HH:mm:ss".
- `brandId` (entero): ID de la marca.

Respuesta exitosa:

- Código de estado: 200 (OK)
- Cuerpo de respuesta: JSON con los detalles del precio del producto.

## Documentación API

La documentación de la API se genera automáticamente utilizando Swagger. Puedes acceder a ella
en [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Base de datos en memoria (H2)

Este microservicio utiliza una base de datos en memoria H2 para almacenar los datos de precios de productos. Puedes acceder a la consola de administración de H2 para visualizar y administrar la base de datos. Sigue estos pasos:

1. Ejecuta el microservicio.
2. Abre un navegador web e ingresa la siguiente URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console).
3. En la página de inicio de sesión de H2, asegúrate de que los siguientes campos estén configurados de la siguiente manera:
    - Driver: `org.h2.Driver`
    - JDBC URL: `jdbc:h2:mem:inditexdb`
    - User Name: `inditex`
    - Password: `xetidni`
4. Haz clic en el botón "Connect".

Después de iniciar sesión, tendrás acceso a la consola de administración de H2, donde podrás ver las tablas, ejecutar consultas SQL y realizar otras operaciones de base de datos relacionadas con tu base de datos en memoria.

## Pruebas funcionales

En la raíz del proyecto, encontrarás un archivo de colección de Postman llamado `Ecommerce_API_Especification.postman_collection.json`.
Importa este archivo en tu cliente de Postman para tener acceso a las pruebas funcionales predefinidas para los
endpoints del microservicio.

## Estructura del proyecto

A continuación, se muestra la estructura de archivos y directorios del proyecto:

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.inditex.priceservice
│   │   │       ├── config
│   │   │       ├── model
│   │   │       │   ├── api
│   │   │       │   ├── dto
│   │   │       │   └── entity
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       ├── web
│   │   │       └── PriceServiceApplication.java
│   │   └── resources
│   │       ├── application.yml
│   │       └── data.sql
│   └── test
│       ├── java
│       │   └── com.inditex.priceservice
│       │       ├── repository
│       │       ├── service.impl
│       │       └── web
│       └── resources
├── pom.xml
└── Ecommerce_API_Especification.postman_collection.json
```

## Cobertura de Código

El microservicio utiliza Jacoco para generar informes de cobertura de código. A continuación, se detallan los pasos para generar y visualizar el informe de cobertura:

1. Ejecuta las pruebas unitarias del microservicio junto con el análisis de cobertura utilizando el siguiente comando:

```shell
mvn clean test
```

2. Después de que las pruebas se completen correctamente, se generará un informe de cobertura en formato HTML en el directorio `target/site/jacoco/index.html`.

3. Abre el archivo `index.html` en un navegador web para ver el informe de cobertura. En este informe, podrás ver la cobertura de código a nivel de línea y a nivel de clase, así como estadísticas detalladas.