package com.marianoProgra.EstructurasDeDatosLineales.Listas;

import com.marianoProgra.EstructurasDeDatosLineales.Nodo.Nodo;


/**
 * Se crea la clase Lista Doble que es una derivada de la clase Lista
 */
public class ListaDoble<T>
{
    private Nodo<T> primero;
    private int capacidad;

    public ListaDoble()
    {
        this.primero = null;
        this.capacidad = 0;

    }

    public void agregar(T data)
    {
        if (this.capacidad == 0)
        {
            Nodo<T> aux = new Nodo(data);
            this.primero = aux;
            this.primero.setSiguiente(null);
            this.primero.setAnterior(null);
            this.capacidad += 1;
        }
        else
        {
            Nodo<T> actual = this.primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            Nodo<T> aux = new Nodo(data);
            aux.setSiguiente(null);
            actual.setSiguiente(aux);
            aux.setAnterior(actual);
            this.capacidad += 1;
        }
    }
    public void agregar(int pos, T dato){
        if (this.estaVacia()) {
            if (pos==0) {
                Nodo<T> aux = new Nodo(dato);
                this.primero = aux;
                this.capacidad ++;
            }else{
                System.out.println("Posicion fuera de rango");
            }
        }
        else {
            if(pos>this.capacidad){
                System.out.println("La Posicion es mayor a la Capacidad de la lista");
            }else if(pos == capacidad){
                agregar(dato);
            }else{
                Nodo aux = this.primero;
                Nodo nuevo = new Nodo(dato);
                if(pos==0){
                    nuevo.setSiguiente(aux);
                    aux.setAnterior(nuevo);
                    this.primero = nuevo;
                    capacidad++;
                }else{
                    int contador=0;
                    while(contador < pos-1){
                        aux = aux.getSiguiente();
                        contador++;
                    }
                    nuevo.setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(nuevo);
                    nuevo.setAnterior(aux);
                    aux.setSiguiente(nuevo);
                    capacidad++;
                }
            }

        }
    }

    public void eliminarPos(int posicion)
    {
        int pos_aux = posicion;
        Nodo<T> current = this.primero;
        if (pos_aux == 0)
        {
            this.primero = current.getSiguiente();
            this.capacidad -= 1;
        }
        else if (pos_aux == this.capacidad - 1)
        {
            while (current.getSiguiente().getSiguiente() != null) {
                current = current.getSiguiente();
            }
            current.setSiguiente(null);
            this.capacidad -= 1;
        }
        else if (pos_aux >= capacidad())
        {
            System.out.println("No se encuentra el elemento");
        }
        else
        {
            int b = 0;
            while (pos_aux - 1 != b)
            {
                current = current.getSiguiente();
                b++;
            }
            Nodo<T> aux = current.getSiguiente().getSiguiente();
            current.setSiguiente(aux);
            if (aux == null)
            {
                this.capacidad -= 1;
            }
            else
            {
                aux.setAnterior(current);

                this.capacidad -= 1;
            }
        }
    }

    public void eliminarDato(T dato)
    {
        int pos_aux = 0;
        Nodo<T> current = this.primero;
        if (current.getDato() == dato)
        {
            eliminarPos(pos_aux);
        }
        else
        {
            current = current.getSiguiente();
            pos_aux++;
            int x = 0;
            while ((current != null) && (current.getDato() != dato) && (this.capacidad >= x))
            {
                current = current.getSiguiente();
                pos_aux++;
                x++;
            }
            if (current == null) {
                System.out.println("El elemento no se encuentra en la lista");
            } else {
                eliminarPos(pos_aux);
            }
        }
    }

    public T getDato(int i)
    {
        Nodo<T> aux = getPrimero();
        int x = 0;
        while (x != i)
        {
            aux = aux.getSiguiente();
            x++;
        }
        if (aux == null)
        {
            System.out.println("El elemento no se encuentra en la lista");
            return null;
        }
        return (T)aux.getDato();
    }
    public Nodo getNodo(int i)
    {
        Nodo<T> aux = getPrimero();
        int x = 0;
        while (x != i)
        {
            aux = aux.getSiguiente();
            x++;
        }
        if (aux == null)
        {
            System.out.println("El elemento no se encuentra en la lista");
            return null;
        }
        return aux;
    }

    public Nodo<T> getPrimero()
    {
        return this.primero;
    }

    public void setPrimero(Nodo<T> primero)
    {
        this.primero = primero;
    }

    public void vaciar()
    {
        this.primero = null;
        this.capacidad = 0;
    }

    public int capacidad() {
        return this.capacidad;
    }

    public T buscar(T dato)
    {
        Nodo<T> aux = this.primero;
        while (dato != aux.getDato()) {
            aux = aux.getSiguiente();
        }
        return (T)aux.getDato();
    }

    public boolean estaVacia()
    {
        if (this.capacidad == 0) {
            return true;
        }
        return false;
    }

    public void imprimirL() {
        if(this.estaVacia())
            System.out.println("La Lista Esta Vacia");
        else {
            Nodo aux = this.primero;
            System.out.print("[");
            while (aux.getSiguiente()!=null){
                System.out.print(aux.getDato().toString()+",");
                aux=aux.getSiguiente();
            }System.out.println(aux.getDato().toString()+"]");
        }
    }

    public void swap(int pos1, int pos2){
        if(estaVacia())
            return;
        else{
            if(pos1 < this.capacidad && pos2 < this.capacidad){
                Nodo aux1 = this.getNodo(pos1);
                Nodo aux2 = this.getNodo(pos2);
                if(pos1>pos2){
                    this.agregar(pos2, (T)aux1.getDato());
                    this.agregar(pos1+1, (T)aux2.getDato());
                    this.eliminarPos(pos2+1);
                    this.eliminarPos(pos1+1);

                }else{
                    this.agregar(pos1, (T)aux2.getDato());
                    this.imprimirL();
                    this.agregar(pos2+1, (T)aux1.getDato());
                    this.imprimirL();
                    this.eliminarPos(pos1+1);
                    this.imprimirL();
                    this.eliminarPos(pos2+1);
                    this.imprimirL();
                }
            }else{
                System.out.println("una de las posiciones esta fuera del limite");
            }
        }
    }
}
