package Actividades.Actividad_4.models;

public class Empleado {
    private int id;
    private String nombre;
    private String rol;
    private String departamento;

    public Empleado(int id, String nombre, String rol, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Empleado [ID=" + id + ", Nombre=" + nombre +
                ", Rol=" + rol + ", Departamento=" + departamento + "]";
    }
}
