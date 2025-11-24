# Ejemplos de Uso de la API con CURL

## 🔷 1. CREAR EMPLEADO

```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan",
    "apellido": "Pérez",
    "email": "juan.perez@empresa.com",
    "cargo": "Desarrollador Backend",
    "activo": true
  }'
```

**Respuesta esperada:**
```json
{
  "id": "678f1234abc567890def1234",
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@empresa.com",
  "cargo": "Desarrollador Backend",
  "activo": true,
  "fechaRegistro": "2025-01-16T10:30:00"
}
```

---

## 🔷 2. HU003 - CREAR PROYECTO

```bash
curl -X POST http://localhost:8080/api/proyectos \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Sistema de Gestión de Ventas",
    "descripcion": "Desarrollo de aplicación web para gestión integral de ventas",
    "fechaInicio": "2025-01-20",
    "fechaFin": "2025-06-30",
    "prioridad": "ALTA"
  }'
```

**Respuesta esperada:**
```json
{
  "id": "678f5678abc567890def5678",
  "nombre": "Sistema de Gestión de Ventas",
  "descripcion": "Desarrollo de aplicación web para gestión integral de ventas",
  "fechaInicio": "2025-01-20",
  "fechaFin": "2025-06-30",
  "prioridad": "ALTA",
  "estado": "ACTIVO",
  "fechaCreacion": "2025-01-16 10:35:00"
}
```

**💡 IMPORTANTE:** Guarda el `id` del proyecto para usarlo en los siguientes pasos.

---

## 🔷 3. HU006 - CREAR TAREA

Reemplaza `PROYECTO_ID` con el ID del proyecto creado anteriormente:

```bash
curl -X POST http://localhost:8080/api/tareas \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Diseñar modelo de base de datos",
    "descripcion": "Crear el modelo entidad-relación y diagrama de clases para el sistema",
    "proyectoId": "PROYECTO_ID",
    "prioridad": "ALTA",
    "fechaEntrega": "2025-02-15"
  }'
```

**Respuesta esperada:**
```json
{
  "id": "678f9abc123456789def9abc",
  "titulo": "Diseñar modelo de base de datos",
  "descripcion": "Crear el modelo entidad-relación y diagrama de clases para el sistema",
  "proyectoId": "678f5678abc567890def5678",
  "nombreProyecto": "Sistema de Gestión de Ventas",
  "prioridad": "ALTA",
  "fechaEntrega": "2025-02-15",
  "estado": "PENDIENTE",
  "empleadoAsignado": null,
  "nombreEmpleado": null,
  "fechaCreacion": "2025-01-16 10:40:00",
  "fechaAsignacion": null,
  "fechaCompletado": null
}
```

**💡 IMPORTANTE:** Guarda el `id` de la tarea para los siguientes pasos.

---

## 🔷 4. HU007 - ASIGNAR TAREA A EMPLEADO

Reemplaza `TAREA_ID` y `EMPLEADO_ID` con los IDs correspondientes:

```bash
curl -X POST http://localhost:8080/api/tareas/TAREA_ID/asignar \
  -H "Content-Type: application/json" \
  -d '{
    "empleadoId": "EMPLEADO_ID"
  }'
```

**Ejemplo real:**
```bash
curl -X POST http://localhost:8080/api/tareas/678f9abc123456789def9abc/asignar \
  -H "Content-Type: application/json" \
  -d '{
    "empleadoId": "678f1234abc567890def1234"
  }'
```

**Respuesta esperada:**
```json
{
  "id": "678f9abc123456789def9abc",
  "titulo": "Diseñar modelo de base de datos",
  "descripcion": "Crear el modelo entidad-relación y diagrama de clases para el sistema",
  "proyectoId": "678f5678abc567890def5678",
  "nombreProyecto": "Sistema de Gestión de Ventas",
  "prioridad": "ALTA",
  "fechaEntrega": "2025-02-15",
  "estado": "EN_PROGRESO",
  "empleadoAsignado": "678f1234abc567890def1234",
  "nombreEmpleado": "Juan Pérez",
  "fechaCreacion": "2025-01-16 10:40:00",
  "fechaAsignacion": "2025-01-16 10:45:00",
  "fechaCompletado": null
}
```

**✅ Nota:** El estado cambia automáticamente de PENDIENTE a EN_PROGRESO.

---

## 🔷 5. HU011 - ACTUALIZAR ESTADO DE TAREA

### Cambiar a EN_PROGRESO
```bash
curl -X PATCH http://localhost:8080/api/tareas/TAREA_ID/estado \
  -H "Content-Type: application/json" \
  -d '{
    "estado": "EN_PROGRESO"
  }'
```

### Cambiar a COMPLETADA
```bash
curl -X PATCH http://localhost:8080/api/tareas/678f9abc123456789def9abc/estado \
  -H "Content-Type: application/json" \
  -d '{
    "estado": "COMPLETADA"
  }'
```

**Respuesta esperada:**
```json
{
  "id": "678f9abc123456789def9abc",
  "titulo": "Diseñar modelo de base de datos",
  "descripcion": "Crear el modelo entidad-relación y diagrama de clases para el sistema",
  "proyectoId": "678f5678abc567890def5678",
  "nombreProyecto": "Sistema de Gestión de Ventas",
  "prioridad": "ALTA",
  "fechaEntrega": "2025-02-15",
  "estado": "COMPLETADA",
  "empleadoAsignado": "678f1234abc567890def1234",
  "nombreEmpleado": "Juan Pérez",
  "fechaCreacion": "2025-01-16 10:40:00",
  "fechaAsignacion": "2025-01-16 10:45:00",
  "fechaCompletado": "2025-01-16 11:00:00"
}
```

