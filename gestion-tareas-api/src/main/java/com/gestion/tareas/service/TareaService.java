package com.gestion.tareas.service;

import com.gestion.tareas.dto.ActualizarEstadoDTO;
import com.gestion.tareas.dto.AsignarTareaDTO;
import com.gestion.tareas.dto.TareaDTO;
import com.gestion.tareas.exception.BadRequestException;
import com.gestion.tareas.exception.ResourceNotFoundException;
import com.gestion.tareas.model.Proyecto;
import com.gestion.tareas.model.Tarea;
import com.gestion.tareas.model.Empleado;
import com.gestion.tareas.repository.TareaRepository;
import com.gestion.tareas.repository.EmpleadoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TareaService {
    
    @Autowired
    private TareaRepository tareaRepository;
    
    @Autowired
    private ProyectoService proyectoService;
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    public TareaDTO crear(TareaDTO tareaDTO) {
        // Validar que el proyecto exista
        ObjectId proyectoId = convertirAObjectId(tareaDTO.getProyectoId());
        Proyecto proyecto = proyectoService.obtenerProyectoEntidad(proyectoId);
        
        // Crear la tarea
        Tarea tarea = new Tarea(
                tareaDTO.getTitulo(),
                tareaDTO.getDescripcion(),
                proyectoId,
                proyecto.getNombre(),
                tareaDTO.getPrioridad(),
                tareaDTO.getFechaEntrega()
        );
        
        Tarea tareaGuardada = tareaRepository.save(tarea);
        
        return convertirADTO(tareaGuardada);
    }
    
    public TareaDTO asignarTarea(String tareaId, AsignarTareaDTO asignarDTO) {
        // Buscar la tarea
        ObjectId tareaObjectId = convertirAObjectId(tareaId);
        Tarea tarea = tareaRepository.findById(tareaObjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
        
        // Validar que la tarea no esté completada
        if ("COMPLETADA".equals(tarea.getEstado()) || "CANCELADA".equals(tarea.getEstado())) {
            throw new BadRequestException("No se puede asignar una tarea que está " + tarea.getEstado());
        }
        
        // Buscar el empleado
        ObjectId empleadoId = convertirAObjectId(asignarDTO.getEmpleadoId());
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", asignarDTO.getEmpleadoId()));
        
        // Validar que el empleado esté activo
        if (!empleado.isActivo()) {
            throw new BadRequestException("El empleado no está activo");
        }
        
        // Asignar la tarea
        tarea.asignarEmpleado(empleadoId, empleado.getNombreCompleto());
        
        Tarea tareaActualizada = tareaRepository.save(tarea);
        
        return convertirADTO(tareaActualizada);
    }
    
    public TareaDTO actualizarEstado(String tareaId, ActualizarEstadoDTO estadoDTO) {
        // Buscar la tarea
        ObjectId tareaObjectId = convertirAObjectId(tareaId);
        Tarea tarea = tareaRepository.findById(tareaObjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea", "id", tareaId));
        
        // Validar transición de estado
        validarTransicionEstado(tarea.getEstado(), estadoDTO.getEstado());
        
        // Actualizar el estado
        tarea.actualizarEstado(estadoDTO.getEstado());
        
        Tarea tareaActualizada = tareaRepository.save(tarea);
        
        return convertirADTO(tareaActualizada);
    }
    
    public List<TareaDTO> obtenerTodas() {
        return tareaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    public List<TareaDTO> obtenerPorProyecto(String proyectoId) {
        ObjectId objectId = convertirAObjectId(proyectoId);
        return tareaRepository.findByProyectoId(objectId)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    public List<TareaDTO> obtenerPorEmpleado(String empleadoId) {
        ObjectId objectId = convertirAObjectId(empleadoId);
        return tareaRepository.findByEmpleadoAsignado(objectId)
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    private void validarTransicionEstado(String estadoActual, String nuevoEstado) {
        // Validar que no se pueda volver a PENDIENTE desde otros estados
        if ("PENDIENTE".equals(nuevoEstado) && !"PENDIENTE".equals(estadoActual)) {
            throw new BadRequestException("No se puede volver al estado PENDIENTE");
        }
        
        // No se puede cambiar estado si ya está completada o cancelada
        if ("COMPLETADA".equals(estadoActual) || "CANCELADA".equals(estadoActual)) {
            throw new BadRequestException("No se puede cambiar el estado de una tarea " + estadoActual);
        }
    }
    
    private ObjectId convertirAObjectId(String id) {
        try {
            return new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("ID inválido: " + id);
        }
    }
    
    private TareaDTO convertirADTO(Tarea tarea) {
        TareaDTO dto = new TareaDTO();
        dto.setId(tarea.getId().toHexString());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setProyectoId(tarea.getProyectoId().toHexString());
        dto.setNombreProyecto(tarea.getNombreProyecto());
        dto.setPrioridad(tarea.getPrioridad());
        dto.setFechaEntrega(tarea.getFechaEntrega());
        dto.setEstado(tarea.getEstado());
        
        if (tarea.getEmpleadoAsignado() != null) {
            dto.setEmpleadoAsignado(tarea.getEmpleadoAsignado().toHexString());
            dto.setNombreEmpleado(tarea.getNombreEmpleado());
        }
        
        dto.setFechaCreacion(tarea.getFechaCreacion());
        dto.setFechaAsignacion(tarea.getFechaAsignacion());
        dto.setFechaCompletado(tarea.getFechaCompletado());
        
        return dto;
    }
}
