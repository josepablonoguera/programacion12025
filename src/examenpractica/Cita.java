/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpractica;



/**
 * Clase Cita para el sistema de citas médicas.
 * El estudiantado DEBE completar el constructor y el método toString.
 */
public class Cita {

    private String cedulaPaciente;
    private String nombrePaciente;
    private Fecha fecha;
    private String motivo;

    /**
     * TODO: Completar el constructor de la clase.
     */
    public Cita(String cedulaPaciente, String nombrePaciente, Fecha fecha, String motivo) {
        // TODO: completar inicialización de atributos
       
    }

    // TODO: agregar getters y setters según sea necesario

    /**
     * TODO: devolver una representación en formato:
     * cedula;nombre;dd/mm/aaaa;motivo
     */
    @Override
    public String toString() {
        // TODO: implementar formato solicitado
        return cedulaPaciente + ";" + nombrePaciente + ";" + fecha + ";" + motivo;
    }
}
