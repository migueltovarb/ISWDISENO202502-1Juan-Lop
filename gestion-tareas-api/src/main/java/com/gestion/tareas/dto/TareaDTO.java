package com.gestion.tareas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {
    
    private String id;
    
    @NotBlank(message = "El título de la tarea es obligatorio")
    private String titulo;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    @NotBlank(message = "El ID del proyecto es obligatorio")
    private String proyectoId;
    
    private String nombreProyecto;
    
    @NotBlank(message = "La prioridad es obligatoria")
    private String prioridad;
    
    @NotNull(message = "La fecha de entrega es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;
    
    private String estado;
    
    private String empleadoAsignado;
    
    private String nombreEmpleado;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaCreacion;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaAsignacion;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaCompletado;
}
