package com.gestion.tareas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignarTareaDTO {
    
    @NotBlank(message = "El ID del empleado es obligatorio")
    private String empleadoId;
}
