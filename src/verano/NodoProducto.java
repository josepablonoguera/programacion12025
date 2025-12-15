package  verano;
/**
 * Nodo que representa un producto dentro de una lista enlazada simple.
 *
 * <p>Cada nodo almacena la información básica del producto y una referencia
 * al siguiente nodo de la lista.</p>
 */
public class NodoProducto {

    private int codigo;
    private String nombre;
    private int cantidad;

    NodoProducto siguiente;

    /**
     * Constructor del nodo producto.
     *
     * @param codigo   código único del producto
     * @param nombre   nombre del producto
     * @param cantidad cantidad disponible
     */
    public NodoProducto(int codigo, String nombre, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.siguiente = null;
    }

    /** @return código del producto */
    public int getCodigo() {
        return codigo;
    }

    /** @return nombre del producto */
    public String getNombre() {
        return nombre;
    }

    /** @return cantidad del producto */
    public int getCantidad() {
        return cantidad;
    }

    /** @param cantidad nueva cantidad */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "NodoProducto{" + "codigo=" + codigo + 
                               ", nombre=" + nombre + 
                               ", cantidad=" + cantidad + 
                               ", siguiente=" + siguiente + '}';
    }

   
}
