/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ExamenGuiaYTests
 * -----------------
 * Este archivo cumple dos propósitos:
 *
 * 1) DOCUMENTACIÓN DEL EXAMEN (versión resumida):
 *
 *    Caso: Sistema de Citas Médicas
 *    - Clases principales: Fecha, Cita, GestorCitas, Main.
 *    - Temas evaluados:
 *      * Manejo dinámico de memoria (objetos, referencias, vectores).
 *      * Persistencia en archivos de texto (.txt).
 *      * Recursividad.
 *
 *    Estructura sugerida del examen:
 *    - Implementar Fecha (constructor, getters/setters, toString).
 *    - Implementar Cita (constructor, toString con formato cedula;nombre;dd/mm/aaaa;motivo).
 *    - Implementar GestorCitas:
 *         > ArrayList<Cita> citas;
 *         > agregarCita(Cita), listarCitas();
 *         > guardarEnArchivo(String ruta), cargarDesdeArchivo(String ruta).
 *         > contarCitasPaciente(String cedula) recursivo.
 *         > listarCitasRecursivo() recursivo.
 *    - Main: menú simple por consola para probar.
 *
 * 2) PRUEBAS AUTOMÁTICAS Y RÚBRICA:
 *
 *    Esta clase define una rúbrica automática parcial (sobre 60 puntos):
 *
 *    - testFechaConstructorYToString           : 10 pts
 *    - testCitaConstructorYToString            : 10 pts
 *    - testAgregarYContarCitas                 : 10 pts
 *    - testGuardarYCargarArchivo               : 15 pts
 *    - testContarCitasPacienteRecursivo        : 10 pts
 *    - testListarCitasRecursivo                : 5 pts  (se verifica que no falle y que imprima algo)
 *
 *    TOTAL AUTOMÁTICO: 60 pts
 *
 *    El resto de la nota (hasta 100) se puede asignar a:
 *    - Comentarios sobre stack/heap.
 *    - Análisis de memoria en bytes.
 *    - Calidad de código, legibilidad, manejo de errores extra, etc.
 *
 *    NOTA FINAL AUTOMÁTICA SOBRE 100:
 *    (puntosAutomaticos / 60.0) * 100
 *
 * Uso:
 *    - En NetBeans, ejecutar esta clase con Run File.
 *    - O cambiar el Main-Class del proyecto a esta clase para correrla por defecto.
 */
public class ExamenGuiaYTests {

    // ===================== RÚBRICA AUTOMÁTICA =====================
    private static final int PTS_FECHA                = 10;
    private static final int PTS_CITA                 = 10;
    private static final int PTS_AGREGAR_Y_CONTAR     = 10;
    private static final int PTS_GUARDAR_CARGAR       = 15;
    private static final int PTS_CONTAR_RECURSIVO     = 10;
    private static final int PTS_LISTAR_RECURSIVO     = 5;

    private static final int TOTAL_AUTOMATICO = PTS_FECHA + PTS_CITA
            + PTS_AGREGAR_Y_CONTAR + PTS_GUARDAR_CARGAR
            + PTS_CONTAR_RECURSIVO + PTS_LISTAR_RECURSIVO;

    // ========================= MAIN =========================

    public static void main(String[] args) {
        mostrarInstrucciones();
        System.out.println();
        System.out.println("==================================================");
        System.out.println("   EJECUTANDO PRUEBAS AUTOMÁTICAS DEL EXAMEN");
        System.out.println("==================================================");
        correrPruebas();
    }

    // ================= INSTRUCCIONES =======================

    public static void mostrarInstrucciones() {
        System.out.println("===============================================");
        System.out.println("   EXAMEN PROGRAMACIÓN I – SISTEMA DE CITAS   ");
        System.out.println("===============================================");
        System.out.println("Temas evaluados:");
        System.out.println("- Manejo dinámico de memoria en Java (objetos, referencias, ArrayList).");
        System.out.println("- Persistencia con archivos de texto (.txt).");
        System.out.println("- Recursividad (búsqueda y listado).");
        System.out.println();
        System.out.println("Clases obligatorias:");
        System.out.println("- Fecha  : constructor completo, getters/setters, toString dd/mm/aaaa.");
        System.out.println("- Cita   : constructor y toString en formato cedula;nombre;dd/mm/aaaa;motivo.");
        System.out.println("- GestorCitas:");
        System.out.println("    * ArrayList<Cita> citas;");
        System.out.println("    * agregarCita(Cita c)");
        System.out.println("    * listarCitas() (iterativo)");
        System.out.println("    * guardarEnArchivo(String ruta)");
        System.out.println("    * cargarDesdeArchivo(String ruta)");
        System.out.println("    * contarCitasPaciente(String cedula) (recursivo)");
        System.out.println("    * listarCitasRecursivo() (recursivo)");
        System.out.println();
        System.out.println("Este archivo también corre pruebas automáticas");
        System.out.println("para asignar una nota parcial sobre 60 puntos.");
        System.out.println("La nota automática sobre 100 = (puntos / 60.0) * 100.");
        System.out.println("Use el resto de la nota para criterios manuales.");
    }

