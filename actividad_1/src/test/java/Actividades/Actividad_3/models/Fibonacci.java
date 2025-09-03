package Actividades.Actividad_3.models;

import Actividades.Actividad_3.process.Recursive;
import java.util.Scanner;

public class Fibonacci {
    public static void fibonacci(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            showMenu();
            option = scanner.nextInt(); scanner.nextLine();
            switch (option){
                case 1:
                    Recursive.add();
                    break;

                case 0:
                    System.out.print("❓ ¿Seguro que deseas salir? (s/n): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("s")) {
                        System.out.println("""
╓──────────────────────────────╖
║ 👋 Regresando a menú...      ║
╙──────────────────────────────╜
""");
                        return;
                    } else {
                        option = -1;
                    }
                    break;

                default:
                    System.out.println("""
╓──────────────────────────────╖
║ [⚠] Opción inválida          ║
╙──────────────────────────────╜
""");
                    break;
            }
        } while (option != 0);
    }

    public static void showMenu(){
        System.out.println("""
╓──────────────────────────────────────────────╖
║ [📂] Menú de Fibonacci                       ║
╟──────────────────────────────────────────────╢
║ [1] Calcular serie de Fibonacci              ║
║ [0] Salir                                    ║
╙──────────────────────────────────────────────╜
""");
    }
}



