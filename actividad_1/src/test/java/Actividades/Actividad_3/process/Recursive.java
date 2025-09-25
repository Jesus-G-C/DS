package Actividades.Actividad_3.process;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Recursive {

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            try {
                System.out.print("👉 Ingresa un número entre 1 y 25: ");
                n = scanner.nextInt();

                if (n < 1 || n > 25) {
                    System.out.println("""
╓──────────────────────────────╖
║ [⚠] El número debe estar     ║
║     entre 1 y 25             ║
╙──────────────────────────────╜
""");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("""
╓──────────────────────────────╖
║ [⚠] Entrada inválida.        ║
║     Solo enteros permitidos  ║
╙──────────────────────────────╜
""");
                scanner.next();
            }
        }

        // Serie
        System.out.println("\n╓──────────────────────────────╖");
        System.out.println("║ 📌 Serie de Fibonacci hasta " + n + "       ║");
        System.out.print("╟──────────────────────────────╢\n║ ");
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + (i < n ? ", " : ""));
        }
        System.out.println("\n╙──────────────────────────────╜");

        // Resultado final
        System.out.println("""
╓──────────────────────────────╖
║ ✅ Resultado final           ║
╟──────────────────────────────╢
""" + "║ El número en la posición " + n + " es: " + fibonacci(n) + "\n" +
                "╙──────────────────────────────╜");
    }
}

