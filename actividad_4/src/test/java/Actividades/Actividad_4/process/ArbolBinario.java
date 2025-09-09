package Actividades.Actividad_4.process;

import Actividades.Actividad_4.models.Empleado;
import Actividades.Actividad_4.models.Nodo;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar nodo en el árbol
    public void insertar(int id, String nombre, String rol, String departamento) {
        Empleado empleado = new Empleado(id, nombre, rol, departamento);
        raiz = insertarRecursivo(raiz, empleado);
    }

    private Nodo insertarRecursivo(Nodo actual, Empleado empleado) {
        if (actual == null) {
            return new Nodo(empleado);
        }
        if (empleado.getId() < actual.empleado.getId()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, empleado);
        } else if (empleado.getId() > actual.empleado.getId()) {
            actual.derecho = insertarRecursivo(actual.derecho, empleado);
        }
        return actual;
    }

    // Buscar nodo por ID
    public Nodo buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {
        if (actual == null || actual.empleado.getId() == id) {
            return actual;
        }
        return (id < actual.empleado.getId())
                ? buscarRecursivo(actual.izquierdo, id)
                : buscarRecursivo(actual.derecho, id);
    }

    // Eliminar nodo
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private Nodo eliminarRecursivo(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id < actual.empleado.getId()) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
        } else if (id > actual.empleado.getId()) {
            actual.derecho = eliminarRecursivo(actual.derecho, id);
        } else {
            // Caso 1: sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            // Caso 2: un solo hijo
            else if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            }
            // Caso 3: dos hijos
            Nodo sucesor = encontrarMinimo(actual.derecho);
            actual.empleado = sucesor.empleado;
            actual.derecho = eliminarRecursivo(actual.derecho, sucesor.empleado.getId());
        }
        return actual;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    // Recorridos
    public void inOrden() {
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(Nodo actual) {
        if (actual != null) {
            inOrdenRec(actual.izquierdo);
            System.out.print(actual.empleado + " | ");
            inOrdenRec(actual.derecho);
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.empleado + " | ");
            preOrdenRec(actual.izquierdo);
            preOrdenRec(actual.derecho);
        }
    }

    public void postOrden() {
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(Nodo actual) {
        if (actual != null) {
            postOrdenRec(actual.izquierdo);
            postOrdenRec(actual.derecho);
            System.out.print(actual.empleado + " | ");
        }
    }
}

