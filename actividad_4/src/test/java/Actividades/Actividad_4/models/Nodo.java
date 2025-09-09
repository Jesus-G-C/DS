package Actividades.Actividad_4.models;

public class Nodo {
    public Empleado empleado;
    public Nodo izquierdo, derecho;

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = null;
        this.derecho = null;
    }
}
