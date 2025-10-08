package paqueteTaller;

import java.util.ArrayList;
import java.util.List;

public class ProgramaTaller {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE VEHÍCULOS Y SERVICIOS DE TALLER      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        // Lista para almacenar todos los vehículos (para validar placas únicas)
        List<Vehiculo> vehiculosRegistrados = new ArrayList<>();

        // ====================================================================
        // 1. REGISTRO DE PROPIETARIOS
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 1: REGISTRO DE PROPIETARIOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        Propietario propietario1 = new Propietario("Juan Carlos Pérez", 311234567);
        propietario1.registrarPropietario();
        System.out.println(propietario1);
        System.out.println();

        Propietario propietario2 = new Propietario("María Elena García", 320987654);
        propietario2.registrarPropietario();
        System.out.println(propietario2);
        System.out.println();

        Propietario propietario3 = new Propietario("Carlos Andrés Rodríguez", 315555666);
        propietario3.registrarPropietario();
        System.out.println(propietario3);
        System.out.println("\n");

        // ====================================================================
        // 2. REGISTRO DE VEHÍCULOS
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 2: REGISTRO DE VEHÍCULOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        // Vehículo 1
        List<Servicio> serviciosVehiculo1 = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo(1001, "Toyota Corolla", 2020, propietario1, serviciosVehiculo1);
        vehiculo1.registrarVehiculo();
        vehiculo1.registrarVehiculoAPropietario();
        vehiculosRegistrados.add(vehiculo1);
        System.out.println();

        // Vehículo 2
        List<Servicio> serviciosVehiculo2 = new ArrayList<>();
        Vehiculo vehiculo2 = new Vehiculo(2002, "Honda Civic", 2021, propietario2, serviciosVehiculo2);
        vehiculo2.registrarVehiculo();
        vehiculo2.registrarVehiculoAPropietario();
        vehiculosRegistrados.add(vehiculo2);
        System.out.println();

        // Vehículo 3
        List<Servicio> serviciosVehiculo3 = new ArrayList<>();
        Vehiculo vehiculo3 = new Vehiculo(3003, "Mazda 3", 2022, propietario3, serviciosVehiculo3);
        vehiculo3.registrarVehiculo();
        vehiculo3.registrarVehiculoAPropietario();
        vehiculosRegistrados.add(vehiculo3);
        System.out.println("\n");

        // ====================================================================
        // 3. VALIDACIÓN DE PLACAS ÚNICAS
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 3: VALIDACIÓN DE PLACAS ÚNICAS");
        System.out.println("───────────────────────────────────────────────────────────────");

        vehiculo1.validarPlacaUnica(4004, vehiculosRegistrados); // Placa nueva
        vehiculo1.validarPlacaUnica(1001, vehiculosRegistrados); // Placa duplicada
        System.out.println("\n");

        // ====================================================================
        // 4. AGREGAR SERVICIOS A LOS VEHÍCULOS
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 4: AGREGAR SERVICIOS A LOS VEHÍCULOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        // Servicios para vehículo 1
        Servicio servicio1 = new Servicio(TipoServicio.CAMBIO_ACEITE, 80000, "2025-01-15", vehiculo1);
        vehiculo1.agregarServicio(servicio1);

        Servicio servicio2 = new Servicio(TipoServicio.REVISION_GENERAL, 250000, "2025-02-20", vehiculo1);
        vehiculo1.agregarServicio(servicio2);

        Servicio servicio3 = new Servicio(TipoServicio.SISTEMA_FRENOS, 350000, "2025-03-10", vehiculo1);
        vehiculo1.agregarServicio(servicio3);
        System.out.println();

        // Servicios para vehículo 2
        Servicio servicio4 = new Servicio(TipoServicio.CAMBIO_ACEITE, 85000, "2025-01-20", vehiculo2);
        vehiculo2.agregarServicio(servicio4);

