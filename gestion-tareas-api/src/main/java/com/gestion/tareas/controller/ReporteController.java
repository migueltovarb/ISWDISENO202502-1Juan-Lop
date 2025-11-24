package com.gestion.tareas.controller;

import com.gestion.tareas.dto.ReporteProductividadDTO;
import com.gestion.tareas.service.ReporteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
@Tag(name = "Reportes", description = "API para generación de reportes")
public class ReporteController {
    
    @Autowired
    private ReporteService reporteService;
    
    @GetMapping("/productividad/{empleadoId}")
    @Operation(
        summary = "Reporte de productividad por empleado",
        description = "Genera un reporte mostrando tareas completadas y pendientes del empleado"
    )
    public ResponseEntity<ReporteProductividadDTO> obtenerReporteProductividad(
            @PathVariable String empleadoId) {
        
        ReporteProductividadDTO reporte = reporteService.generarReporteProductividad(empleadoId);
        return ResponseEntity.ok(reporte);
    }
    
    @GetMapping("/productividad")
    @Operation(
        summary = "Reporte de productividad global",
        description = "Genera un reporte de productividad de todos los empleados activos"
    )
    public ResponseEntity<List<ReporteProductividadDTO>> obtenerReporteProductividadGlobal() {
        List<ReporteProductividadDTO> reportes = reporteService.generarReporteProductividadGlobal();
        return ResponseEntity.ok(reportes);
    }
}
