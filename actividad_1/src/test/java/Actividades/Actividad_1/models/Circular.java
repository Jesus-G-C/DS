package Actividades.Actividad_1.models;

import java.util.Scanner;

import Actividades.Actividad_1.process.LinkedList;

public class Circular {

    public static void round(){
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt();scanner.nextLine();

        while (option != 0){
            switch (option){
                case 1:
                    LinkedList.add();
                    break;

                case 2:
                    LinkedList.del();
                    break;
                case 3:
                    LinkedList.search();
                    break;

                case 4:
                    LinkedList.show();
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
            showMenu();
            option = scanner.nextInt();scanner.nextLine();
        }
    }

    private static void showMenu(){
        System.out.println("""
            \n   ******************************************************   
               ************** Bienvenido a lista Circular ***********
               ***************** ¿Que deseas hacer? *****************
               *******************  1.- Agregar  ********************
               *******************  2.- Eliminar  *******************
               *******************  3.- Buscar  *********************
               *******************  4.- Mostrar  ********************    
               ********************  0.- Back  **********************
               ******************************************************""");
    }

}
