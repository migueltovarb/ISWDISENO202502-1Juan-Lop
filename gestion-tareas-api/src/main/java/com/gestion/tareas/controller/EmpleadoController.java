package com.gestion.tareas.controller;

import com.gestion.tareas.model.Empleado;
import com.gestion.tareas.repository.EmpleadoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
@Tag(name = "Empleados", description = "API para gestión de empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @PostMapping
    @Operation(summary = "Crear empleado", description = "Crea un nuevo empleado en el sistema")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoRepository.save(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }
    
    @GetMapping
    @Operation(summary = "Listar empleados", description = "Obtiene todos los empleados")
    public ResponseEntity<List<Empleado>> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return ResponseEntity.ok(empleados);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener empleado", description = "Obtiene un empleado por su ID")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable String id) {
        return empleadoRepository.findById(new org.bson.types.ObjectId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
