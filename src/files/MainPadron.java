package files;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * <h2>Ejemplo educativo de manejo de archivos en Java 12 con JFileChooser.</h2>
 *
 * <p>
 * Este programa permite abrir un archivo de texto (por ejemplo
 * {@code PUGOLFITO.txt}) y realizar operaciones básicas:
 * </p>
 * <ul>
 * <li>Seleccionar archivo desde el explorador</li>
 * <li>Contar líneas del archivo</li>
 * <li>Buscar registros por apellido</li>
 * <li>Guardar resultados filtrados en un nuevo archivo</li>
 * <li>Listar apellidos únicos encontrados</li>
 * </ul>
 *
 * <p>
 * Fue diseñado para estudiantes de <b>Programación I</b> como introducción a la
 * manipulación de archivos de texto y uso básico de GUI con
 * {@code JFileChooser}.
 * </p>
 *
 * @author José Pablo Noguera
 * @version 1.0
 * @since Java 12
 */
public class MainPadron {

    /**
     * Archivo actualmente seleccionado por el usuario.
     */
    public static File archivoSeleccionado;

    /**
     * Escáner para lectura de entradas por consola.
     */
    public static final Scanner SC = new Scanner(System.in);

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args argumentos de línea de comando (no utilizados)
     */
    public static void main(String[] args) {
        try {
            menuPrincipal();
        } catch (IOException e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

    /**
     * Despliega el menú principal de opciones en consola y gestiona la
     * interacción del usuario.
     *
     * @throws IOException si ocurre un error de entrada/salida durante la
     * ejecución
     */
    public static void menuPrincipal() throws IOException {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PADRÓN ELECTORAL ===");
            System.out.println("1) Seleccionar archivo con JFileChooser");
            System.out.println("2) Mostrar cantidad de líneas");
            System.out.println("3) Buscar por apellido");
            System.out.println("4) Guardar resultados filtrados en nuevo "
                    + "archivo");
            System.out.println("5) Mostrar apellidos únicos");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    seleccionarArchivo();
                    break;
                case 2:
                    contarLineas();
                    break;
                case 3:
                    buscarPorApellido();
                    break;
                case 4:
                    guardarFiltrado();
                    break;
                case 5:
                    apellidosUnicos();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    /**
     * Permite al usuario seleccionar un archivo de texto mediante un
     * {@link JFileChooser}. El archivo seleccionado se almacena en la variable
     * {@code archivoSeleccionado}.
     */
    public static void seleccionarArchivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccione el archivo ");
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto",
                "txt"));

        int resultado = chooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = chooser.getSelectedFile();
            System.out.println("Archivo seleccionado: "
                    + archivoSeleccionado.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }

    /**
     * Cuenta y muestra en consola la cantidad de líneas del archivo actualmente
     * seleccionado. Utiliza {@link BufferedReader} para leer el archivo línea
     * por línea.
     */
    public static void contarLineas() {
        if (!archivoValido()) {
            return;
        }

        int contador = 0;
        try (
                 BufferedReader br
                = new BufferedReader(new FileReader(archivoSeleccionado))) {

            while (br.readLine() != null) {
                contador++;
            }
            System.out.println("Total de registros: " + contador);
        } catch (IOException e) {
            System.out.println("Error al contar líneas: " + e.getMessage());
        }
    }

    /**
     * Permite al usuario buscar personas por su apellido dentro del archivo
     * seleccionado. Muestra en consola todas las líneas que contengan el texto
     * indicado.
     */
    public static void buscarPorApellido() {
        if (!archivoValido()) {
            return;
        }

        System.out.print("Ingrese el apellido a buscar: ");
        String apellido = SC.nextLine().trim().toUpperCase();
        int encontrados = 0;

        try ( BufferedReader br = new BufferedReader(
                new FileReader(archivoSeleccionado))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toUpperCase().contains(apellido)) {
                   
                    
                    String partes[] = linea.split(",");
                    Votante votante =new  Votante(
                            partes[0], 
                            partes[1],
                            partes[3], 
                            partes[4], 
                            partes[5],
                            partes[6],
                            partes[7]
                    );
                                      
                    System.out.println(votante.getNombreCompletoApellidos());
                    encontrados++;
                }
            }
            System.out.println("Coincidencias encontradas: " + encontrados);
        } catch (IOException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }

    /**
     * Filtra las líneas del archivo que contengan un apellido específico y
     * permite al usuario guardar los resultados en un nuevo archivo. Utiliza
     * {@link JFileChooser} para elegir la ubicación de guardado.
     */
    public static void guardarFiltrado() {
        if (!archivoValido()) {
            return;
        }

        System.out.print("Ingrese el apellido a guardar: ");
        String apellido = SC.nextLine().trim().toUpperCase();

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar resultados filtrados como...");
        chooser.setSelectedFile(new File("filtrado_" + apellido + ".txt"));

        int result = chooser.showSaveDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("Guardado cancelado.");
            return;
        }

        File destino = chooser.getSelectedFile();
        int count = 0;

        try ( BufferedReader br = new BufferedReader(
                new FileReader(archivoSeleccionado));  PrintWriter pw = new PrintWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.toUpperCase().contains(apellido)) {
                    pw.println(linea);
                    count++;
                }
            }
            System.out.println("Archivo '" + destino.getName() + "' creado con "
                    + count + " registros.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Muestra el número total de líneas del archivo y la cantidad de apellidos
     * únicos encontrados. Usa un {@link HashSet} para evitar duplicados.
     */
    public static void apellidosUnicos() {
        if (!archivoValido()) {
            return;
        }

        Set<String> apellidos = new HashSet<>();
        int total = 0;

        try ( BufferedReader br = new BufferedReader(
                new FileReader(archivoSeleccionado))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                total++;
                String[] partes = linea.split(",");
                if (partes.length > 6) {
                    apellidos.add(partes[6].trim().toUpperCase());
                }
            }
            System.out.println("Total de líneas: " + total);
            System.out.println("Apellidos únicos: " + apellidos.size());
        } catch (IOException e) {
            System.out.println("Error al procesar archivo: " + e.getMessage());
        }
    }

    /**
     * Verifica si el archivo ha sido seleccionado y existe en el sistema.
     *
     * @return {@code true} si el archivo es válido, {@code false} en caso
     * contrario
     */
    public static boolean archivoValido() {
        if (archivoSeleccionado == null) {
            System.out.println("Primero debe seleccionar un archivo "
                    + "(opción 1).");
            return false;
        }
        if (!archivoSeleccionado.exists()) {
            System.out.println("El archivo seleccionado no existe.");
            return false;
        }
        return true;
    }

    /**
     * Lee un número entero desde consola, validando que la entrada sea
     * correcta.
     *
     * @return el número entero ingresado por el usuario
     */
    public static int leerEntero() {
        while (true) {
            try {
                String input = SC.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}
