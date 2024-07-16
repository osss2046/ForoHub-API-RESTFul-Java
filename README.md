# ForoHub API
ForoHub es una API Rest para gestionar mensajes de foro, ofreciendo un CRUD completo en /topicos. Utiliza JWT para la autorización y solo los usuarios autenticados pueden acceder a los endpoints. Se gestiona desde el backend y utiliza MySQL como base de datos.

## Tecnologías Utilizadas
- Java 21.0.3
- Spring Boot 3.3.1
- Spring Security
- Hibernate
- MySQL

## Endpoints
### /topicos
- GET /topicos: Obtiene todos los tópicos.
- GET /topicos/{id}: Obtiene un tópico por ID.
- POST /topicos: Crea un nuevo tópico.
- PUT /topicos/{id}: Actualiza un tópico.
- DELETE /topicos/{id}: Elimina un tópico.

## Seguridad
La API utiliza JWT. solo usuarios registrados pueden acceder a los endpoints.

- POST /login: Autentica un usuario y retorna un token JWT.

## Configuración
Clona el repositorio.
Configura application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.security.jwt.secret=tu_jwt_secreto
```
