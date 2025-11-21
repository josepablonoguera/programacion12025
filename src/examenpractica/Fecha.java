/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;


/**
 * Clase Fecha (similar a MyDate) para el examen de Programación 1.
 * El estudiantado DEBE completar el constructor, getters, setters y toString.
 */
public class Fecha {

    private int dia = 1;
    private int mes = 1;
    private int anio = 2000;

    /**
     * TODO: Completar el constructor para asignar los parámetros
     * a los atributos de la clase.
     */
    public Fecha(int dia, int mes, int anio) {
        // TODO: completar asignaciones
       
    }

    // TODO: agregar getters y setters para dia, mes y anio

    /**
     * TODO: devolver la fecha en formato dd/mm/aaaa.
     */
    @Override
    public String toString() {
        // TODO: implementar formato "14/07/1978"
        return dia + "/" + mes + "/" + anio; // implementación mínima; se puede mejorar
    }
}

