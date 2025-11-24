# API Sistema de Gestión de Tareas y Proyectos

Sistema de gestión de tareas y proyectos desarrollado con **Spring Boot** y **MongoDB Atlas**.

## 🚀 Historias de Usuario Implementadas

### ✅ HU003: Crear Proyecto
Permite crear nuevos proyectos en el sistema con nombre, descripción, fechas y prioridad.

### ✅ HU006: Crear Tarea
Permite crear tareas asociadas a un proyecto con título, descripción, prioridad y horas estimadas.

### ✅ HU007: Asignar Tarea
Permite asignar tareas a empleados específicos.

### ✅ HU011: Actualizar Estado de Tarea
Permite cambiar el estado de una tarea (PENDIENTE, EN_PROGRESO, COMPLETADA, CANCELADA).

### ✅ Reporte de Productividad
Genera un reporte mostrando cuántas tareas completó un empleado y cuántas le faltan.

---

## 📋 Requisitos Previos

- **Java 17** o superior
- **Maven 3.8+**
- **MongoDB Atlas** (cuenta gratuita)
- IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## ⚙️ Configuración

### 1. Clonar o Crear el Proyecto

Copia todos los archivos a tu directorio de proyecto.

### 2. Configurar MongoDB Atlas

1. Crea una cuenta en [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
2. Crea un cluster gratuito
3. Crea un usuario de base de datos
4. Obtén la URI de conexión

### 3. Actualizar application.properties

Edita `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.xxxxx.mongodb.net/gestion_tareas?retryWrites=true&w=majority
```

Reemplaza:
- `<username>` con tu usuario de MongoDB
- `<password>` con tu contraseña
- `cluster0.xxxxx` con tu cluster

---

## 🏃 Ejecutar la Aplicación

### Opción 1: Desde la línea de comandos

```bash
mvn spring-boot:run
```

### Opción 2: Desde el IDE

Ejecuta la clase `GestionTareasApplication.java`

### Opción 3: Generar JAR

```bash
mvn clean package
java -jar target/tareas-api-1.0.0.jar
```

---

## 📡 Endpoints de la API

### Base URL
```
http://localhost:8080
```

### Swagger UI (Documentación Interactiva)
```
http://localhost:8080/swagger-ui.html
```

---

## 🔌 Endpoints Principales

### 1. Usuarios/Empleados

#### Crear Empleado
```http
POST /api/usuarios
Content-Type: application/json

{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@empresa.com",
  "cargo": "Desarrollador",
  "activo": true
}
```

#### Listar Empleados
```http
GET /api/usuarios
```

---

### 2. Proyectos (HU003)

#### HU003: Crear Proyecto
```http
POST /api/proyectos
Content-Type: application/json

{
  "nombre": "Sistema de Ventas",
  "descripcion": "Desarrollo de sistema web para gestión de ventas",
  "fechaInicio": "2025-01-20",
  "fechaFin": "2025-06-30",
  "prioridad": "ALTA"
}
```

#### Listar Proyectos
```http
GET /api/proyectos
```

#### Obtener Proyecto por ID
```http
GET /api/proyectos/{id}
```

---

### 3. Tareas (HU006, HU007, HU011)

#### HU006: Crear Tarea
```http
POST /api/tareas
Content-Type: application/json

{
  "titulo": "Diseñar base de datos",
  "descripcion": "Crear el modelo entidad-relación y diagrama de clases",
  "proyectoId": "67890abcd1234ef56789",
  "prioridad": "ALTA",
  "horasEstimadas": 16.0
}
```

#### HU007: Asignar Tarea a Empleado
```http
POST /api/tareas/{tareaId}/asignar
Content-Type: application/json

{
  "empleadoId": "67890abcd1234ef56789"
}
```

#### HU011: Actualizar Estado de Tarea
```http
PATCH /api/tareas/{tareaId}/estado
Content-Type: application/json

{
  "estado": "COMPLETADA"
}
```

**Estados válidos:**
- `PENDIENTE`
- `EN_PROGRESO`
- `COMPLETADA`
- `CANCELADA`

#### Listar Tareas
```http
GET /api/tareas
```

#### Tareas por Proyecto
```http
GET /api/tareas/proyecto/{proyectoId}
```

#### Tareas por Empleado
```http
GET /api/tareas/empleado/{empleadoId}
```

---

### 4. Reportes de Productividad

#### Reporte por Empleado
```http
GET /api/reportes/productividad/{empleadoId}
```

**Respuesta:**
```json
{
  "empleadoId": "67890abcd1234ef56789",
  "nombreEmpleado": "Juan Pérez",
  "tareasCompletadas": 15,
  "tareasPendientes": 5,
  "totalTareasAsignadas": 20,
  "porcentajeCompletado": 75.0,
  "fechaGeneracion": "2025-01-16 10:30:00",
  "detalleCompletadas": [
    {
      "id": "abc123",
      "titulo": "Diseñar base de datos",
      "proyecto": "Sistema de Ventas",
      "estado": "COMPLETADA",
      "prioridad": "ALTA",
      "fechaAsignacion": "2025-01-10 09:00:00",
      "fechaCompletado": "2025-01-15 17:30:00"
    }
  ],
  "detallePendientes": [
    {
      "id": "def456",
      "titulo": "Implementar API REST",
      "proyecto": "Sistema de Ventas",
      "estado": "EN_PROGRESO",
      "prioridad": "MEDIA",
      "fechaAsignacion": "2025-01-14 10:00:00",
      "fechaCompletado": null
    }
  ]
}
```

#### Reporte Global (Todos los Empleados)
```http
GET /api/reportes/productividad
```

---

## 🧪 Pruebas con Postman

### Colección de Postman

Importa esta colección en Postman:

```json
{
  "info": {
    "name": "Gestión de Tareas API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "1. Crear Empleado",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nombre\": \"Juan\",\n  \"apellido\": \"Pérez\",\n  \"email\": \"juan@empresa.com\",\n  \"cargo\": \"Desarrollador\"\n}"
        },
        "url": "http://localhost:8080/api/usuarios"
      }
    },
    {
      "name": "2. Crear Proyecto (HU003)",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nombre\": \"Sistema de Ventas\",\n  \"descripcion\": \"Sistema web\",\n  \"fechaInicio\": \"2025-01-20\",\n  \"fechaFin\": \"2025-06-30\",\n  \"prioridad\": \"ALTA\"\n}"
        },
        "url": "http://localhost:8080/api/proyectos"
      }
    },
    {
      "name": "3. Crear Tarea (HU006)",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"titulo\": \"Diseñar BD\",\n  \"descripcion\": \"Modelo ER\",\n  \"proyectoId\": \"REEMPLAZAR_CON_ID\",\n  \"prioridad\": \"ALTA\",\n  \"horasEstimadas\": 16.0\n}"
        },
        "url": "http://localhost:8080/api/tareas"
      }
    },
    {
      "name": "4. Asignar Tarea (HU007)",
      "request": {
        "method": "POST",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"empleadoId\": \"REEMPLAZAR_CON_ID\"\n}"
        },
        "url": "http://localhost:8080/api/tareas/TAREA_ID/asignar"
      }
    },
    {
      "name": "5. Actualizar Estado (HU011)",
      "request": {
        "method": "PATCH",
        "header": [{"key": "Content-Type", "value": "application/json"}],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"estado\": \"COMPLETADA\"\n}"
        },
        "url": "http://localhost:8080/api/tareas/TAREA_ID/estado"
      }
    },
    {
      "name": "6. Reporte Productividad",
      "request": {
        "method": "GET",
        "url": "http://localhost:8080/api/reportes/productividad/EMPLEADO_ID"
      }
    }
  ]
}
```

---

## 📁 Estructura del Proyecto

```
gestion-tareas-api/
├── src/
│   ├── main/
│   │   ├── java/com/gestion/tareas/
│   │   │   ├── model/
│   │   │   │   ├── Usuario.java
│   │   │   │   ├── Proyecto.java
│   │   │   │   └── Tarea.java
│   │   │   ├── repository/
│   │   │   │   ├── UsuarioRepository.java
│   │   │   │   ├── ProyectoRepository.java
│   │   │   │   └── TareaRepository.java
│   │   │   ├── service/
│   │   │   │   ├── ProyectoService.java
│   │   │   │   ├── TareaService.java
│   │   │   │   └── ReporteService.java
│   │   │   ├── controller/
│   │   │   │   ├── ProyectoController.java
│   │   │   │   ├── TareaController.java
│   │   │   │   ├── ReporteController.java
│   │   │   │   └── UsuarioController.java
│   │   │   ├── dto/
│   │   │   │   ├── ProyectoDTO.java
│   │   │   │   ├── TareaDTO.java
│   │   │   │   ├── AsignarTareaDTO.java
│   │   │   │   ├── ActualizarEstadoDTO.java
│   │   │   │   ├── ReporteProductividadDTO.java
│   │   │   │   └── ErrorResponse.java
│   │   │   ├── exception/
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   │   ├── BadRequestException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   ├── config/
│   │   │   │   └── SwaggerConfig.java
│   │   │   └── GestionTareasApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

---

## 🔍 Validaciones Implementadas

### Proyectos (HU003):
- ✅ Nombre obligatorio y único
- ✅ Descripción obligatoria
- ✅ Fechas válidas (fin > inicio)
- ✅ Prioridad obligatoria (ALTA, MEDIA, BAJA)

### Tareas (HU006):
- ✅ Título y descripción obligatorios
- ✅ Proyecto debe existir
- ✅ Prioridad obligatoria
- ✅ Horas estimadas positivas

### Asignar Tarea (HU007):
- ✅ Empleado debe existir
- ✅ Empleado debe estar activo
- ✅ Tarea no puede estar completada/cancelada

### Actualizar Estado (HU011):
- ✅ Estado válido
- ✅ No se puede volver a PENDIENTE
- ✅ No se puede cambiar si está COMPLETADA/CANCELADA

---

## 🐛 Manejo de Errores

Todas las respuestas de error siguen el formato:

```json
{
  "timestamp": "2025-01-16 10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Proyecto no encontrado con id: '123'",
  "path": "/api/proyectos/123"
}
```

**Códigos HTTP:**
- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado
- `400 Bad Request` - Datos inválidos
- `404 Not Found` - Recurso no encontrado
- `500 Internal Server Error` - Error del servidor

---

## 🎯 Características Técnicas

- ✅ **Spring Boot 3.2.0**
- ✅ **MongoDB con Spring Data**
- ✅ **Validación con Jakarta Validation**
- ✅ **Documentación con Swagger/OpenAPI**
- ✅ **Manejo centralizado de excepciones**
- ✅ **DTOs para transferencia de datos**
- ✅ **Arquitectura en capas (Controller-Service-Repository)**
- ✅ **CORS habilitado**
- ✅ **Lombok para reducir boilerplate**

---

## 📝 Notas Adicionales

### MongoDB Atlas - Colecciones Creadas:
- `usuarios` - Empleados del sistema
- `proyectos` - Proyectos activos
- `tareas` - Tareas asignadas

### Índices Automáticos:
- `usuarios.email` - Único
- `proyectos.estado` - Para búsquedas
- `tareas.proyectoId + estado` - Compuesto

---

## 🤝 Soporte

Para problemas o preguntas, contacta al equipo de desarrollo.

---

## 📄 Licencia

MIT License

---

¡API lista para usar! 🚀
