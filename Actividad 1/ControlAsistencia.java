package paqueteClases;

import java.util.Scanner;

public class ControlAsistencia {
    static final int DIAS_SEMANA = 5;
    static final int NUM_ESTUDIANTES = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[NUM_ESTUDIANTES];
        char[][] asistencia = new char[NUM_ESTUDIANTES][DIAS_SEMANA];
        boolean datosRegistrados = false;

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver asistencia individual");
            System.out.println("2. Ver resumen general");
            System.out.println("3. Registrar (o volver a registrar) asistencia");
            System.out.println("4. Salir");
            int opcion = leerEntero(sc, "Elija una opción (1-4): ");

            switch (opcion) {
                case 1:
                    if (!datosRegistrados) {
                        System.out.println("No hay datos registrados. Use la opción 3 para registrar asistencia.");
                    } else {
                        mostrarAsistenciaIndividual(sc, nombres, asistencia);
                    }
                    break;
                case 2:
                    if (!datosRegistrados) {
                        System.out.println("No hay datos registrados. Use la opción 3 para registrar asistencia.");
                    } else {
                        mostrarResumenGeneral(nombres, asistencia);
                    }
                    break;
                case 3:
                    registrarAsistencia(sc, nombres, asistencia);
                    datosRegistrados = true;
                    break;
                case 4:
                    System.out.println("Saliendo. ¡Hasta luego!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
    private static int leerEntero(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine();
            try {
                valor = Integer.parseInt(linea.trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }
    private static char leerPA(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            if (entrada.length() == 0) {
                System.out.println("Entrada vacía. Ingrese 'P' (presente) o 'A' (ausente).");
                continue;
            }
            char c = Character.toUpperCase(entrada.charAt(0));
            if (c == 'P' || c == 'A') return c;
            System.out.println("Valor inválido. Ingrese 'P' (presente) o 'A' (ausente).");
        }
    }
    private static void registrarAsistencia(Scanner sc, String[] nombres, char[][] asistencia) {
        System.out.println("\n--- Registro de asistencia ---");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            String nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                nombre = "Estudiante " + (i + 1);
            }
            nombres[i] = nombre;
        }
        System.out.println("\nIngrese asistencia por estudiante y por día (P = presente, A = ausente).");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println("\n-- " + nombres[i] + " --");
            for (int d = 0; d < DIAS_SEMANA; d++) {
                String mensaje = String.format("Día %d (P/A): ", d + 1);
                asistencia[i][d] = leerPA(sc, mensaje);
            }
        }
        System.out.println("\nRegistro completado correctamente.");
    }
    private static void mostrarAsistenciaIndividual(Scanner sc, String[] nombres, char[][] asistencia) {
        System.out.println("\n--- Ver asistencia individual ---");
        System.out.println("Lista de estudiantes:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.printf("%d. %s%n", i + 1, nombres[i]);
        }
        int sel = leerEntero(sc, "Seleccione el número del estudiante (1-" + NUM_ESTUDIANTES + "): ");
        if (sel < 1 || sel > NUM_ESTUDIANTES) {
            System.out.println("Selección fuera de rango.");
            return;
        }
        int idx = sel - 1;
        int totalPresentes = 0;
        System.out.println("\nAsistencia de " + nombres[idx] + ":");
        for (int d = 0; d < DIAS_SEMANA; d++) {
            System.out.printf("Día %d: %c%n", d + 1, asistencia[idx][d]);
            if (asistencia[idx][d] == 'P') totalPresentes++;
        }
        System.out.println("Total de días presentes: " + totalPresentes + " / " + DIAS_SEMANA);
    }
    private static void mostrarResumenGeneral(String[] nombres, char[][] asistencia) {
        System.out.println("\n--- Resumen general ---");

        int[] totalPorEstudiante = new int[NUM_ESTUDIANTES];
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            int cont = 0;
            for (int d = 0; d < DIAS_SEMANA; d++) {
                if (asistencia[i][d] == 'P') cont++;
            }
            totalPorEstudiante[i] = cont;
        }
        System.out.println("\nTotal de asistencias por estudiante:");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.printf("%s: %d/%d%n", nombres[i], totalPorEstudiante[i], DIAS_SEMANA);
        }
        System.out.println("\nEstudiantes que asistieron todos los días:");
        boolean algunoCompleto = false;
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            if (totalPorEstudiante[i] == DIAS_SEMANA) {
                System.out.println("- " + nombres[i]);
                algunoCompleto = true;
            }
        }
        if (!algunoCompleto) {
            System.out.println("Ninguno.");
        }
        int[] ausenciasPorDia = new int[DIAS_SEMANA];
        for (int d = 0; d < DIAS_SEMANA; d++) {
            int aus = 0;
            for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                if (asistencia[i][d] == 'A') aus++;
            }
            ausenciasPorDia[d] = aus;
        }
        int maxAus = -1;
        for (int d = 0; d < DIAS_SEMANA; d++) {
            if (ausenciasPorDia[d] > maxAus) maxAus = ausenciasPorDia[d];
        }
        System.out.println("\nDías con mayor número de ausencias (" + maxAus + " ausencias):");
        for (int d = 0; d < DIAS_SEMANA; d++) {
            if (ausenciasPorDia[d] == maxAus) {
                System.out.println("- Día " + (d + 1) + " (Ausencias: " + ausenciasPorDia[d] + ")");
            }
        }
        System.out.println("\nResumen por día (Presencias / Ausencias):");
        for (int d = 0; d < DIAS_SEMANA; d++) {
            int pres = NUM_ESTUDIANTES - ausenciasPorDia[d];
            System.out.printf("Día %d: Presencias = %d, Ausencias = %d%n", d + 1, pres, ausenciasPorDia[d]);
        }
    }
}
