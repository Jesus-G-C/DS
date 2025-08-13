package Actividades.Actividad_1.models;

import java.util.Scanner;

import Actividades.Actividad_1.process.Ball;
import Actividades.Actividad_1.ui.MAIN;

public class Circular {

    public static void round(){
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt();scanner.nextLine();

        while (option != 0){
            switch (option){
                case 1:
                    Ball.add();
                    break;

                case 2:
                    Ball.del();
                    break;

                case 3:
                    Ball.show();
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
               ************** Bienvenido a lista Circular *************
               ***************** ¿Que deseas hacer? *****************
               *******************  1.- Agregar  ********************
               *******************  2.- Eliminar  *******************
               *******************  3.- Buscar  *********************    
               ********************  0.- Back  **********************
               ******************************************************""");
    }

}