        Servicio servicio5 = new Servicio(TipoServicio.SISTEMA_FRENOS, 380000, "2025-02-15", vehiculo2);
        vehiculo2.agregarServicio(servicio5);
        System.out.println();

        // Servicios para vehículo 3
        Servicio servicio6 = new Servicio(TipoServicio.REVISION_GENERAL, 300000, "2025-01-25", vehiculo3);
        vehiculo3.agregarServicio(servicio6);
        System.out.println("\n");

        // ====================================================================
        // 5. VALIDACIONES DE SERVICIOS
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 5: VALIDACIONES DE SERVICIOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        System.out.println("¿El servicio 1 tiene costo mayor a cero? " + servicio1.costoMayorACero());
        System.out.println("¿El servicio 1 tiene vehículo asignado? " + servicio1.vehiculoExixte());
        System.out.println("\n");

        // ====================================================================
        // 6. HISTORIAL DE SERVICIOS POR VEHÍCULO
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 6: HISTORIAL DE SERVICIOS");
        System.out.println("───────────────────────────────────────────────────────────────");

        vehiculo1.historialServicios();
        System.out.println();

        vehiculo2.historialServicios();
        System.out.println();

        vehiculo3.historialServicios();
        System.out.println("\n");

        // ====================================================================
        // 7. CÁLCULO DE COSTOS TOTALES
        // ====================================================================
        System.out.println("───────────────────────────────────────────────────────────────");
        System.out.println("  PASO 7: CÁLCULO DE COSTOS TOTALES POR VEHÍCULO");
        System.out.println("───────────────────────────────────────────────────────────────");

        System.out.printf("Vehículo placa %d - Total gastado: $%.2f COP%n", 
                         vehiculo1.getPlaca(), vehiculo1.calcularCostoTotalServicios());
        System.out.printf("Vehículo placa %d - Total gastado: $%.2f COP%n", 
                         vehiculo2.getPlaca(), vehiculo2.calcularCostoTotalServicios());
        System.out.printf("Vehículo placa %d - Total gastado: $%.2f COP%n", 
                         vehiculo3.getPlaca(), vehiculo3.calcularCostoTotalServicios());
        System.out.println("\n");

        // ====================================================================
        // 8. RESUMEN COMPLETO DEL SISTEMA (usando toString())
        // ====================================================================
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("  RESUMEN COMPLETO DEL SISTEMA");
        System.out.println("═══════════════════════════════════════════════════════════════");

        System.out.println("\n▶ VEHÍCULO 1:");
        System.out.println(vehiculo1);
        System.out.println();

        System.out.println("▶ VEHÍCULO 2:");
        System.out.println(vehiculo2);
        System.out.println();

        System.out.println("▶ VEHÍCULO 3:");
        System.out.println(vehiculo3);
        System.out.println();

        // ====================================================================
        // 9. ESTADÍSTICAS GENERALES
        // ====================================================================
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("  ESTADÍSTICAS GENERALES");
        System.out.println("═══════════════════════════════════════════════════════════════");

        double totalGeneralGastado = vehiculo1.calcularCostoTotalServicios() + 
                                    vehiculo2.calcularCostoTotalServicios() + 
                                    vehiculo3.calcularCostoTotalServicios();

        int totalServicios = vehiculo1.getServicios().size() + 
                           vehiculo2.getServicios().size() + 
                           vehiculo3.getServicios().size();

        System.out.println("Total de propietarios registrados: " + 3);
        System.out.println("Total de vehículos registrados: " + vehiculosRegistrados.size());
        System.out.println("Total de servicios realizados: " + totalServicios);
        System.out.printf("Total general gastado en servicios: $%.2f COP%n", totalGeneralGastado);
        System.out.printf("Promedio de gasto por vehículo: $%.2f COP%n", totalGeneralGastado / vehiculosRegistrados.size());

        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              FIN DEL SISTEMA DE PRUEBAS                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}
