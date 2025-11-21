/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase GestorCitas: administra las citas en memoria y en archivo de texto.
 * Varias partes están marcadas como TODO para que el estudiantado las complete.
 */
public class GestorCitas {

    private Cita [] citas;

    public GestorCitas() {
        // TODO: inicializar la estructura dinámica (ArrayList)
       
    }

    public void agregarCita(Cita c) {
        // TODO: agregar la cita a la lista
    }

    public void listarCitas() {
        // TODO: recorrer la lista e imprimir cada cita (versión iterativa)
    }

    /**
     * Guarda todas las citas en un archivo de texto.
     * Formato de cada línea: cedula;nombre;dd/mm/aaaa;motivo
     */
    public void guardarEnArchivo(String ruta) {
        // TODO: implementar try-with-resources o try/finally
        try (PrintWriter out = new PrintWriter(new FileWriter(ruta))) {
            // TODO: recorrer la lista y escribir cada cita
            
        } catch (IOException ex) {
            System.out.println("Error al guardar archivo: " + ex.getMessage());
        }
    }

    /**
     * Carga las citas desde un archivo de texto.
     * Debe limpiar la lista actual y luego agregar las citas leídas.
     */
    public void cargarDesdeArchivo(String ruta) {
        // TODO: limpiar la lista actual antes de cargar
        // citas.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // TODO: separar por ';' y reconstruir Fecha y Cita
              
            }
        } catch (IOException ex) {
            System.out.println("Error al leer archivo: " + ex.getMessage());
        }
    }

    // ================== Métodos recursivos ==================

    public int contarCitasPaciente(String cedula) {
        return contarCitasPacienteRec(cedula, 0);
    }

    private int contarCitasPacienteRec(String cedula, int indice) {
        // TODO: implementar versión recursiva
       
        return 0; // valor por defecto
    }

    public void listarCitasRecursivo() {
        listarCitasRecursivo(0);
    }

    private void listarCitasRecursivo(int indice) {
        // TODO: implementar versión recursiva de listado
  
    }
}

