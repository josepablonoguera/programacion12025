/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package verano;

/**
 * Clase principal para probar la lista enlazada de productos.
 */
public class MainListaProductos {

    public static void main(String[] args) {

        // Crear la lista
        Lista lista = new Lista();

        System.out.println("¿Lista vacía? " + lista.isEmpty());
        System.out.println("Tamaño inicial: " + lista.getSize());
        System.out.println("----------------------------------");

        // Crear productos
        NodoProducto p1 = new NodoProducto(30, "Arroz", 50);
        NodoProducto p2 = new NodoProducto(10, "Frijoles", 40);
        NodoProducto p3 = new NodoProducto(20, "Azúcar", 60);
        NodoProducto p4 = new NodoProducto(40, "Café", 25);

        // Insertar productos (desordenados)
        lista.agregarAlFinal(p1);
        lista.agregarAlFinal(p2);
        lista.agregarAlFinal(p3);
        lista.agregarAlFinal(p4);

        System.out.println("Lista después de insertar al final:");
        lista.mostrarLista();
        System.out.println("----------------------------------");

        // Ordenar la lista
        lista.ordenarLista();
        System.out.println("Lista ordenada por código:");
        lista.mostrarLista();
        System.out.println("----------------------------------");

        // Buscar producto
        int codigoBuscar = 20;
        NodoProducto encontrado = lista.buscarProducto(codigoBuscar);

        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("Producto con código " + codigoBuscar + " no encontrado.");
        }

        System.out.println("----------------------------------");

        // Eliminar un producto
        int codigoEliminar = 10;
        boolean eliminado = lista.eliminarProducto(codigoEliminar);

        if (eliminado) {
            System.out.println("Producto con código " + codigoEliminar + " eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar el producto con código " + codigoEliminar + ".");
        }

        System.out.println("----------------------------------");

        // Mostrar lista final
        System.out.println("Lista final:");
        lista.mostrarLista();

        System.out.println("----------------------------------");
        System.out.println("Tamaño final de la lista: " + lista.getSize());
    }
}
