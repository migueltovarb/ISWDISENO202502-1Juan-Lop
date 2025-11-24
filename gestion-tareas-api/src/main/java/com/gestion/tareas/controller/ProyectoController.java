package com.gestion.tareas.controller;

import com.gestion.tareas.dto.ProyectoDTO;
import com.gestion.tareas.service.ProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "*")
@Tag(name = "Proyectos", description = "API para gestión de proyectos")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyectoService;
    
    @PostMapping
    @Operation(summary = "Crear proyecto", description = "Crea un nuevo proyecto en el sistema")
    public ResponseEntity<ProyectoDTO> crearProyecto(@Valid @RequestBody ProyectoDTO proyectoDTO) {
        ProyectoDTO nuevoProyecto = proyectoService.crear(proyectoDTO);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }
    
    @GetMapping
    @Operation(summary = "Listar proyectos", description = "Obtiene todos los proyectos")
    public ResponseEntity<List<ProyectoDTO>> obtenerTodosLosProyectos() {
        List<ProyectoDTO> proyectos = proyectoService.obtenerTodos();
        return ResponseEntity.ok(proyectos);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener proyecto", description = "Obtiene un proyecto por su ID")
    public ResponseEntity<ProyectoDTO> obtenerProyectoPorId(@PathVariable String id) {
        ProyectoDTO proyecto = proyectoService.obtenerPorId(id);
        return ResponseEntity.ok(proyecto);
    }
}
