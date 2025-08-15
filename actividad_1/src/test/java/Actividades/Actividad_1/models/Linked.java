package Actividades.Actividad_1.models;

import java.util.Scanner;
import Actividades.Actividad_1.process.Link;

public class Linked {

    public static void threaded() {
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt(); scanner.nextLine();

        while (option != 0) {
            switch (option) {
                case 1:
                    Link.add();
                    break;
                case 2:
                    Link.del();
                    break;
                case 3:
                    Link.search();
                    break;
                case 4:
                    Link.show();
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            showMenu();
            option = scanner.nextInt(); scanner.nextLine();
        }
    }

    private static void showMenu() {
        System.out.println("""
            \n   ******************************************************   
               ********** Bienvenido a lista de Enlace Simple *******
               ***************** ¿Qué deseas hacer? *****************
               *******************  1.- Agregar  ********************
               *******************  2.- Eliminar  *******************
               *******************  3.- Buscar  *********************
               *******************  4.- Mostrar  ********************    
               ********************  0.- Back  **********************
               ******************************************************""");
    }
}