    // ================== EJECUCIÓN DE PRUEBAS ==================

    public static void correrPruebas() {
        int puntos = 0;

        puntos += correrPrueba("Fecha: constructor y toString",
                PTS_FECHA, ExamenGuiaYTests::testFechaConstructorYToString);

        puntos += correrPrueba("Cita: constructor y toString",
                PTS_CITA, ExamenGuiaYTests::testCitaConstructorYToString);

        puntos += correrPrueba("GestorCitas: agregar y contar citas",
                PTS_AGREGAR_Y_CONTAR, ExamenGuiaYTests::testAgregarYContarCitas);

        puntos += correrPrueba("GestorCitas: guardar y cargar archivo",
                PTS_GUARDAR_CARGAR, ExamenGuiaYTests::testGuardarYCargarArchivo);

        puntos += correrPrueba("GestorCitas: contarCitasPaciente recursivo",
                PTS_CONTAR_RECURSIVO, ExamenGuiaYTests::testContarCitasPacienteRecursivo);

        puntos += correrPrueba("GestorCitas: listarCitasRecursivo",
                PTS_LISTAR_RECURSIVO, ExamenGuiaYTests::testListarCitasRecursivo);

        System.out.println("--------------------------------------------------");
        System.out.println("Puntaje automático obtenido: " + puntos + " / " + TOTAL_AUTOMATICO);
        double nota100 = (puntos * 100.0) / TOTAL_AUTOMATICO;
        System.out.printf("Nota automática (escala 0-100): %.2f%n", nota100);
        System.out.println("Recuerde sumar los puntos manuales (comentarios, análisis, estilo, etc.).");
    }

    /**
     * Función auxiliar para correr cada prueba.
     */
    private static int correrPrueba(String nombre, int ptsMaximos, Prueba prueba) {
        System.out.println("--------------------------------------------------");
        System.out.println("Prueba: " + nombre + " (máx " + ptsMaximos + " pts)");
        boolean ok;
        try {
            ok = prueba.ejecutar();
        } catch (Throwable t) {
            ok = false;
            System.out.println("  >> ERROR durante la prueba: " + t);
        }
        int pts = ok ? ptsMaximos : 0;
        System.out.println("Resultado: " + (ok ? "OK" : "FALLÓ") + " -> "
                + pts + " / " + ptsMaximos + " pts");
        return pts;
    }

    // Interfaz funcional simple para las pruebas
    private interface Prueba {
        boolean ejecutar();
    }

    // ================== PRUEBAS CONCRETAS ==================

    /**
     * Prueba Fecha: verifica que el constructor asigne valores y toString tenga formato aceptable.
     */
    private static boolean testFechaConstructorYToString() {
        Fecha f = new Fecha(14, 7, 1978);
        String s = f.toString();
        if (s == null) {
            System.out.println("toString() devuelve null.");
            return false;
        }
        s = s.trim();
        // Aceptamos "14/7/1978" o "14/07/1978"
        boolean formato1 = "14/7/1978".equals(s);
        boolean formato2 = "14/07/1978".equals(s);
        if (!formato1 && !formato2) {
            System.out.println("Formato de Fecha incorrecto. Se obtuvo: " + s);
            return false;
        }
        return true;
    }

    /**
     * Prueba Cita: constructor y toString.
     */
    private static boolean testCitaConstructorYToString() {
        Fecha f = new Fecha(14, 7, 1978);
        Cita c = new Cita("603490098", "Jose Noguera", f, "Consulta general");
        String s = c.toString();
        if (s == null) {
            System.out.println("Cita.toString() devuelve null.");
            return false;
        }
        s = s.trim();
        // Aceptamos que use el toString() de Fecha
        boolean contieneCedula = s.contains("603490098");
        boolean contieneNombre = s.contains("Jose Noguera");
        boolean contieneFecha = s.contains("14/7/1978") || s.contains("14/07/1978");
        boolean contieneMotivo = s.contains("Consulta general");
        if (!contieneCedula || !contieneNombre || !contieneFecha || !contieneMotivo) {
            System.out.println("Formato de Cita.toString() no contiene todos los campos esperados.");
            System.out.println("Salida: " + s);
            return false;
        }
        return true;
    }

