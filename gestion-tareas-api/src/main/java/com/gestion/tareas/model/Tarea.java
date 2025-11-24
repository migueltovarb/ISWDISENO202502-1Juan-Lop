package com.gestion.tareas.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tareas")
@CompoundIndex(name = "proyecto_estado_idx", def = "{'proyectoId': 1, 'estado': 1}")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    
    private String titulo;
    
    private String descripcion;
    
    @Indexed
    private String estado;
    
    private String prioridad;
    
    @Indexed
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId proyectoId;
    
    private String nombreProyecto;
    
    @Indexed
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId empleadoAsignado;
    
    private String nombreEmpleado;
    
    private Date fechaCreacion;
    
    private Date fechaAsignacion;
    
    private Date fechaCompletado;
    
    private Date fechaActualizacion;
    
    private Date fechaEntrega;
    
    public Tarea(String titulo, String descripcion, ObjectId proyectoId, String nombreProyecto, String prioridad, Date fechaEntrega) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.proyectoId = proyectoId;
        this.nombreProyecto = nombreProyecto;
        this.estado = "PENDIENTE";
        this.prioridad = prioridad;
        this.fechaEntrega = fechaEntrega;
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }
    
    public void asignarEmpleado(ObjectId empleadoId, String nombreEmpleado) {
        this.empleadoAsignado = empleadoId;
        this.nombreEmpleado = nombreEmpleado;
        this.fechaAsignacion = new Date();
        this.fechaActualizacion = new Date();
        if ("PENDIENTE".equals(this.estado)) {
            this.estado = "EN_PROGRESO";
        }
    }
    
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        this.fechaActualizacion = new Date();
        
        if ("COMPLETADA".equals(nuevoEstado)) {
            this.fechaCompletado = new Date();
        }
    }
    
    public boolean estaCompletada() {
        return "COMPLETADA".equals(this.estado);
    }
    
    public boolean estaPendiente() {
        return "PENDIENTE".equals(this.estado) || "EN_PROGRESO".equals(this.estado);
    }
}
