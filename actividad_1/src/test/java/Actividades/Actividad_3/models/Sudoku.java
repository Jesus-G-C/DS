package Actividades.Actividad_3.models;

import Actividades.Actividad_3.process.Backtracking;
import java.util.Scanner;

public class Sudoku {
    public static void sudokuMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            showMenu();
            option = scanner.nextInt(); scanner.nextLine();
            switch (option) {
                case 1:
                    Backtracking.solveMiniSudoku();
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

    public static void showMenu() {
        System.out.println("""
╓──────────────────────────────────────────────╖
║ [📂] Menú de Sudoku                          ║
╟──────────────────────────────────────────────╢
║ [1] Resolver mini Sudoku (3x3)               ║
║ [0] Salir                                    ║
╙──────────────────────────────────────────────╜
""");
    }
}

