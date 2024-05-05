# Descripción del Proyecto

La API REST para la [DISTRIBUIDORA] tiene como objetivo principal gestionar los diferentes aspectos relacionados con la administración básica de empleados, productos y categorías de productos. Este proyecto se desarrollará utilizando Java y Spring Boot como tecnologías principales, aprovechando la potencia de Spring Data JPA para la persistencia en una base de datos PostgreSQL.

## Seguridad

Para garantizar la seguridad de la API, se implementará autenticación basada en Basic Auth en ciertos endpoints, mientras que otros serán de acceso público.

## Persistencia de Datos

La persistencia de datos se llevará a cabo utilizando Spring Data JPA, Esto asegurará una gestión eficiente de la base de datos.

## Consumo de API Externa

Uno de los requisitos clave del proyecto es el consumo de una API externa para obtener y transformar datos según sea necesario. Para esto, se utilizará  WebClient para realizar las solicitudes HTTP y Gson para la serialización y deserialización de datos JSON.

## Estructura del Proyecto

El proyecto se estructurará siguiendo las mejores prácticas de diseño y modelado, con la definición clara de entidades y DTOs (Data Transfer Objects) para la transferencia de datos entre las diferentes capas de la aplicación, usando también un patron de diseño MVC.

## Pruebas y Validación

Se llevarán a cabo algunas pruebas, incluyendo pruebas unitarias, para garantizar el correcto funcionamiento de la API. Además, se utilizará Postman para realizar pruebas manuales de los diferentes endpoints y verificar que todas las funcionalidades se comporten según lo esperado.

## Documentación

Finalmente, se generará documentación detallada para la API, que incluirá pantallazos y descripciones de cada una de las acciones solicitadas. Esta documentación proporcionará una guía sobre cómo utilizar la API, incluyendo la solicitud y la respuesta de cada endpoint, así como información relevante sobre la base de datos utilizada, incluyendo nombre de usuario y contraseña.

# Configuración base de datos y credenciale de los endpoints

Para la conexión a la base de datos se usó PostgreSQL.

- Base de datos:
  - Nombre: `Distribuidora`
  - Usuario: `postgres`
  - Contraseña: `admin`
  - Puerto: `5432`
  

- Credenciales para Spring security:
  - Usuario: `admin`
  - Contraseña: `admin123`

Ver archivo de configuración [PROPERTIES](src/main/resources/application.properties)

# Listado de endpoints

## Endpoints de Empleado:
- `/empleado/crearEmpleado`
- `/empleado/modificarEmpleado`
- `/empleado/editarEstado/{id}`
- `/empleado/obtenerEmpleados`
- `/empleado/obtenerEmpleado/{id}`

## Endpoints de Categoría de Producto:
- `/categoriaProducto/crearCategoria`
- `/categoriaProducto/modificarCategoria`
- `/categoriaProducto/eliminarCategoria/{id}`

## Endpoints de Producto:
- `/producto/crearProducto`
- `/producto/modificarProducto`
- `/producto/deleteProducto/{codigo}`
- `/producto/actualizarStock/{codigo}`

## Endpoint del TRM:
- `/dollar/obtenerValor`

Es importante tener en cuenta que el servidor será de forma local por lo cual al ejecutar el api quedaria como base de la url `localhost:8080'el endpoint a solicitar'`, un ejemplo sería  [localhost:8080/dollar/obtenerValor](`localhost:8080/dollar/obtenerValor`)

- Para hacer uso de la api basta con ejecutar el jar y tener la base de datos PostgreSQL habilitada