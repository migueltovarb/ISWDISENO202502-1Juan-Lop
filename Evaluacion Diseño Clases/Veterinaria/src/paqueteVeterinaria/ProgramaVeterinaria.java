package paqueteVeterinaria;

import java.util.ArrayList;
import java.util.List;

public class ProgramaVeterinaria {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN VETERINARIA - CONTROL DE MASCOTAS       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        
        List<Mascota> mascotasRegistradas = new ArrayList<>();


        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 1: REGISTRO DE DUEÑOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        Dueño dueño1 = new Dueño("Laura Martínez Gómez", 1098765432, 311234567);
        dueño1.registrarDueño();
        System.out.println(dueño1);
        System.out.println();

        Dueño dueño2 = new Dueño("Pedro José Ramírez", 1087654321, 320987654);
        dueño2.registrarDueño();
        System.out.println(dueño2);
        System.out.println();

        Dueño dueño3 = new Dueño("Ana Sofía Torres", 1076543210, 315555666);
        dueño3.registrarDueño();
        System.out.println(dueño3);
        System.out.println("\n");



        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 2: REGISTRO DE MASCOTAS");
        System.out.println("───────────────────────────────────────────────────────────────");

   
        List<ControlVeterinario> controlesMascota1 = new ArrayList<>();
        Mascota mascota1 = new Mascota("Max", "Perro", 3, dueño1, controlesMascota1);
        mascota1.registrarMascotaDueño();
        mascotasRegistradas.add(mascota1);
        System.out.println();

    
        List<ControlVeterinario> controlesMascota2 = new ArrayList<>();
        Mascota mascota2 = new Mascota("Luna", "Gato", 2, dueño2, controlesMascota2);
        mascota2.registrarMascotaDueño();
        mascotasRegistradas.add(mascota2);
        System.out.println();

      
        List<ControlVeterinario> controlesMascota3 = new ArrayList<>();
        Mascota mascota3 = new Mascota("Rocky", "Perro", 5, dueño3, controlesMascota3);
        mascota3.registrarMascotaDueño();
        mascotasRegistradas.add(mascota3);
        System.out.println();

        
        List<ControlVeterinario> controlesMascota4 = new ArrayList<>();
        Mascota mascota4 = new Mascota("Michi", "Gato", 1, dueño1, controlesMascota4);
        mascota4.registrarMascotaDueño();
        mascotasRegistradas.add(mascota4);
        System.out.println("\n");

      
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 3: REGISTRO DE CONTROLES VETERINARIOS");
        System.out.println("───────────────────────────────────────────────────────────────");

      
        ControlVeterinario control1 = new ControlVeterinario(
            "2025-01-15", 
            TipoControl.VACUNACION, 
            "Vacuna antirrábica aplicada correctamente", 
            mascota1
        );
        mascota1.registrarControlVeterinario(control1);

        ControlVeterinario control2 = new ControlVeterinario(
            "2025-02-20", 
            TipoControl.CHEQUEO, 
            "Revisión general - Estado de salud excelente", 
            mascota1
        );
        mascota1.registrarControlVeterinario(control2);

        ControlVeterinario control3 = new ControlVeterinario(
            "2025-03-10", 
            TipoControl.DESPARACITACION, 
            "Desparasitación interna y externa completada", 
            mascota1
        );
        mascota1.registrarControlVeterinario(control3);
        System.out.println();

   
        ControlVeterinario control4 = new ControlVeterinario(
            "2025-01-20", 
            TipoControl.VACUNACION, 
            "Vacuna triple felina aplicada", 
            mascota2
        );
        mascota2.registrarControlVeterinario(control4);

        ControlVeterinario control5 = new ControlVeterinario(
            "2025-02-15", 
            TipoControl.CHEQUEO, 
            "Control de peso y alimentación", 
            mascota2
        );
        mascota2.registrarControlVeterinario(control5);
        System.out.println();

      
        ControlVeterinario control6 = new ControlVeterinario(
            "2025-01-25", 
            TipoControl.CHEQUEO, 
            "Revisión completa - Detectada leve inflamación en articulaciones", 
            mascota3
        );
        mascota3.registrarControlVeterinario(control6);

        ControlVeterinario control7 = new ControlVeterinario(
            "2025-03-05", 
            TipoControl.DESPARACITACION, 
            "Tratamiento antiparasitario preventivo", 
            mascota3
        );
        mascota3.registrarControlVeterinario(control7);
        System.out.println();

       
        System.out.println("\n");


        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 4: VALIDACIONES DE CONTROLES");
        System.out.println("───────────────────────────────────────────────────────────────");

        System.out.println("¿El control 1 tiene mascota asignada? " + control1.mascotaExiste());
        System.out.println("¿La mascota 1 (Max) tiene controles? " + mascota1.tieneControles());
        System.out.println("¿La mascota 4 (Michi) tiene controles? " + mascota4.tieneControles());
        System.out.println("\n");

        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 5: HISTORIAL DE CONTROLES VETERINARIOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        mascota1.historialControles();
        System.out.println();

        mascota2.historialControles();
        System.out.println();

        mascota3.historialControles();
        System.out.println();

        mascota4.historialControles();
        System.out.println("\n");

  
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("  RESUMEN COMPLETO DEL SISTEMA");
        System.out.println("═══════════════════════════════════════════════════════════════");

        System.out.println("\n▶ MASCOTA 1:");
        System.out.println(mascota1);
        System.out.println();

        System.out.println("▶ MASCOTA 2:");
        System.out.println(mascota2);
        System.out.println();

        System.out.println("▶ MASCOTA 3:");
        System.out.println(mascota3);
        System.out.println();

        System.out.println("▶ MASCOTA 4:");
        System.out.println(mascota4);
        System.out.println();


        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              FIN DEL SISTEMA DE PRUEBAS                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}