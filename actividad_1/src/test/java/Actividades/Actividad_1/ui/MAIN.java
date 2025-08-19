package Actividades.Actividad_1.ui;
import Actividades.Actividad_1.models.Circular;
import Actividades.Actividad_1.models.Dlinked;
import Actividades.Actividad_1.models.Lifo;
import Actividades.Actividad_1.models.Linked;
import java.util.Scanner;

public class MAIN {

    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int option = scanner.nextInt();scanner.nextLine();

        while (option != 0){
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

                case 4:
                    Lifo.stackMenu();
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
            showMenu();
            option = scanner.nextInt();scanner.nextLine();
        }



    }

    public static void showMenu(){
        System.out.println("""
            \n   ******************************************************   
               ********************* Bienvenido *********************
               ***************** ¿Que lista deseas? *****************
               *****************   1.- Enlazadas    *****************
               ***************  2.- Doble Enlazadas  ****************    
               *****************  3.- Circulares  *******************
               *****************     4.- LIFO     *******************
               ********************  0.- Exit  **********************
               ******************************************************""");
    }

}

