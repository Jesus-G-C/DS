package Actividades.Actividad_1.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ball {

    public static ArrayList<String> games = new ArrayList<>(Arrays.asList("Halo","GTAV","Call of Duty"));
    
    public static void add(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuantos juegos desea agregar?");
        int cuantity = scanner.nextInt();scanner.nextLine();

        for (int i = 0; i < cuantity; i++){
            System.out.println("Ingrese el elemento #" + (i+1) + ":");
            String game = scanner.nextLine();
            games.add(game);
        }
    }

    public static void del(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que juego desea eliminar?");
        String gameToDelete = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < games.size(); i++){
            if (games.get(i).equalsIgnoreCase(gameToDelete)){
                games.remove(i);
                found = true;
                System.out.println(gameToDelete + " Eliminado con exito.");
                break;
            }
        }

        if (!found){
            System.out.println(gameToDelete + " No cuentas con el juego");
        }
    }

    public static void search(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que juego desea buscar?");
        String gameToSearch = scanner.nextLine();

        boolean found = false;
        for(String game : games){
            if(game.equalsIgnoreCase(gameToSearch)){
                found = true;
                break; 
            }
        }

        if(found){
            System.out.println(gameToSearch + " Esta en la biblioteca");
        } else{
            System.out.println(gameToSearch + " No cuentas con el juego");
        }
    }

    public static void show(){
        Collections.sort(games, String.CASE_INSENSITIVE_ORDER);

        System.out.println("**********  Tu biblioteca  **********");

        for (String game:games){
            System.out.println("- " + game);
        }
    }
}

