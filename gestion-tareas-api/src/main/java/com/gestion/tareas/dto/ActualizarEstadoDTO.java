package com.gestion.tareas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualizarEstadoDTO {
    
    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "PENDIENTE|EN_PROGRESO|COMPLETADA|CANCELADA", 
             message = "Estado inválido. Valores permitidos: PENDIENTE, EN_PROGRESO, COMPLETADA, CANCELADA")
    private String estado;
}
