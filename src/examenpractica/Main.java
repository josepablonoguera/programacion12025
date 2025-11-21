/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenpractica;


import java.util.Scanner;

/**
 * Clase principal con un menú sencillo por consola.
 * El estudiantado puede usarla para probar sus implementaciones.
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestorCitas gestor = new GestorCitas();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    agregarCitaPorConsola(gestor);
                    break;
                case 2:
                    gestor.listarCitas();
                    break;
                case 3:
                    System.out.print("Ruta del archivo para guardar (ej. citas.txt): ");
                    String rutaGuardar = sc.nextLine();
                    gestor.guardarEnArchivo(rutaGuardar);
                    break;
                case 4:
                    System.out.print("Ruta del archivo para cargar (ej. citas.txt): ");
                    String rutaCargar = sc.nextLine();
                    gestor.cargarDesdeArchivo(rutaCargar);
                    break;
                case 5:
                    System.out.print("Cédula del paciente: ");
                    String ced = sc.nextLine();
                    int cant = gestor.contarCitasPaciente(ced);
                    System.out.println("Cantidad de citas del paciente: " + cant);
                    break;
                case 6:
                    gestor.listarCitasRecursivo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("=====================================");
        System.out.println("   Sistema de Citas Médicas (Examen)");
        System.out.println("=====================================");
        System.out.println("1. Agregar cita");
        System.out.println("2. Listar citas (iterativo)");
        System.out.println("3. Guardar en archivo");
        System.out.println("4. Cargar desde archivo");
        System.out.println("5. Contar citas por cédula (recursivo)");
        System.out.println("6. Listar citas (recursivo)");
        System.out.println("0. Salir");
        System.out.println("=====================================");
    }

    private static void agregarCitaPorConsola(GestorCitas gestor) {
        System.out.print("Cédula del paciente: ");
        String cedula = sc.nextLine();

        System.out.print("Nombre del paciente: ");
        String nombre = sc.nextLine();

        int dia = leerEntero("Día: ");
        int mes = leerEntero("Mes: ");
        int anio = leerEntero("Año: ");

        System.out.print("Motivo de la cita: ");
        String motivo = sc.nextLine();

        // TODO: construir la Fecha y la Cita, y enviarla al GestorCitas
       ;
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int valor = Integer.parseInt(sc.nextLine());
        return valor;
    }
}

