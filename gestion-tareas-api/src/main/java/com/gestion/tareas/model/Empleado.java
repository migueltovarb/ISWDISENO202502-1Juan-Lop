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

@Document(collection = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    
    private String nombre;
    
    private String apellido;
    
    @Indexed(unique = true)
    private String email;
    
    private String cargo;
    
    private String departamento;
    
    private boolean activo;
    
    private Date fechaRegistro;
    
    public Empleado(String nombre, String apellido, String email, String cargo, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cargo = cargo;
        this.departamento = departamento;
        this.activo = true;
        this.fechaRegistro = new Date();
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
