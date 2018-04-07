package com.marianoPrograma.EstructurasDeDatosLineales.Nodo;

/**
 * clase EstructuraDeDatosLineal.Nodo, para almacenar datos, estos forman las listas y sus variaciones
 */
public class Nodo <T> {
    /**
     * atributos de tipo nodo, para navegar la lista
     * atributo de tipo T, que contiene la informacion
     */
    private Nodo siguiente;
    private Nodo anterior;
    private T dato;

    /**
     * constructor de la clase EstructuraDeDatosLineal.Nodo
     * @param dato
     */
    public Nodo(T dato) {
        this.siguiente = null;
        this.anterior = null;
        this.dato = dato;
    }

    /**
     * metodo para obtener el siguiente EstructuraDeDatosLineal.Nodo
     * @return siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * metodo para asignar el siguiente
     * @param siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * metodo para obtener el EstructuraDeDatosLineal.Nodo anterior
     * @return anterior
     */
    public Nodo getAnterior() {
        return anterior;
    }

    /**
     * metodo para asignar el anterior
     * @param anterior
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    /**
     * metodo para obtener el dato
     * @return dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * metodo para asignar el dato
     * @param dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }
}
