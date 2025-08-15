package Actividades.Actividad_1.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DoubleL {
    public static ArrayList<String> games = new ArrayList<>(Arrays.asList("Fortinaity", "BABAG", "GTA VI"));
    
    // Clase interna Nodo
    static class Node {
        String game;
        Node prev;
        Node next;

        Node(String game) {
            this.game = game;
        }
    }

    static Node head = null;
    static Node tail = null;

    // 📌 Inicializar lista con juegos del ArrayList
    static {
        for (String game : games) {
            Node newNode = new Node(game);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        System.out.println("📌 Lista inicial cargada con juegos: " + games);
    }
    

    // 📌 Agregar juegos al final de la lista doblemente enlazada
    public static void dladd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos juegos desea agregar?");
        int count = scanner.nextInt();
        scanner.nextLine(); // limpiar salto de línea

        for (int i = 0; i < count; i++) {
            System.out.println("Ingrese el nombre del juego:");
            String game = scanner.nextLine();
            Node newNode = new Node(game);

            if (head == null) { // lista vacía
                head = tail = newNode;
            } else { // insertar al final
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            System.out.println("Juego agregado exitosamente: " + game);
        }
    }

    // 📌 Buscar un juego por nombre
    public static void Dlsearch() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del juego a buscar:");
        String searchGame = scanner.nextLine();

        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.game.equalsIgnoreCase(searchGame)) {
                System.out.println("✅ Juego encontrado: " + current.game);
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("❌ Juego no encontrado.");
        }
    }

    // 📌 Eliminar un juego por nombre
    public static void dldelete() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del juego a eliminar:");
        String deleteGame = scanner.nextLine();

        Node current = head;
        boolean deleted = false;

        while (current != null) {
            if (current.game.equalsIgnoreCase(deleteGame)) {
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
                System.out.println("🗑️ Juego eliminado: " + deleteGame);
                break;
            }
            current = current.next;
        }

        if (!deleted) {
            System.out.println("❌ Juego no encontrado.");
        }
    }

    // 📌 Mostrar lista desde el inicio hasta el final
    public static void dlshow() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("🎮 Lista de juegos (inicio → fin):");
        Node current = head;
        while (current != null) {
            System.out.print(current.game + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 📌 Mostrar lista desde el final hasta el inicio
    public static void dlshowReverse() {
        if (tail == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("🎮 Lista de juegos (fin → inicio):");
        Node current = tail;
        while (current != null) {
            System.out.print(current.game + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
