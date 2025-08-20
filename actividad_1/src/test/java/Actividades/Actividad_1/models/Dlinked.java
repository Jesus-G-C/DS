package Actividades.Actividad_1.models;
import java.util.Scanner;

import Actividades.Actividad_1.process.LinkedList;


public class Dlinked {

    public static void dthreaded(){
        
            Scanner scanner = new Scanner(System.in);
            dlmenu();
            int option = scanner.nextInt();scanner.nextLine();
    
            while (option != 0){
                switch (option){
                    case 1://agrega un juego
                        System.out.println("Agregando version...");
                        LinkedList.dladd();
                        
                        break;
    
                    case 2://busca una version
                        System.out.println("Eliminando version...");
                        LinkedList.dldelete();
    
                        break;
    
                    case 3: //eliminar un juego
                        System.out.println("Buscando version...");
                        LinkedList.Dlsearch();
                        break;
                    case 4: // mostrar mi cuenta
                        System.out.println("Mostrando version...");
                        LinkedList.dlshow();
                        break;
                    case 5: //mostrar en orden FIFO
                        System.out.println("Mostrando versiones mas recientes...");
                        LinkedList.dlfifo();
                        break;
                    case 6: //mostrar en orden LIFO
                        System.out.println("Mostrando versiones mas antiguas...");
                        LinkedList.dlifo();
                        break;
                    
    
                    default:
                        System.out.println("Opcion invalida");
                }
                dlmenu();
                option = scanner.nextInt();scanner.nextLine();
            }
        
    
    }

    private static void dlmenu(){
        System.out.println("""
            
            ╔═══════════════════════════════════════════════╗
            ║        🌟 Bienvenido Alex 💽!!! 🌟            ║
            ║═══════════════════════════════════════════════║
            ║  1️⃣  Agregar version 🔼                        ║
            ║  2️⃣  Eliminar version 🗑️                        ║
            ║  3️⃣  Buscar version 🔎                         ║
            ║  4️⃣  Mostrar versiones 🗂️                       ║
            ║  5️⃣  Mostrar ultimas versiones agregadas 📥    ║
            ║  6️⃣  Mostrar primeras versiones agregadas 📤   ║
            ║  0️⃣  Salir 🚪                                  ║
            ╚═══════════════════════════════════════════════╝
            """);
    }

//no me pises pa 👀

    


}
