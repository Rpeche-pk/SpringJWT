
# Aplicación de Spring Boot con autenticación y autorización JWT

Esta aplicación de ejemplo demuestra cómo utilizar Spring Boot junto con JSON Web Tokens (JWT) para implementar un sistema de autenticación y autorización seguro en una aplicación web. JWT es un estándar abierto (RFC 7519) que permite la transferencia segura de información entre dos partes como un objeto JSON compacto y autónomo.

## Características principales

- **Spring Boot**: La aplicación está construida utilizando el framework Spring, y el uso del proyecto Spring Boot, que proporciona un entorno de desarrollo ágil y simplificado para crear aplicaciones Java.
- **Autenticación basada en JWT**: En lugar de utilizar sesiones y cookies tradicionales, la autenticación se basa en JWT. Un token JWT es generado y enviado al cliente después de que se haya autenticado correctamente. Este token se utiliza para autorizar las solicitudes posteriores al servidor.
- **Autorización**: El token JWT incluye información adicional sobre el usuario, como roles y permisos, que se pueden utilizar para autorizar las solicitudes. Se pueden definir diferentes niveles de acceso para proteger los recursos de la aplicación.
- **Base de datos MySQL**: La aplicación utiliza una base de datos MySQL para almacenar la información del usuario y los detalles de autenticación. Se utiliza un repositorio de Spring Data JPA para interactuar con la base de datos de manera eficiente.
- **Relación muchos a muchos**: La aplicación tiene dos tablas, "usuario" y "role", con una relación de muchos a muchos. Esto permite asignar múltiples roles a un usuario y asignar múltiples usuarios a un rol.

## Configuración y ejecución

Sigue estos pasos para configurar y ejecutar la aplicación:

    1. Clona este repositorio en tu máquina local.
    2. Asegúrate de tener Java y Maven instalados en tu sistema.
    3. Configura la conexión a tu base de datos MySQL en el archivo `application.properties`.
    4. Ejecuta el comando `mvn spring-boot:run` para compilar y ejecutar la aplicación.
    5. La aplicación estará disponible en `http://localhost:8080/login` 
       para pedir el token, ademas en el body enviar el username y password (lo encuentras en SpringSecurityJwtApplication)

## Estructura de la base de datos

La aplicación utiliza tres tablas en la base de datos MySQL: "users" y "roles". Estas tablas tienen una relación de muchos a muchos a través de una tabla intermedia llamada "usuario_role". Aquí está la estructura de las tablas:

**Tabla "users"**

| Columna     | Tipo         |
|-------------|--------------|
| id          | INT (PK)     |
| email      | VARCHAR(85) |
| password      | VARCHAR(255) |
| username   | VARCHAR(30) |

**Tabla "roles"**

| Columna | Tipo         |
|---------|--------------|
| id      | INT (PK)     |
| name  | VARCHAR(255)  |

**Tabla "user_roles"**

| Columna    | Tipo     |
|------------|----------|
| user_id | INT (PK) |
| role_id    | INT (PK) |

## Uso

1. Regístrate como nuevo usuario en la aplicación.
2. Inicia sesión utilizando tus credenciales.
3. Recibirás un token JWT válido que deberás incluir en los encabezados de autorización de las solicitudes posteriores.
4. Explora los diferentes endpoints de la API, prestando atención a los niveles de acceso y permisos requeridos.
5. Realiza pruebas utilizando herramientas  como Postman.