**Estados válidos:**
- `PENDIENTE`
- `EN_PROGRESO`
- `COMPLETADA`
- `CANCELADA`

---

## 🔷 6. REPORTE DE PRODUCTIVIDAD

### Por Empleado Específico
```bash
curl -X GET http://localhost:8080/api/reportes/productividad/EMPLEADO_ID
```

**Ejemplo real:**
```bash
curl -X GET http://localhost:8080/api/reportes/productividad/678f1234abc567890def1234
```

**Respuesta esperada:**
```json
{
  "empleadoId": "678f1234abc567890def1234",
  "nombreEmpleado": "Juan Pérez",
  "tareasCompletadas": 15,
  "tareasPendientes": 5,
  "totalTareasAsignadas": 20,
  "porcentajeCompletado": 75.0,
  "fechaGeneracion": "2025-01-16 11:15:00",
  "detalleCompletadas": [
    {
      "id": "678f9abc123456789def9abc",
      "titulo": "Diseñar modelo de base de datos",
      "proyecto": "Sistema de Gestión de Ventas",
      "estado": "COMPLETADA",
      "prioridad": "ALTA",
      "fechaAsignacion": "2025-01-16 10:45:00",
      "fechaCompletado": "2025-01-16 11:00:00"
    }
  ],
  "detallePendientes": [
    {
      "id": "678fdef1234567890abcdef1",
      "titulo": "Implementar API REST",
      "proyecto": "Sistema de Gestión de Ventas",
      "estado": "EN_PROGRESO",
      "prioridad": "MEDIA",
      "fechaAsignacion": "2025-01-15 09:00:00",
      "fechaCompletado": null
    }
  ]
}
```

### Reporte Global (Todos los Empleados)
```bash
curl -X GET http://localhost:8080/api/reportes/productividad
```

---

## 🔷 CONSULTAS ADICIONALES

### Listar todos los empleados
```bash
curl -X GET http://localhost:8080/api/usuarios
```

### Listar todos los proyectos
```bash
curl -X GET http://localhost:8080/api/proyectos
```

### Obtener proyecto específico
```bash
curl -X GET http://localhost:8080/api/proyectos/PROYECTO_ID
```

### Listar todas las tareas
```bash
curl -X GET http://localhost:8080/api/tareas
```

### Tareas de un proyecto específico
```bash
curl -X GET http://localhost:8080/api/tareas/proyecto/PROYECTO_ID
```

### Tareas asignadas a un empleado
```bash
curl -X GET http://localhost:8080/api/tareas/empleado/EMPLEADO_ID
```

---

## 🔷 FLUJO COMPLETO DE PRUEBA

```bash
# 1. Crear empleado
EMPLEADO_RESPONSE=$(curl -s -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan","apellido":"Pérez","email":"juan@empresa.com","cargo":"Dev"}')
EMPLEADO_ID=$(echo $EMPLEADO_RESPONSE | jq -r '.id')
echo "Empleado creado: $EMPLEADO_ID"

# 2. Crear proyecto
PROYECTO_RESPONSE=$(curl -s -X POST http://localhost:8080/api/proyectos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Proyecto Test","descripcion":"Desc","fechaInicio":"2025-01-20","fechaFin":"2025-06-30","prioridad":"ALTA"}')
PROYECTO_ID=$(echo $PROYECTO_RESPONSE | jq -r '.id')
echo "Proyecto creado: $PROYECTO_ID"

# 3. Crear tarea
TAREA_RESPONSE=$(curl -s -X POST http://localhost:8080/api/tareas \
  -H "Content-Type: application/json" \
  -d "{\"titulo\":\"Tarea Test\",\"descripcion\":\"Desc\",\"proyectoId\":\"$PROYECTO_ID\",\"prioridad\":\"ALTA\",\"fechaEntrega\":\"2025-02-15\"}")
TAREA_ID=$(echo $TAREA_RESPONSE | jq -r '.id')
echo "Tarea creada: $TAREA_ID"

# 4. Asignar tarea
curl -X POST http://localhost:8080/api/tareas/$TAREA_ID/asignar \
  -H "Content-Type: application/json" \
  -d "{\"empleadoId\":\"$EMPLEADO_ID\"}"

# 5. Completar tarea
curl -X PATCH http://localhost:8080/api/tareas/$TAREA_ID/estado \
  -H "Content-Type: application/json" \
  -d '{"estado":"COMPLETADA"}'

# 6. Ver reporte
curl -X GET http://localhost:8080/api/reportes/productividad/$EMPLEADO_ID
```

---

## 🔷 EJEMPLOS DE ERRORES

### Error: Proyecto no encontrado
```bash
curl -X GET http://localhost:8080/api/proyectos/123invalid
```

**Respuesta:**
```json
{
  "timestamp": "2025-01-16 11:30:00",
  "status": 400,
  "error": "Invalid Argument",
  "message": "ID inválido: 123invalid",
  "path": "/api/proyectos/123invalid"
}
```

### Error: Campo obligatorio faltante
```bash
curl -X POST http://localhost:8080/api/proyectos \
  -H "Content-Type: application/json" \
  -d '{"descripcion":"Test"}'
```

**Respuesta:**
```json
{
  "timestamp": "2025-01-16 11:31:00",
  "status": 400,
  "error": "Validation Error",
  "message": "nombre: El nombre del proyecto es obligatorio",
  "path": "/api/proyectos"
}
```

---

¡Ejemplos listos para usar! 🚀
