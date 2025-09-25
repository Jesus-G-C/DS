package Actividades.Actividad_3.ui;

import Actividades.Actividad_3.models.Fibonacci;
import Actividades.Actividad_3.models.Sudoku;
import java.util.Scanner;

public class Main {
    public static void runApp() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = scanner.nextInt(); scanner.nextLine();

            switch (option) {
                case 1:
                    Fibonacci.fibonacci();
                    break;

                case 2:
                    Sudoku.sudokuMenu();
                    break;

                case 0:
                    System.out.print("❓ ¿Seguro que deseas salir? (s/n): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    if (confirm.equals("s")) {
                        System.out.println("""
╓──────────────────────────────╖
║ 👋 Cerrando aplicación...    ║
║    ¡Hasta pronto!            ║
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

    public static void showMenu() {
        System.out.println("""
╓────────────────────────────────────────────────────╖
║ [📂] Menú Principal                                ║
╟────────────────────────────────────────────────────╢
║ [1] Serie de Fibonacci recursiva                   ║
║ [2] Algoritmo de backtracking (Sudoku 3x3)         ║
║ [0] Salir                                          ║
╙────────────────────────────────────────────────────╜
""");
    }
}

