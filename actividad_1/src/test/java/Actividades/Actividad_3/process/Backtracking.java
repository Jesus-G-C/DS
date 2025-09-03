package Actividades.Actividad_3.process;

import java.util.Scanner;

public class Backtracking {

    private static final int SIZE = 3;

    public static void solveMiniSudoku() {
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[SIZE][SIZE];

        System.out.println("""
╓──────────────────────────────────────────────╖
║ [✍] Ingresa entre 1 y 3 números en la        ║
║     cuadrícula 3x3 del Sudoku                ║
╙──────────────────────────────────────────────╜
""");

        System.out.print("👉 ¿Cuántos números deseas ingresar (1-3)?: ");
        int entries = scanner.nextInt();

        for (int k = 0; k < entries; k++) {
            System.out.print("Fila (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Columna (0-2): ");
            int col = scanner.nextInt();
            System.out.print("Valor (1-9): ");
            int val = scanner.nextInt();

            if (isValid(grid, row, col, val)) {
                grid[row][col] = val;
            } else {
                System.out.println("""
╓──────────────────────────────╖
║ [⚠] Movimiento inválido      ║
╙──────────────────────────────╜
""");
                k--; // repetir intento
            }
        }

        System.out.println("\n📌 Cuadrícula inicial:");
        printGrid(grid);

        if (solve(grid)) {
            System.out.println("\n✅ Cuadrícula resuelta:");
            printGrid(grid);
        } else {
            System.out.println("""
╓──────────────────────────────╖
║ [⚠] No existe solución       ║
╙──────────────────────────────╜
""");
        }
    }

    private static boolean solve(int[][] grid) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == 0) {
                    for (int num = 1; num <= SIZE * SIZE; num++) {
                        if (isValid(grid, row, col, num)) {
                            grid[row][col] = num;
                            if (solve(grid)) {
                                return true;
                            }
                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] grid, int row, int col, int num) {
        for (int x = 0; x < SIZE; x++) {
            if (grid[row][x] == num || grid[x][col] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printGrid(int[][] grid) {
        System.out.println("╓───────────────╖");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("║ ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print((grid[i][j] == 0 ? "." : grid[i][j]) + " ");
            }
            System.out.println("║");
        }
        System.out.println("╙───────────────╜");
    }
}

