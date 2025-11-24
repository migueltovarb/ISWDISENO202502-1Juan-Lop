package com.gestion.tareas.repository;

import com.gestion.tareas.model.Proyecto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends MongoRepository<Proyecto, ObjectId> {
    
    List<Proyecto> findByEstado(String estado);
    
    boolean existsByNombre(String nombre);
}
