package Actividades.Actividad_1.models;

import java.util.Scanner;
import Actividades.Actividad_1.process.LinkedList;

public class Lifo {

    public static void stackMenu(){
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt(); scanner.nextLine();

        while (option != 0){
            switch (option){
                case 1:
                    LinkedList.push();
                    break;

                case 2:
                    LinkedList.pop();
                    break;

                case 3:
                    LinkedList.peek();
                    break;

                case 4:
                    LinkedList.showStack();
                    break;

                default:
                    System.out.println("Opción inválida");
            }
            showMenu();
            option = scanner.nextInt(); scanner.nextLine();
        }
    }

    private static void showMenu(){
        System.out.println("""
            \n   ******************************************************   
               *************** Bienvenido a la Pila LIFO ***********
               ***************** ¿Qué deseas hacer? ****************
               *******************  1.- Push  **********************
               *******************  2.- Pop   **********************
               *******************  3.- Peek  **********************
               *******************  4.- Mostrar ********************    
               ********************  0.- Back  *********************
               ******************************************************""");
    }
}
