/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package files;

/**
 *
 * @author pablonoguera
 */
public class Votante {
    
   private String cedula;
   private String codPostal;
   private String fechaVencimiento;
   private String codElectoral;
   private String nombreCompleto;
   private String primerApellido;
   private String segundoApellido;

    public Votante(String cedula, String codPostal, String fechaVencimiento, 
            String codElectoral, String nombreCompleto, String primerApellido,
            String segundoApellido) {
        this.cedula = cedula;
        this.codPostal = codPostal;
        this.fechaVencimiento = fechaVencimiento;
        this.codElectoral = codElectoral;
        this.nombreCompleto = nombreCompleto;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the codPostal
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * @param codPostal the codPostal to set
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    /**
     * @return the fechaVencimiento
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the codElectoral
     */
    public String getCodElectoral() {
        return codElectoral;
    }

    /**
     * @param codElectoral the codElectoral to set
     */
    public void setCodElectoral(String codElectoral) {
        this.codElectoral = codElectoral;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
     /**
     * @return the nombreCompleto
     */
    public String getNombreCompletoApellidos() {
        return cedula + " "+ nombreCompleto.trim() + " "+ primerApellido.trim() + " "+segundoApellido.trim() ;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public String toString() {
        return "Votante{" + "cedula=" + cedula + ", codPostal=" + codPostal + ", fechaVencimiento=" + fechaVencimiento + ", codElectoral=" + codElectoral + ", nombreCompleto=" + nombreCompleto + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + '}';
    }
   
   
   
    
}
