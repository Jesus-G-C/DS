package Actividades.Actividad_1.models;

import java.util.Scanner;
import Actividades.Actividad_1.process.LinkedList;

public class Circular {

    public static void round(){
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
        showMenu();
        option = scanner.nextInt(); scanner.nextLine();

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
            
            case 5:
                LinkedList.fifo();
                break;

            case 6:
                LinkedList.lifo();
                break;

            case 0:
                System.out.println("👋 Saliendo... ¡Hasta luego Jesús!");
                break;
            
            default:
                System.out.println("⚠️ Opción no válida, intenta de nuevo.");
        }
    } while (option != 0);
}


    private static void showMenu(){
        System.out.println("""
            
            ╔═══════════════════════════════════════════════╗
            ║        🌟 Bienvenido Jesús 🌟                ║
            ║═══════════════════════════════════════════════║
            ║  1️⃣  Agregar juego                           ║
            ║  2️⃣  Eliminar juego                          ║
            ║  3️⃣  Buscar juego                            ║
            ║  4️⃣  Mostrar biblioteca                      ║
            ║  5️⃣  Mostrar por fecha de compra 📥          ║
            ║  6️⃣  Mas reciente 📤                         ║
            ║  0️⃣  Salir 🚪                                ║
            ╚═══════════════════════════════════════════════╝
            """);
    }
}