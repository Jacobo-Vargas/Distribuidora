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
- POST `/empleado/crearEmpleado`
- PUT `/empleado/modificarEmpleado`
- PUT `/empleado/editarEstado/{id}`
  - para editar el estado en la url debe poner el id del empleado y en el cuerpo del mensaje el estado, sea ACTIVO o INACTIVO
- GET `/empleado/obtenerEmpleados`
- GET `/empleado/obtenerEmpleado/{id}`

## Endpoints de Categoría de Producto:
- POST `/categoriaProducto/crearCategoria`
- PUT `/categoriaProducto/modificarCategoria`
- DELETE `/categoriaProducto/eliminarCategoria/{id}`

## Endpoints de Producto:
- POST `/producto/crearProducto`
- PUT `/producto/modificarProducto`
- DELETE `/producto/deleteProducto/{codigo}`
- PUT `/producto/actualizarStock/{codigo}`
  - para el stock en la url va el código del producto y en el cuerpo de la soicitud la cantidad a actualizar

## Endpoint del TRM:
- GET `/dollar/obtenerValor`

Es importante tener en cuenta que el servidor será de forma local por lo cual al ejecutar el api quedaria como base de la url `localhost:8080'el endpoint a solicitar'`, un ejemplo sería  [localhost:8080/dollar/obtenerValor](`localhost:8080/dollar/obtenerValor`)

- Para hacer uso de la api basta con ejecutar el jar y tener la base de datos PostgreSQL habilitada
  - comando en consola para ejecutar el jar [`java -jar nombre_del_archivo.jar`]
Es de aclarar que debes de descargar el jar antes de y reemplazar por el nombre del archivo.

JAR PARA DESCARGAR -->   [Distribuidora](Distribuidora-0.0.1-SNAPSHOT.jar)
A continuación se encuentran ejemplos de los resultados a algunos endpoints usando POSTMAN

![CREAR PRODUCTO](src%2Fmain%2Fresources%2Fimages%2Fcrear%20producto.png)

![DELETE CATEGORIA](src%2Fmain%2Fresources%2Fimages%2Fdel%20categoria.png)

![DELETE PRODUCTO](src%2Fmain%2Fresources%2Fimages%2Fdel%20producto.png)

![GET EMPLEADOS](src%2Fmain%2Fresources%2Fimages%2FgetEmpleados.png)

![CAMBIAR STOCK CON AUTENTICACION](src%2Fmain%2Fresources%2Fimages%2Fstock%20credenciales.png)

![CAMBIAR STOCK SIN AUTENTICACION](src%2Fmain%2Fresources%2Fimages%2Fstock%20no%20credenciales.png)

![OBTENER CAMBIO DE DIVISA](src%2Fmain%2Fresources%2Fimages%2FTRM.png)


#CONTACTO 
- estare agradecido con cualquier retroalimentacion y/o sugerencia
  - correo: jacobovargas493@gmail.com
  - celular: 3186569265