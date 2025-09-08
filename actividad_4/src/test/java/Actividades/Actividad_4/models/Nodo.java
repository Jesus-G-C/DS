package Actividades.Actividad_4.models;

public class Nodo {
    public int id;
    public String nombre;
    public Nodo izquierdo, derecho;

    public Nodo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}