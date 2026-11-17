# Customers API

API REST de clientes hecha con Java 21 y Spring Boot. 

Permite crear (POST) y listar (GET) clientes en memoria, valida datos y puede
ejecutarse en dos ambientes, dev y prod, con el mismo jar.

## Requisitos

JDK 21 (comprobar con `java -version`)

## Build

```bash
.\mvnw.cmd clean package
```

`.\mvnw.cmd` es solo para Windows. 

En Linux o Mac: `./mvnw clean package`

## Ejecución

### Dev

en Dev el puerto que esta apuntando es 8080

```bash
java -jar target/app.jar --spring.profiles.active=dev
```

LOG terminal:
Ejecutando en DEV | app=customers-dev | puerto=8080 | perfiles=dev

LOG navegador:
```json
{
  "perfiles": [
    "dev"
  ],
  "app": "customers-dev",
  "mensaje": "Ejecutando en DEV"
}
```

### Prod

en Prod el puerto que esta apuntando es 9090

```bash
java -jar target/app.jar --spring.profiles.active=prod
```

LOG terminal:
Ejecutando en PROD | app=customers-prod | puerto=9090 | perfiles=prod

LOG navegador:
```json
{
  "app": "customers-prod",
  "mensaje": "Ejecutando en PROD",
  "perfiles": [
    "prod"
  ]
}
```

## Probar los endpoints

Base URL: `http://localhost:8080` (dev) o `http://localhost:9090` (prod)

- `GET /api/info`: muestra el ambiente
- `GET /api/customers`: lista de clientes
- `POST /api/customers`: crea un cliente

```json
{
  "nombre": "Ana Prueba",
  "email": "ana@ejemplo.com",
  "edad": 27
}
```

| Petición | Respuesta esperada |
|---|---|
| `POST /api/customers` (datos válidos) | `201 Created` con el cliente |
| `POST /api/customers` (email repetido) | `409 Conflict` |
| `POST /api/customers` (email inválido) | `400 Bad Request` con `errores` |
| `GET /api/customers` | `200 OK` con la lista |
| `GET /api/info` | `200 OK` con el ambiente |

## Uso de IA en este proyecto

Usé Claude como mentor para aprender Java y Spring Boot, un stack que no había usado antes. Me armó una ruta de aprendizaje por tickets pequeños, me explicó los conceptos con analogías de Angular y revisó mis errores.

**Qué hice yo:** aprendí a partir de ejemplos de código y escribí el proyecto línea por línea, adaptándolo a mi caso. Adapté las decisiones de arquitectura (capas controller, service y repository, perfiles dev y prod) apoyándome en mi experiencia con Angular, y depuré leyendo logs y stack traces(lista de llamadas que llevó hasta un error, escrita de la más reciente a la más antigua).

**Cómo lo verifiqué:** con Postman y el navegador para los endpoints, con los logs de arranque de cada perfil y con `mvnw clean package` para el build.
