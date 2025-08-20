package Actividades.Actividad_1.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LinkedList {

    public static ArrayList<String> games = new ArrayList<>(Arrays.asList("Halo", "GTAV", "Call of Duty"));

    public static void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📝 ¿Cuántos juegos desea agregar?");
        int cuantity = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cuantity; i++) {
            System.out.println("🎮 Ingrese el juego #" + (i + 1) + ":");
            String game = scanner.nextLine();
            games.add(game);
        }
        System.out.println("✅ Juegos agregados correctamente.");
    }

    public static void del() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("❌ ¿Qué juego desea eliminar?");
        String gameToDelete = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).equalsIgnoreCase(gameToDelete)) {
                games.remove(i);
                found = true;
                System.out.println("🗑️ " + gameToDelete + " eliminado con éxito.");
                break;
            }
        }

        if (!found) {
            System.out.println("⚠️ " + gameToDelete + " no se encontró en tu biblioteca.");
        }
    }

    public static void search() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔍 ¿Qué juego desea buscar?");
        String gameToSearch = scanner.nextLine();

        boolean found = false;
        for (String game : games) {
            if (game.equalsIgnoreCase(gameToSearch)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("✅ " + gameToSearch + " está en tu biblioteca.");
        } else {
            System.out.println("⚠️ " + gameToSearch + " no está en tu biblioteca.");
        }
    }

    public static void show() {
        Collections.sort(games, String.CASE_INSENSITIVE_ORDER);

        System.out.println("\n📚 **********  Tu biblioteca (ordenada) **********");
        for (String game : games) {
            System.out.println("🎮 " + game);
        }
    }

    // Mostrar en orden FIFO (primero en entrar, primero en salir)
    public static void fifo() {
        System.out.println("\n📥 ********** Biblioteca en orden FIFO **********");
        for (String game : games) {
            System.out.println("➡️ " + game);
        }
    }

    // Mostrar en orden LIFO (último en entrar, primero en salir)
    public static void lifo() {
        System.out.println("\n📤 ********** Biblioteca en orden LIFO **********");
        for (int i = games.size() - 1; i >= 0; i--) {
            System.out.println("⬅️ " + games.get(i));
        }
    }

    /// /////////////////////////
    ///
    ///
    ///
    /// /// Double Linked List
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

    /// ////
    ///
    ///
    /// Linked List
    ///


    private static class LNode {
        String ldata;
        LNode lnext;

        LNode(String ldata) {
            this.ldata = ldata;
            this.lnext = null;
        }
    }

    private static LNode lhead = null;

    // Bloque estático para precargar juegos ordenados
    static {
        String[] juegos = {"The Witcher 3", "Red Dead Redemption 2", "LoL"};
        for (String juego : juegos) {
            insertSorted(juego);
        }
    }

    // Inserta un nodo en la posición alfabética correcta
    private static void insertSorted(String lgame) {
        LNode newLNode = new LNode(lgame);

        // Caso: lista vacía o el nuevo dato es menor que la cabeza
        if (lhead == null || lgame.compareToIgnoreCase(lhead.ldata) < 0) {
            newLNode.lnext = lhead;
            lhead = newLNode;
            return;
        }

        // Buscar la posición correcta
        LNode lcurrent = lhead;
        while (lcurrent.lnext != null && lgame.compareToIgnoreCase(lcurrent.lnext.ldata) > 0) {
            lcurrent = lcurrent.lnext;
        }

        // Insertar en la posición encontrada
        newLNode.lnext = lcurrent.lnext;
        lcurrent.lnext = newLNode;
    }

    public static void ladd() {
        Scanner scanner = new Scanner(System.in);
        int quantity;
        while (true) {
            try {
                System.out.println("""
                    ╓─────────────────────────────────────────────╖
                    ╟─ [❔] ¿Cuántos juegos desea agregar?       ─╢
                    ╙─────────────────────────────────────────────╜
                """);
                quantity = scanner.nextInt();
                scanner.nextLine();

                if (quantity <= 0) {
                    System.out.println("""
                    ╓─────────────────────────────────────────────╖
                    ╟─ [⚠] Por favor ingrese un número mayor a 0 ─╢
                    ╙─────────────────────────────────────────────╜
                """);
                } else {
                    break; // número válido → salir del bucle
                }
            } catch (InputMismatchException e) {
                System.out.println("""
                ╓──────────────────────────────────────╖
                ╟─ [⚠] Ingrese un número              ─╢
                ╙──────────────────────────────────────╜
            """);
                scanner.nextLine(); // limpiar entrada inválida
            }
        }

        // Pedir los juegos
        for (int i = 0; i < quantity; i++) {
            System.out.println("""
                ╓──────────────────────────────────────╖
                ╟─ [➕] Ingrese el elemento #         ─╢
                ╙──────────────────────────────────────╜
            """  + (i + 1) + ":");
            String lgame = scanner.nextLine();
            insertSorted(lgame);
        }
    }


    public static void ldel() {
        if (lhead == null) {
            System.out.println("""
                        ╓───────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] La lista está vacía ─╢
                        ╙───────────────────────────────────╜
                    """);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                    ╓─────────────────────────────────────────────╖
                    ╟─ [❔] ¿Qué juego desea eliminar?           ─╢
                    ╙─────────────────────────────────────────────╜
                """);
        String lgameToDelete = scanner.nextLine();

        // Caso: eliminar cabeza
        if (lhead.ldata.equalsIgnoreCase(lgameToDelete)) {
            lhead = lhead.lnext;
            System.out.println(lgameToDelete + """
                         ╓──────────────────────────────────────────────╖
                         ╟─ [(˶ᵔ ᵕ ᵔ˶)] Juego eliminado con éxito      ─╢
                         ╙──────────────────────────────────────────────╜
                    """);
            return;
        }

        LNode ltemp = lhead;
        LNode lprev = null;
        boolean found = false;

        while (ltemp != null) {
            if (ltemp.ldata.equalsIgnoreCase(lgameToDelete)) {
                lprev.lnext = ltemp.lnext;
                found = true;
                System.out.println(lgameToDelete + """
                         ╓──────────────────────────────────────────────╖
                         ╟─ [(˶ᵔ ᵕ ᵔ˶)] Juego eliminado con éxito      ─╢
                         ╙──────────────────────────────────────────────╜
                    """);
                break;
            }
            lprev = ltemp;
            ltemp = ltemp.lnext;
        }

        if (!found) {
            System.out.println(lgameToDelete + """
                        ╓────────────────────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] no se encuentra en la biblioteca ─╢
                        ╙────────────────────────────────────────────────╜
                    """);
        }
    }

    public static void lsearch() {
        if (lhead == null) {
            System.out.println("""
                        ╓───────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] La lista está vacía ─╢
                        ╙───────────────────────────────────╜
                    """);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                    ╓───────────────────────────────────────╖
                    ╟─ [❔] ¿Qué juego desea buscar?       ─╢
                    ╙───────────────────────────────────────╜
                """);
        System.out.println("¿Qué juego desea buscar?");
        String lgameToSearch = scanner.nextLine();

        LNode ltemp = lhead;
        boolean found = false;

        while (ltemp != null) {
            if (ltemp.ldata.equalsIgnoreCase(lgameToSearch)) {
                found = true;
                break;
            }
            ltemp = ltemp.lnext;
        }

        if (found) {
            System.out.println(lgameToSearch + """
                         ╓──────────────────────────────────────────────╖
                         ╟─ [(˶ᵔ ᵕ ᵔ˶)] El juego está en la biblioteca ─╢
                         ╙──────────────────────────────────────────────╜
                    """);
            return;
        } else {
            System.out.println("""
                        ╓────────────────────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] no se encuentra en la biblioteca ─╢
                        ╙────────────────────────────────────────────────╜
                    """);

        }
    }

    public static void lshow() {
        if (lhead == null) {
            System.out.println("""
                        ╓───────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] La lista está vacía ─╢
                        ╙───────────────────────────────────╜
                    """);
            return;
        }

        System.out.println("""
                        ╓──────────────────────────────────────────────╖
                        ║ [📂] Tu biblioteca:                          ║
                        ╙──────────────────────────────────────────────╜
                    """);
        LNode ltemp = lhead;
        while (ltemp != null) {
            System.out.println("- " + ltemp.ldata);
            ltemp = ltemp.lnext;
        }
    }

    // Mostrar FIFO (igual que lshow, pero con cabecera personalizada)
    public static void lshowFIFO() {
        if (lhead == null) {
            System.out.println("""
                        ╓───────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] La lista está vacía ─╢
                        ╙───────────────────────────────────╜
                    """);
            return;
        }

        System.out.println("""
                        ╓──────────────────────────────────────────────╖
                        ╟─ FIFO (Primero en entrar, primero en salir) ─╢
                        ╙──────────────────────────────────────────────╜
                    """);
        LNode ltemp = lhead;
        while (ltemp != null) {
            System.out.println(" → " + ltemp.ldata);
            ltemp = ltemp.lnext;
        }
    }

    // Mostrar LIFO usando recursividad
    public static void lshowLIFO() {
        if (lhead == null) {
            System.out.println("""
                        ╓───────────────────────────────────╖
                        ╟─ [૮(˶ㅠ︿ㅠ)ა] La lista está vacía ─╢
                        ╙───────────────────────────────────╜
                    """);
            return;
        }

        System.out.println("""
                        ╓─────────────────────────────────────────────╖
                        ╟─ LIFO (Último en entrar, primero en salir) ─╢
                        ╙─────────────────────────────────────────────╜
                    """);
        printReverse(lhead);
    }

    // Función auxiliar recursiva para recorrer la lista al revés
    private static void printReverse(LNode node) {
        if (node == null) return;
        printReverse(node.lnext); // recorre hasta el final
        System.out.println(" → " + node.ldata); // imprime en el "regreso"
    }
}







    