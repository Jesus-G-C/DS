package Actividades.Actividad_4.process;

import Actividades.Actividad_4.models.Nodo;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar nodo en el árbol
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Nodo insertarRecursivo(Nodo actual, int id, String nombre) {
        if (actual == null) {
            return new Nodo(id, nombre);
        }
        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        }
        return actual;
    }

    // Buscar nodo por ID
    public Nodo buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {
        if (actual == null || actual.id == id) {
            return actual;
        }
        return (id < actual.id) ? buscarRecursivo(actual.izquierdo, id) : buscarRecursivo(actual.derecho, id);
    }

    // Eliminar nodo
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private Nodo eliminarRecursivo(Nodo actual, int id) {
        if (actual == null) {
            return null;
        }

        if (id < actual.id) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
        } else if (id > actual.id) {
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
            actual.id = sucesor.id;
            actual.nombre = sucesor.nombre;
            actual.derecho = eliminarRecursivo(actual.derecho, sucesor.id);
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
            System.out.print(actual.id + " (" + actual.nombre + ") ");
            inOrdenRec(actual.derecho);
        }
    }

    public void preOrden() {
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.id + " (" + actual.nombre + ") ");
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
            System.out.print(actual.id + " (" + actual.nombre + ") ");
        }
    }
}
