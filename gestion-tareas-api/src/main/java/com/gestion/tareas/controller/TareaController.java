package com.gestion.tareas.controller;

import com.gestion.tareas.dto.ActualizarEstadoDTO;
import com.gestion.tareas.dto.AsignarTareaDTO;
import com.gestion.tareas.dto.TareaDTO;
import com.gestion.tareas.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
@Tag(name = "Tareas", description = "API para gestión de tareas")
public class TareaController {
    
    @Autowired
    private TareaService tareaService;
    
    @PostMapping
    @Operation(summary = "Crear tarea", description = "Crea una nueva tarea en un proyecto")
    public ResponseEntity<TareaDTO> crearTarea(@Valid @RequestBody TareaDTO tareaDTO) {
        TareaDTO nuevaTarea = tareaService.crear(tareaDTO);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }
    
    @PostMapping("/{tareaId}/asignar")
    @Operation(summary = "Asignar tarea", description = "Asigna una tarea a un empleado")
    public ResponseEntity<TareaDTO> asignarTarea(
            @PathVariable String tareaId,
            @Valid @RequestBody AsignarTareaDTO asignarDTO) {
        
        TareaDTO tareaAsignada = tareaService.asignarTarea(tareaId, asignarDTO);
        return ResponseEntity.ok(tareaAsignada);
    }
    
    @PatchMapping("/{tareaId}/estado")
    @Operation(summary = "Actualizar estado", description = "Actualiza el estado de una tarea")
    public ResponseEntity<TareaDTO> actualizarEstado(
            @PathVariable String tareaId,
            @Valid @RequestBody ActualizarEstadoDTO estadoDTO) {
        
        TareaDTO tareaActualizada = tareaService.actualizarEstado(tareaId, estadoDTO);
        return ResponseEntity.ok(tareaActualizada);
    }
    
    @GetMapping
    @Operation(summary = "Listar tareas", description = "Obtiene todas las tareas")
    public ResponseEntity<List<TareaDTO>> obtenerTodasLasTareas() {
        List<TareaDTO> tareas = tareaService.obtenerTodas();
        return ResponseEntity.ok(tareas);
    }
    
    @GetMapping("/proyecto/{proyectoId}")
    @Operation(summary = "Tareas por proyecto", description = "Obtiene todas las tareas de un proyecto")
    public ResponseEntity<List<TareaDTO>> obtenerTareasPorProyecto(@PathVariable String proyectoId) {
        List<TareaDTO> tareas = tareaService.obtenerPorProyecto(proyectoId);
        return ResponseEntity.ok(tareas);
    }
    
    @GetMapping("/empleado/{empleadoId}")
    @Operation(summary = "Tareas por empleado", description = "Obtiene todas las tareas asignadas a un empleado")
    public ResponseEntity<List<TareaDTO>> obtenerTareasPorEmpleado(@PathVariable String empleadoId) {
        List<TareaDTO> tareas = tareaService.obtenerPorEmpleado(empleadoId);
        return ResponseEntity.ok(tareas);
    }
}
