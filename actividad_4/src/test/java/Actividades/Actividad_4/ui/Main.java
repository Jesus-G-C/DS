package Actividades.Actividad_4.ui;

import Actividades.Actividad_4.models.Nodo;
import Actividades.Actividad_4.process.ArbolBinario;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("=== Insertando empleados ===");
        arbol.insertar(10, "Ana");
        arbol.insertar(5, "Luis");
        arbol.insertar(20, "Maria");
        arbol.insertar(15, "Carlos");
        arbol.insertar(30, "Sofia");

        System.out.println("\nRecorrido INORDEN (ordenado):");
        arbol.inOrden();

        System.out.println("Recorrido PREORDEN:");
        arbol.preOrden();

        System.out.println("Recorrido POSTORDEN:");
        arbol.postOrden();

        System.out.println("\n=== Búsqueda de empleados ===");
        Nodo buscado = arbol.buscar(15);
        if (buscado != null) {
            System.out.println("Empleado encontrado: " + buscado.id + " (" + buscado.nombre + ")");
        } else {
            System.out.println("Empleado no encontrado");
        }

        System.out.println("\n=== Eliminando empleado con ID 20 ===");
        arbol.eliminar(20);

        System.out.println("Recorrido INORDEN después de eliminar:");
        arbol.inOrden();
    }
}
