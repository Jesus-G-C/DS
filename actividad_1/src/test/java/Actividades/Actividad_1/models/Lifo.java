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
            \n   
            ╓────────────────────────────────────────────────╖
            ║ [📁]¡Bienvenido a Lifo!                        ║
            ╟────────────────────────────────────────────────╢
            ║ [❔] ¿Qué desearía hacer?                      ║                    
            ╟─╖──────────────────────────────────────────────╢
            ║ ║ [➕]-[Push]-[1]                              ║
            ║ ║ [🗑️]-[Pops]-[2]                              ║
            ║ ║ [📌]-[Peek]-[3]                              ║
            ║ ║ [🔎]-[Show]-[4]                              ║
            ║ ║ [🏃]-[Back]-[0]                              ║  
            ╙─╜──────────────────────────────────────────────╜
            """);
    }
}
