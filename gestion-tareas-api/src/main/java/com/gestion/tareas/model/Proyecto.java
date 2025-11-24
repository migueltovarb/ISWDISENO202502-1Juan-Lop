package com.gestion.tareas.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {
    
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    
    private String nombre;
    
    private String descripcion;
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    @Indexed
    private String estado;
    
    private String prioridad;
    
    private Date fechaCreacion;
    
    private Date fechaActualizacion;
    
    public Proyecto(String nombre, String descripcion, Date fechaInicio, Date fechaFin, String prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = "ACTIVO";
        this.prioridad = prioridad;
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }
    
    public void actualizarFechaModificacion() {
        this.fechaActualizacion = new Date();
    }
}
