package Actividades.Actividad_1.ui;

import Actividades.Actividad_1.models.Circular;
import Actividades.Actividad_1.models.Dlinked;
import Actividades.Actividad_1.models.Linked;

import java.util.Scanner;

public class MAIN {

    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            showMenu();
            option = scanner.nextInt();scanner.nextLine();

            switch (option){
                case 1:
                    Linked.threaded();
                    break;

                case 2:
                    Dlinked.dthreaded();
                    break;

                case 3:
                    Circular.round();
                    break;


                case 0:
                    System.out.print("❓ ¿Seguro que deseas salir? (s/n): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    
                    if (confirm.equals("s")) {
                        System.out.println("👋 Cerrando aplicación... ¡Hasta pronto!");
                        return; 

                    } else {
                        option = -1; 
                    }
                    break;

                default:
                    System.out.println("⚠️ Opción no válida, intenta de nuevo.");
            }
        } while (option != 0);
    }

    public static void showMenu(){
        System.out.println("""
            
            ╔═══════════════════════════════════════════════╗
            ║              🌟 Bienvenido 🌟                 ║
            ║═══════════════════════════════════════════════║
            ║  1️⃣  Acceder como Daniel                     ║
            ║  2️⃣  Acceder como Alex                       ║
            ║  3️⃣  Acceder como Jesús                      ║
            ║  0️⃣  Salir 🚪                                ║
            ╚═══════════════════════════════════════════════╝
            """);
    }

}
