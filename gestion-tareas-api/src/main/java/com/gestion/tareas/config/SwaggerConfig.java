package com.gestion.tareas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Sistema de Gestión de Tareas y Proyectos")
                        .version("1.0.0")
                        .description("API REST para gestión de proyectos, tareas y reportes de productividad.\n\n" +
                                "**Historias de Usuario implementadas:**\n" +
                                "- HU003: Crear Proyecto\n" +
                                "- HU006: Crear Tarea\n" +
                                "- HU007: Asignar Tarea a Empleado\n" +
                                "- HU011: Actualizar Estado de Tarea\n" +
                                "- Reporte de Productividad (tareas completadas y pendientes)")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@gestiontareas.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
