package Actividades.Actividad_1.models;

import java.util.Scanner;

import Actividades.Actividad_1.process.LinkedList;

public class Linked {

    public static void threaded() {
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt(); scanner.nextLine();

        while (option != 0) {
            switch (option) {
                case 1:
                    LinkedList.ladd();
                    break;
                case 2:
                    LinkedList.ldel();
                    break;
                case 3:
                    LinkedList.lsearch();
                    break;
                case 4:
                    LinkedList.lshow();
                case 5:
                    System.out.println("""
                        ╓──────────────────────────────────────────────╖
                        ║ [📂] ¿Cómo deseas ver el historial?          ║
                        ╟──────────────────────────────────────────────╢
                        ║ [1] LIFO ...............(Mas reciente)       ║
                        ║ [2] FIFO (Mostrar por fecha de compra)       ║
                        ╙──────────────────────────────────────────────╜
                    """);
                    int showOption = scanner.nextInt(); scanner.nextLine();
                    if (showOption == 1) {
                        LinkedList.lshowFIFO();
                    } else if (showOption == 2) {
                        LinkedList.lshowLIFO();
                    } else {
                        System.out.println("Opción inválida");
                    }
                    break;

                case 0:
                    System.out.println("");
                    System.out.println("""
                    ╓────────────────────────────────────╖
                    ╟─ [(˶ᵔ ᵕ ᵔ˶)] ¡Hasta luego Daniel! ─╢
                    ╙────────────────────────────────────╜
                """);
                    break;

                default:
                    System.out.println("""
                    ╓───────────────────────╖
                    ╟─ [⚠] Opción inválida ─╢
                    ╙───────────────────────╜
                """);
            }
            showMenu();
            option = scanner.nextInt(); scanner.nextLine();
        }
    }

    private static void showMenu() {
        System.out.println("""
            ╓────────────────────────────────────────────────────╖
            ║           [📁] ¡Bienvenido Daniel! [👋]            ║
            ╟─╖──────────────────────────────────────────────────╢
            ║ ║ [➕] Agregar ......................... [1]       ║
            ║ ║ [🗑️] Eliminar ........................ [2]       ║
            ║ ║ [🔎] Buscar .......................... [3]       ║
            ║ ║ [📌] Mostrar ......................... [4]       ║
            ║ ║ [📌] Mostrar Historial ............... [5]       ║
            ║ ║ [🏃] Back ............................ [0]       ║
            ╙─╜──────────────────────────────────────────────────╜
        """);
    }
}