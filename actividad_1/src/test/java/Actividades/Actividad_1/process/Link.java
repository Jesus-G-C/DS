package Actividades.Actividad_1.process;

import java.util.Scanner;

public class Link {

    // Nodo interno de la lista enlazada simple
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node head = null;

    // Bloque estático para precargar juegos ordenados
    static {
        String[] juegos = {"Halo", "GTAV", "Call of Duty"};
        for (String juego : juegos) {
            insertSorted(juego);
        }
    }

    // Inserta un nodo en la posición alfabética correcta
    private static void insertSorted(String game) {
        Node newNode = new Node(game);

        // Caso: lista vacía o el nuevo dato es menor que la cabeza
        if (head == null || game.compareToIgnoreCase(head.data) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Buscar la posición correcta
        Node current = head;
        while (current.next != null && game.compareToIgnoreCase(current.next.data) > 0) {
            current = current.next;
        }

        // Insertar en la posición encontrada
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos juegos desea agregar?");
        int quantity = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Ingrese el elemento #" + (i + 1) + ":");
            String game = scanner.nextLine();
            insertSorted(game);
        }
    }

    public static void del() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué juego desea eliminar?");
        String gameToDelete = scanner.nextLine();

        // Caso: eliminar cabeza
        if (head.data.equalsIgnoreCase(gameToDelete)) {
            head = head.next;
            System.out.println(gameToDelete + " eliminado con éxito.");
            return;
        }

        Node temp = head;
        Node prev = null;
        boolean found = false;

        while (temp != null) {
            if (temp.data.equalsIgnoreCase(gameToDelete)) {
                prev.next = temp.next;
                found = true;
                System.out.println(gameToDelete + " eliminado con éxito.");
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        if (!found) {
            System.out.println(gameToDelete + " no se encuentra en la biblioteca.");
        }
    }

    public static void search() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué juego desea buscar?");
        String gameToSearch = scanner.nextLine();

        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.equalsIgnoreCase(gameToSearch)) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (found) {
            System.out.println(gameToSearch + " está en la biblioteca.");
        } else {
            System.out.println(gameToSearch + " no se encuentra en la biblioteca.");
        }
    }

    public static void show() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("**********  Tu biblioteca  **********");
        Node temp = head;
        while (temp != null) {
            System.out.println("- " + temp.data);
            temp = temp.next;
        }
    }
}

