/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package verano;

/**
 * Implementación de una lista enlazada simple de productos.
 *
 * <p>Permite insertar, eliminar, buscar, ordenar y mostrar productos
 * utilizando nodos de tipo {@link NodoProducto}.</p>
 */
public class Lista {

     NodoProducto head;
    private int size;

    /**
     * Crea una lista vacía.
     */
    public Lista() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no tiene elementos
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Retorna el tamaño de la lista.
     *
     * @return cantidad de nodos
     */
    public int getSize() {
        return size;
    }

    /**
     * Inserta un producto al inicio de la lista.
     *
     * @param nuevoNodo nodo a insertar
     */
    public void agregarAlInicio(NodoProducto nuevoNodo) {
        nuevoNodo.siguiente = head;
        head = nuevoNodo;
        size++;
    }

    /**
     * Inserta un producto al final de la lista.
     *
     * @param nuevoNodo nodo a insertar
     */
    public void agregarAlFinal(NodoProducto nuevoNodo) {
        if (isEmpty()) {
            head = nuevoNodo;
        } else {
            NodoProducto temp = head;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        size++;
    }

    /**
     * Inserta un producto de forma ordenada según el código.
     *
     * @param nuevoNodo nodo a insertar
     */
    public void insertarOrdenado(NodoProducto nuevoNodo) {
        if (isEmpty() || head.getCodigo() >= nuevoNodo.getCodigo()) {
            agregarAlInicio(nuevoNodo);
            return;
        }

        NodoProducto actual = head;
        while (actual.siguiente != null
                && actual.siguiente.getCodigo() < nuevoNodo.getCodigo()) {
            actual = actual.siguiente;
        }

        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        size++;
    }

    /**
     * Muestra todos los productos de la lista.
     */
    public void mostrarLista() {
        NodoProducto temp = head;
        while (temp != null) {
            System.out.println(temp.getNombre());
            temp = temp.siguiente;
        }
    }

    /**
     * Busca un producto por su código.
     *
     * @param codigo código del producto
     * @return nodo encontrado o null si no existe
     */
    public NodoProducto buscarProducto(int codigo) {
        NodoProducto temp = head;
        while (temp != null) {
            if (temp.getCodigo() == codigo) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    /**
     * Elimina un producto por su código.
     *
     * @param codigo código del producto
     * @return true si se eliminó, false si no se encontró
     */
    public boolean eliminarProducto(int codigo) {
        if (isEmpty()) {
            return false;
        }

        if (head.getCodigo() == codigo) {
            head = head.siguiente;
            size--;
            return true;
        }

        NodoProducto actual = head;
        while (actual.siguiente != null
                && actual.siguiente.getCodigo() != codigo) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            size--;
            return true;
        }

        return false;
    }

    /**
     * Vacía completamente la lista.
     */
    public void vaciarLista() {
        head = null;
        size = 0;
    }

    /**
     * Ordena la lista por código usando inserción ordenada.
     */
    public void ordenarLista() {
        if (isEmpty() || head.siguiente == null) {
            return;
        }

        Lista listaOrdenada = new Lista();
        NodoProducto actual = head;

        while (actual != null) {
            NodoProducto siguiente = actual.siguiente;
            actual.siguiente = null;
            listaOrdenada.insertarOrdenado(actual);
            actual = siguiente;
        }

        head = listaOrdenada.head;
    }
}
