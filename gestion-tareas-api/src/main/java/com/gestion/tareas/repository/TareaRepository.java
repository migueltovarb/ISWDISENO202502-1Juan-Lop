package com.gestion.tareas.repository;

import com.gestion.tareas.model.Tarea;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends MongoRepository<Tarea, ObjectId> {
    
    List<Tarea> findByProyectoId(ObjectId proyectoId);
    
    List<Tarea> findByEmpleadoAsignado(ObjectId empleadoId);
    
    List<Tarea> findByEstado(String estado);
    
    @Query("{ 'empleadoAsignado': ?0, 'estado': 'COMPLETADA' }")
    List<Tarea> findTareasCompletadasByEmpleado(ObjectId empleadoId);
    
    @Query("{ 'empleadoAsignado': ?0, 'estado': { $in: ['PENDIENTE', 'EN_PROGRESO'] } }")
    List<Tarea> findTareasPendientesByEmpleado(ObjectId empleadoId);
    
    long countByEmpleadoAsignadoAndEstado(ObjectId empleadoId, String estado);
    
    long countByEmpleadoAsignado(ObjectId empleadoId);
}
