package Actividades.Actividad_Hospital.models;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import java.util.*;

class Paciente {
    String nombre;
    int prioridad; // 0 = máxima urgencia, 3 = mínima urgencia

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        String categoria;
        switch (prioridad) {
            case 0: categoria = "🔴 Crítico"; break;
            case 1: categoria = "🟠 Alta"; break;
            case 2: categoria = "🟡 Media"; break;
            default: categoria = "🟢 Baja";
        }
        return nombre + " (" + categoria + ")";
    }
}

public class UrgenciasSimulador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lista de llegada
        List<Paciente> listaLlegada = new ArrayList<>();

        // Cola de prioridad
        PriorityQueue<Paciente> colaPrioridad = new PriorityQueue<>(new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                return Integer.compare(p1.prioridad, p2.prioridad);
            }
        });

        System.out.print("¿Cuántos pacientes ingresarán? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar el buffer

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\nPaciente " + i + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            int prioridad;
            while (true) {
                System.out.print("Nivel de urgencia (0=Crítico, 1=Alta, 2=Media, 3=Baja): ");
                prioridad = sc.nextInt();
                sc.nextLine(); // limpiar el buffer
                if (prioridad >= 0 && prioridad <= 3) break;
                System.out.println("⚠️ Valor inválido. Ingrese un número entre 0 y 3.");
            }

            Paciente paciente = new Paciente(nombre, prioridad);
            listaLlegada.add(paciente);
            colaPrioridad.add(paciente);
        }

        // Mostrar lista de llegada
        System.out.println("\n📋 Lista de llegada:");
        for (Paciente p : listaLlegada) {
            System.out.println(" - " + p);
        }

        // Mostrar orden de atención
        System.out.println("\n🏥 Orden de atención por prioridad:");
        while (!colaPrioridad.isEmpty()) {
            System.out.println(" - " + colaPrioridad.poll());
        }

        sc.close();
    }
}
