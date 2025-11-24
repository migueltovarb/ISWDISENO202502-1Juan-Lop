package com.gestion.tareas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteProductividadDTO {
    
    private String empleadoId;
    private String nombreEmpleado;
    private long tareasCompletadas;
    private long tareasPendientes;
    private long totalTareasAsignadas;
    private double porcentajeCompletado;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fechaGeneracion;
    
    private List<TareaResumenDTO> detalleCompletadas;
    
    private List<TareaResumenDTO> detallePendientes;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TareaResumenDTO {
        private String id;
        private String titulo;
        private String proyecto;
        private String estado;
        private String prioridad;
        
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date fechaAsignacion;
        
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date fechaCompletado;
    }
}
