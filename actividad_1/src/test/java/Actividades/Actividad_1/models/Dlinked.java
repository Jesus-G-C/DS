package Actividades.Actividad_1.models;
import java.util.Scanner;

import Actividades.Actividad_1.process.DoubleL;

public class Dlinked {

    public static void dthreaded(){
        
            Scanner scanner = new Scanner(System.in);
            dlmenu();
            int option = scanner.nextInt();scanner.nextLine();
    
            while (option != 0){
                switch (option){
                    case 1://agrega un juego
                        System.out.println("Agregando version...");
                        DoubleL.dladd();
                        
                        break;
    
                    case 2://busca una version
                        System.out.println("Buscando version...");
                        DoubleL.Dlsearch();
    
                        break;
    
                    case 3: //eliminar un juego
                        System.out.println("Eliminando version...");
                        DoubleL.dldelete();
                        break;
                    case 4: // mostrar mi cuenta
                        System.out.println("Mostrando version...");
                        DoubleL.dlshow();
                        break;
                    
    
                    default:
                        System.out.println("Opcion invalida");
                }
                dlmenu();
                option = scanner.nextInt();scanner.nextLine();
            }
        
    
    }

    public static void dlmenu(){
        System.out.println("""
            \n   ******************************************************   
               ********************* Bienvenido *********************
               ***************** ¿Que lista deseas? *****************
               ***************   1.- Agregar Juego    ***************
               *****************  2.- Buscar version  ***************
               ****************  3.- Eliminar Juego  ****************
               ****************  4.- Mostrar Juegos ***************** 
               **************** 0. Regresar al menu *****************
               ******************************************************""");
    }

    


}
