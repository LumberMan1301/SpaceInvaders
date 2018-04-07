package com.marianoPrograma.EstructurasDeDatosLineales.Listas;

import com.marianoPrograma.EstructurasDeDatosLineales.Nodo.Nodo;

/**
 * Se crea la clase Lista Doble que es una derivada de la clase Lista
 */
public class ListaDoble <T> extends Lista {
    private Nodo ultimo;

    public ListaDoble() {
        super();
        this.ultimo = null;
    }
}
