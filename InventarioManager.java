/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebas;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventarioManager {

    // Mapa para almacenar los productos y sus cantidades
    private Map<String, Integer> productos;

    // Constructor
    public InventarioManager() {
        productos = new HashMap<>();
    }

    // Método para agregar o actualizar un producto
    public void agregarProducto(String nombre, int cantidad) {
        productos.put(nombre, cantidad);
        System.out.println("Producto agregado/actualizado.");
    }

    // Método para actualizar la cantidad de un producto
    public void actualizarCantidad(String nombre, int cantidad) {
        if (productos.containsKey(nombre)) {
            productos.put(nombre, cantidad);
            System.out.println("Cantidad actualizada.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    // Método para eliminar un producto
    public void eliminarProducto(String nombre) {
        if (productos.remove(nombre) != null) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("El producto no existe.");
        }
    }

    // Método para mostrar todos los productos
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("Productos en inventario:");
            for (Map.Entry<String, Integer> entry : productos.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", Cantidad: " + entry.getValue());
            }
        }
    }

    // Método para mostrar el menú y manejar las entradas del usuario
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Agregar un nuevo producto");
            System.out.println("2. Actualizar la cantidad de un producto");
            System.out.println("3. Eliminar un producto");
            System.out.println("4. Mostrar todos los productos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreAgregar = scanner.nextLine();
                    System.out.print("Ingrese la cantidad inicial: ");
                    int cantidadAgregar = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer del scanner
                    agregarProducto(nombreAgregar, cantidadAgregar);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad: ");
                    int cantidadActualizar = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer del scanner
                    actualizarCantidad(nombreActualizar, cantidadActualizar);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    eliminarProducto(nombreEliminar);
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }

    // Método principal para iniciar el programa
    public static void main(String[] args) {
        InventarioManager inventarioManager = new InventarioManager();
        inventarioManager.mostrarMenu();
    }
}