    /**
     * Prueba que GestorCitas agregue citas y que contarCitasPaciente funcione al menos en forma básica.
     */
    private static boolean testAgregarYContarCitas() {
        GestorCitas gestor = new GestorCitas();
        Fecha f1 = new Fecha(1, 1, 2025);
        Fecha f2 = new Fecha(2, 1, 2025);

        Cita c1 = new Cita("111", "Ana", f1, "Control");
        Cita c2 = new Cita("222", "Luis", f2, "Urgencia");
        Cita c3 = new Cita("111", "Ana", f2, "Revisión");

        gestor.agregarCita(c1);
        gestor.agregarCita(c2);
        gestor.agregarCita(c3);

        int cant111 = gestor.contarCitasPaciente("111");
        int cant222 = gestor.contarCitasPaciente("222");

        if (cant111 != 2 || cant222 != 1) {
            System.out.println("contarCitasPaciente no devuelve los valores esperados.");
            System.out.println("Esperado para 111: 2, obtenido: " + cant111);
            System.out.println("Esperado para 222: 1, obtenido: " + cant222);
            return false;
        }
        return true;
    }

    /**
     * Prueba guardado y carga desde archivo.
     * Usa un archivo temporal: "citas_test_examen.txt"
     */
    private static boolean testGuardarYCargarArchivo() {
        String ruta = "citas_test_examen.txt";

        // 1) Crear gestor y agregar algunas citas
        GestorCitas gestorOriginal = new GestorCitas();
        Fecha f1 = new Fecha(10, 5, 2025);
        Fecha f2 = new Fecha(11, 5, 2025);

        gestorOriginal.agregarCita(new Cita("333", "Pedro", f1, "Chequeo"));
        gestorOriginal.agregarCita(new Cita("444", "Maria", f2, "Exámenes"));

        // 2) Guardar en archivo
        gestorOriginal.guardarEnArchivo(ruta);

        // 3) Cargar en un nuevo gestor
        GestorCitas gestorCargado = new GestorCitas();
        gestorCargado.cargarDesdeArchivo(ruta);

        // 4) Verificar que las cantidades por cédula coincidan
        int cant333 = gestorCargado.contarCitasPaciente("333");
        int cant444 = gestorCargado.contarCitasPaciente("444");

        if (cant333 != 1 || cant444 != 1) {
            System.out.println("Después de cargar desde archivo, las cantidades no coinciden.");
            System.out.println("333 -> esperado 1, obtenido: " + cant333);
            System.out.println("444 -> esperado 1, obtenido: " + cant444);
            return false;
        }

        // (Opcional) comprobar que el archivo realmente tiene 2 líneas
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            int lineas = 0;
            while (br.readLine() != null) {
                lineas++;
            }
            if (lineas < 2) {
                System.out.println("El archivo no parece tener todas las citas guardadas. Líneas: " + lineas);
                return false;
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo el archivo de prueba: " + ex.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Prueba específica de la versión recursiva de contarCitasPaciente.
     * (Se apoya en el comportamiento observable).
     */
    private static boolean testContarCitasPacienteRecursivo() {
        // En realidad usa el mismo método público contarCitasPaciente,
        // pero revisando un caso algo más grande para forzar recursión.
        GestorCitas gestor = new GestorCitas();
        Fecha f = new Fecha(1, 1, 2025);

        for (int i = 0; i < 5; i++) {
            gestor.agregarCita(new Cita("555", "Carlos", f, "Control #" + i));
        }
        gestor.agregarCita(new Cita("666", "Otro", f, "Otra cita"));

        int cant555 = gestor.contarCitasPaciente("555");
        int cant666 = gestor.contarCitasPaciente("666");

        if (cant555 != 5 || cant666 != 1) {
            System.out.println("contarCitasPaciente (recursivo) no parece estar bien implementado.");
            System.out.println("555 -> esperado 5, obtenido: " + cant555);
            System.out.println("666 -> esperado 1, obtenido: " + cant666);
            return false;
        }
        return true;
    }

    /**
     * Prueba listarCitasRecursivo: se verifica principalmente que no lance
     * excepción y que imprima al menos algo.
     */
    private static boolean testListarCitasRecursivo() {
        GestorCitas gestor = new GestorCitas();
        Fecha f = new Fecha(3, 3, 2025);

        gestor.agregarCita(new Cita("999", "Test1", f, "Motivo1"));
        gestor.agregarCita(new Cita("888", "Test2", f, "Motivo2"));

        // Redirigir salida para comprobar que imprime algo
        java.io.PrintStream originalOut = System.out;
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        System.setOut(ps);

        try {
            gestor.listarCitasRecursivo();
        } catch (Throwable t) {
            System.setOut(originalOut);
            System.out.println("Error al ejecutar listarCitasRecursivo: " + t);
            return false;
        } finally {
            System.setOut(originalOut);
        }

        String salida = baos.toString();
        if (salida == null || salida.trim().isEmpty()) {
            System.out.println("listarCitasRecursivo no imprimió nada.");
            return false;
        }
        return true;
    }
}

