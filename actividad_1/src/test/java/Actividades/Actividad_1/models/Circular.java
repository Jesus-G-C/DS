package Actividades.Actividad_1.models;

import java.util.Scanner;

public class Circular {

    public static void round(){
        Scanner scanner = new Scanner(System.in);
        showMenu();
    }

    private static void showMenu(){
        System.out.println("""
            \n   ******************************************************   
               ********************* Bienvenido *********************
               ***************** ¿Que lista deseas? *****************
               *****************   1.- Enlazadas    *****************
               ***************  2.- Doble Enlazadas  ****************    
               *****************  3.- Circulares  *******************
               ********************  0.- Exit  **********************
               ******************************************************""");
    }

}
