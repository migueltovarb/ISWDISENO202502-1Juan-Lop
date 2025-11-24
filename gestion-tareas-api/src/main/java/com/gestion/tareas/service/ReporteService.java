package com.gestion.tareas.service;

import com.gestion.tareas.dto.ReporteProductividadDTO;
import com.gestion.tareas.exception.ResourceNotFoundException;
import com.gestion.tareas.model.Tarea;
import com.gestion.tareas.model.Empleado;
import com.gestion.tareas.repository.TareaRepository;
import com.gestion.tareas.repository.EmpleadoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {
    
    @Autowired
    private TareaRepository tareaRepository;
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    public ReporteProductividadDTO generarReporteProductividad(String empleadoId) {
        ObjectId empleadoObjectId;
        try {
            empleadoObjectId = new ObjectId(empleadoId);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("Empleado", "id", empleadoId);
        }
        
        Empleado empleado = empleadoRepository.findById(empleadoObjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", empleadoId));
        
        List<Tarea> tareasCompletadas = tareaRepository.findTareasCompletadasByEmpleado(empleadoObjectId);
        
        List<Tarea> tareasPendientes = tareaRepository.findTareasPendientesByEmpleado(empleadoObjectId);
        
        long totalCompletadas = tareasCompletadas.size();
        long totalPendientes = tareasPendientes.size();
        long totalAsignadas = totalCompletadas + totalPendientes;
        
        double porcentajeCompletado = 0.0;
        if (totalAsignadas > 0) {
            porcentajeCompletado = (totalCompletadas * 100.0) / totalAsignadas;
        }
        
        ReporteProductividadDTO reporte = new ReporteProductividadDTO();
        reporte.setEmpleadoId(empleadoId);
        reporte.setNombreEmpleado(empleado.getNombreCompleto());
        reporte.setTareasCompletadas(totalCompletadas);
        reporte.setTareasPendientes(totalPendientes);
        reporte.setTotalTareasAsignadas(totalAsignadas);
        reporte.setPorcentajeCompletado(Math.round(porcentajeCompletado * 100.0) / 100.0);
        reporte.setFechaGeneracion(new Date());
        
        List<ReporteProductividadDTO.TareaResumenDTO> detalleCompletadas = tareasCompletadas.stream()
                .map(this::convertirATareaResumen)
                .collect(Collectors.toList());
        reporte.setDetalleCompletadas(detalleCompletadas);
        
        List<ReporteProductividadDTO.TareaResumenDTO> detallePendientes = tareasPendientes.stream()
                .map(this::convertirATareaResumen)
                .collect(Collectors.toList());
        reporte.setDetallePendientes(detallePendientes);
        
        return reporte;
    }
    
    public List<ReporteProductividadDTO> generarReporteProductividadGlobal() {
        List<Empleado> empleados = empleadoRepository.findAll();
        
        return empleados.stream()
                .filter(Empleado::isActivo)
                .map(empleado -> generarReporteProductividad(empleado.getId().toHexString()))
                .collect(Collectors.toList());
    }
    
    private ReporteProductividadDTO.TareaResumenDTO convertirATareaResumen(Tarea tarea) {
        ReporteProductividadDTO.TareaResumenDTO resumen = new ReporteProductividadDTO.TareaResumenDTO();
        resumen.setId(tarea.getId().toHexString());
        resumen.setTitulo(tarea.getTitulo());
        resumen.setProyecto(tarea.getNombreProyecto());
        resumen.setEstado(tarea.getEstado());
        resumen.setPrioridad(tarea.getPrioridad());
        resumen.setFechaAsignacion(tarea.getFechaAsignacion());
        resumen.setFechaCompletado(tarea.getFechaCompletado());
        return resumen;
    }
}
