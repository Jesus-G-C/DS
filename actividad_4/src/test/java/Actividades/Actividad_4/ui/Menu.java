package Actividades.Actividad_4.ui;

import Actividades.Actividad_4.models.Nodo;
import Actividades.Actividad_4.process.ArbolBinario;

import java.util.Scanner;

public class Menu {

    private ArbolBinario arbol;
    private Scanner scanner;

    public Menu() {
        arbol = new ArbolBinario();
        scanner = new Scanner(System.in);
        cargarEmpleadosIniciales();
    }

    private void cargarEmpleadosIniciales() {
        arbol.insertar(10, "Ana", "Desarrolladora Backend", "Departamento de Desarrollo");
        arbol.insertar(5, "Luis", "QA Tester", "Departamento de Calidad");
        arbol.insertar(20, "Maria", "Ingeniera de Datos", "Departamento de Datos");
        arbol.insertar(15, "Carlos", "Administrador de Sistemas", "Departamento de Infraestructura");
        arbol.insertar(30, "Sofia", "Especialista en Ciberseguridad", "Departamento de Seguridad");
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ EMPRESA TECNOLÓGICA ===");
            System.out.println("1. Mostrar empleados (INORDEN)");
            System.out.println("2. Mostrar empleados (PREORDEN)");
            System.out.println("3. Mostrar empleados (POSTORDEN)");
            System.out.println("4. Añadir empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Buscar empleado por ID");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> arbol.inOrden();
                case 2 -> arbol.preOrden();
                case 3 -> arbol.postOrden();
                case 4 -> agregarEmpleado();
                case 5 -> eliminarEmpleado();
                case 6 -> buscarEmpleado();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void agregarEmpleado() {
        System.out.print("Ingrese ID: ");
        int id = leerEntero();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese rol: ");
        String rol = scanner.nextLine();
        System.out.print("Ingrese departamento: ");
        String departamento = scanner.nextLine();

        arbol.insertar(id, nombre, rol, departamento);
        System.out.println("Empleado agregado correctamente.");
    }

    private void eliminarEmpleado() {
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int id = leerEntero();
        Nodo buscado = arbol.buscar(id);
        if (buscado != null) {
            arbol.eliminar(id);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private void buscarEmpleado() {
        System.out.print("Ingrese el ID del empleado a buscar: ");
        int id = leerEntero();
        Nodo buscado = arbol.buscar(id);
        if (buscado != null) {
            System.out.println("Empleado encontrado: " + buscado.empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private int leerEntero() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Error, ingrese un número válido: ");
            }
        }
    }
}

