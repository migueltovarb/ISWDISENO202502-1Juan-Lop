package com.gestion.tareas.repository;

import com.gestion.tareas.model.Empleado;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends MongoRepository<Empleado, ObjectId> {
    
    Optional<Empleado> findByEmail(String email);
    
    boolean existsByEmail(String email);
}
