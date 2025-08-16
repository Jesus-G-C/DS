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

    public static ArrayList<String> version = new ArrayList<>(Arrays.asList("10.2", "10.1", "10.0"));
    
    // Clase interna Nodo
    static class Node {
        String versions;
        Node prev;
        Node next;

        Node(String versions) {
            this.versions = versions;
        }
    }

    static Node head = null;
    static Node tail = null;

    // Inicializar lista con juegos del ArrayList
    static {
        for (String versions : version) {
            Node newNode = new Node(versions);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
    }
    

    // 📌 Agregar juegos al final de la lista doblemente enlazada
    public static void dladd() {
        Scanner scanner = new Scanner(System.in);
        
       

           
            System.out.println("Ingrese la version que guste:");
            String versions = scanner.nextLine();
            Node newNode = new Node(versions);

            if (head == null) { // lista vacía
                head = tail = newNode;
            } else { // insertar al final
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            System.out.println("version agregada exitosamente: " + versions);
        
    }

    // 📌 Buscar un juego por nombre
    public static void Dlsearch() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la version a buscar:");
        String searchversions = scanner.nextLine();

        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.versions.equalsIgnoreCase(searchversions)) {
                System.out.println("✅ version encontrada: " + current.versions);
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("❌ version no encontrada.");
        }
    }

    // 📌 Eliminar un juego por nombre
    public static void dldelete() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la version a eliminar:");
        String deleteversions = scanner.nextLine();

        Node current = head;
        boolean deleted = false;

        while (current != null) {
            if (current.versions.equalsIgnoreCase(deleteversions)) {
                // Caso: único nodo
                if (current.prev == null && current.next == null) {
                    head = tail = null;
                }
                // Caso: cabeza
                else if (current.prev == null) {
                    head = current.next;
                    head.prev = null;
                }
                // Caso: cola
                else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                }
                // Caso: nodo intermedio
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                deleted = true;
                System.out.println("🗑️ version eliminada: " + deleteversions);
                break;
            }
            current = current.next;
        }

        if (!deleted) {
            System.out.println("❌ version no encontrada.");
        }
    }

    // 📌 Mostrar lista desde el inicio hasta el final
   // 📌 Mostrar lista de mayor a menor (sin alterar la lista original)
public static void dlshow() {
    if (head == null) {
        System.out.println("La lista está vacía.");
        return;
    }

    // Guardar versiones en una lista temporal
    ArrayList<Double> tempList = new ArrayList<>();
    Node current = head;
    while (current != null) {
        try {
            tempList.add(Double.parseDouble(current.versions));
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Valor no numérico encontrado: " + current.versions);
        }
        current = current.next;
    }

    // Ordenar de mayor a menor
    tempList.sort((a, b) -> Double.compare(b, a));

    // Mostrar resultado
    System.out.println("📋 Lista de versiones (mayor → menor):");
    for (double v : tempList) {
        System.out.print(v + " <-> ");
    }
    System.out.println("null");
}

    
}



    