package com.gestion.tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionTareasApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(GestionTareasApplication.class, args);
        System.out.println("\n==============================================");
        System.out.println("  API de Gestión de Tareas INICIADA");
        System.out.println("==============================================");
        System.out.println("  Servidor: http://localhost:8080");
        System.out.println("  Swagger UI: http://localhost:8080/swagger-ui.html");
        System.out.println("  API Docs: http://localhost:8080/api-docs");
        System.out.println("==============================================\n");
    }
}
