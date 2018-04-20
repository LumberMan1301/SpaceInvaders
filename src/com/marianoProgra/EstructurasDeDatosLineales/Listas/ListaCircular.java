package com.marianoProgra.EstructurasDeDatosLineales.Listas;

import com.marianoProgra.EstructurasDeDatosLineales.Nodo.Nodo;


public class ListaCircular<T>
{
    private Nodo<T> primero;
    private int capacidad;

    public ListaCircular()
    {
        this.primero = null;
        this.capacidad = 0;
    }

    public void agregar(T data)
    {
        if (this.capacidad == 0)
        {
            Nodo<T> aux = new Nodo<>(data);
            this.primero = aux;
            this.primero.setSiguiente(aux);
            this.capacidad += 1;
        }
        else
        {
            Nodo<T> current = this.primero;
            while (current.getSiguiente() != this.primero) {
                current = current.getSiguiente();
            }
            Nodo<T> aux = new Nodo<>(data);
            aux.setSiguiente(this.primero);
            current.setSiguiente(aux);
            this.capacidad += 1;
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
            int a = 0;
            while (a != pos_aux)
            {
                current = current.getSiguiente();
                a++;
            }
            current.setSiguiente(null);
            this.capacidad -= 1;
        }
        else if (pos_aux >= getCapacidad())
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
            current.setSiguiente(current.getSiguiente().getSiguiente());
            this.capacidad -= 1;
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

    public T obtenerDato(int i)
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

    //#################Getters and Setters##############################
    public Nodo<T> getPrimero()
    {
        return this.primero;
    }

    public void setPrimero(Nodo<T> primero)
    {
        this.primero = primero;
    }

    public void clear()
    {
        this.primero = null;
        this.capacidad = 0;
    }

    public int getCapacidad()
    {
        return this.capacidad;
    }

    public boolean estaVacia()
    {
        if (this.capacidad == 0) {
            return true;
        }
        return false;
    }

    public String print()
    {
        String fin = "[";
        Nodo<T> aux = this.primero;
        if (aux == null)
        {
            fin = fin + "]";
            return fin;
        }
        int a = 0;
        while (a != this.capacidad)
        {
            int b = a;
            if (b++ == this.capacidad - 1)
            {
                fin = fin + aux.getDato().toString();
                aux = aux.getSiguiente();
                a++;
            }
            else
            {
                fin = fin + aux.getDato().toString() + ",";
                aux = aux.getSiguiente();
                a++;
            }
        }
        fin = fin + "]";
        return fin;
    }
}
