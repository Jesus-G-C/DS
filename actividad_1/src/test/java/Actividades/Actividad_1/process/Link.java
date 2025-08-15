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

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos juegos desea agregar?");
        int quantity = scanner.nextInt(); scanner.nextLine();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Ingrese el elemento #" + (i + 1) + ":");
            String game = scanner.nextLine();
            Node newNode = new Node(game);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
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

        // Caso: buscar nodo intermedio
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

