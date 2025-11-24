package com.gestion.tareas.service;

import com.gestion.tareas.dto.ProyectoDTO;
import com.gestion.tareas.exception.BadRequestException;
import com.gestion.tareas.exception.ResourceNotFoundException;
import com.gestion.tareas.model.Proyecto;
import com.gestion.tareas.repository.ProyectoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    private ProyectoRepository proyectoRepository;
    
    public ProyectoDTO crear(ProyectoDTO proyectoDTO) {
        // Validar que no exista un proyecto con el mismo nombre
        if (proyectoRepository.existsByNombre(proyectoDTO.getNombre())) {
            throw new BadRequestException("Ya existe un proyecto con el nombre: " + proyectoDTO.getNombre());
        }
        
        // Validar fechas
        if (proyectoDTO.getFechaFin().before(proyectoDTO.getFechaInicio())) {
            throw new BadRequestException("La fecha de fin debe ser posterior a la fecha de inicio");
        }
        
        // Crear el proyecto
        Proyecto proyecto = new Proyecto(
                proyectoDTO.getNombre(),
                proyectoDTO.getDescripcion(),
                proyectoDTO.getFechaInicio(),
                proyectoDTO.getFechaFin(),
                proyectoDTO.getPrioridad()
        );
        
        Proyecto proyectoGuardado = proyectoRepository.save(proyecto);
        
        return convertirADTO(proyectoGuardado);
    }
    
    public List<ProyectoDTO> obtenerTodos() {
        return proyectoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    public ProyectoDTO obtenerPorId(String id) {
        ObjectId objectId = convertirAObjectId(id);
        Proyecto proyecto = proyectoRepository.findById(objectId)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id));
        
        return convertirADTO(proyecto);
    }
    
    public Proyecto obtenerProyectoEntidad(ObjectId id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", id.toHexString()));
    }
    
    private ObjectId convertirAObjectId(String id) {
        try {
            return new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("ID de proyecto inválido: " + id);
        }
    }
    
    private ProyectoDTO convertirADTO(Proyecto proyecto) {
        ProyectoDTO dto = new ProyectoDTO();
        dto.setId(proyecto.getId().toHexString());
        dto.setNombre(proyecto.getNombre());
        dto.setDescripcion(proyecto.getDescripcion());
        dto.setFechaInicio(proyecto.getFechaInicio());
        dto.setFechaFin(proyecto.getFechaFin());
        dto.setPrioridad(proyecto.getPrioridad());
        dto.setEstado(proyecto.getEstado());
        dto.setFechaCreacion(proyecto.getFechaCreacion());
        return dto;
    }
}
