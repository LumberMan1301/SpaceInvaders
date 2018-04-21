package com.marianoProgra.EstructurasDeDatosLineales.Listas;

import com.marianoProgra.EstructurasDeDatosLineales.Nodo.Nodo;

/**
 * clase Principal de EstructuraDeDatosLineal.Listas
 */

public class ListaSimple<T>{
    /**
     * atributos de la clase lista, uno de Tipo EstructuraDeDatosLineal.Nodo para almacenar informacion, y otro de tipo Int para hacer
     * un "indice"
     */
    protected Nodo primero;
    protected int capacidad;
    /**
     * constructor de la clase lista
     */
    public ListaSimple() {
        this.capacidad=0;
        this.primero = null;
    }
    /**
     * metodo para revisar si la lista esta vacia
     */

    public boolean estaVacia(){
        if (this.capacidad==0)
            return true;
        else
            return false;
    }
    /**
     * metodo para comprobar si un nodo Existe
     * @param nodo
     */
    public boolean existe(Nodo nodo){
        if (this.estaVacia()){
            return false;
        }else{
            Nodo aux = this.primero;
            while(aux != null){
                if(aux.getDato().equals(nodo.getDato()))
                    return true;
                else
                    aux=aux.getSiguiente();
            }return false;
        }
    }
    /**
     * metodo para agregar al final de la lista
     * @param data
     */
    public void agregar(T data){
        Nodo nodo = new Nodo(data);
        if (this.estaVacia()) {
            this.primero = nodo;
            this.capacidad ++;

        }else{
            Nodo aux = this.primero;
            while(aux.getSiguiente()!=null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
            this.capacidad++;
        }

    }
    /**
     * metodo para imprimir la ListaSimple
     */
    public void imprimirL(){
        if(this.estaVacia())
            System.out.println("La ListaSimple Esta Vacia");
        else {
            Nodo aux = this.primero;
            System.out.print("[");
            while (aux.getSiguiente()!=null){
                System.out.print(aux.getDato().toString()+",");
                aux=aux.getSiguiente();
            }System.out.println(aux.getDato().toString()+"]");
        }
    }
    /**
     *metodo para eliminar un nodo por referencia
     * @param indice
     */
    public void eliminar(int indice){
        if (this.estaVacia())
            System.out.println("ListaSimple Vacia");
        else{
            Nodo aux = this.primero;
            if (indice == 0){
                this.primero=this.primero.getSiguiente();
                capacidad--;
            }else if(indice < capacidad){
                int contador=0;
                while((indice-1)!=contador){
                    aux=aux.getSiguiente();
                    contador++;
                }
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                this.capacidad--;
            }else{
                System.out.println("Indice fuera de limites");
            }
        }

    }
    /**
     * metodo para eliminar por valor
     * @param data
     */
    public void eliminarDato(T data){
        if(this.estaVacia()){
            System.out.println("ListaSimple Vacia");
        }else{
            Nodo aux = this.primero;
            int pos_aux = 0;
            int contador = 0;
            if (aux.getDato().equals(data)){
                eliminar(pos_aux);
                contador++;
                capacidad--;
            }else{
                aux=aux.getSiguiente();
                pos_aux++;
                while(aux.getSiguiente()!=null){
                    if(aux.equals(data)) {
                        eliminar(pos_aux);
                        pos_aux++;
                        aux=aux.getSiguiente();
                        this.capacidad--;
                        contador++;

                    }else{
                        aux=aux.getSiguiente();
                        pos_aux++;
                    }
                }if(aux.getDato().equals(data)){
                    eliminar(pos_aux);
                    capacidad--;
                    contador++;
                }
                if(contador==0)
                    System.out.println("El Dato: "+data+" no esta en la ListaSimple");
            }
        }
    }


    //Getters Y Setters de la Clase ListaSimple
    /**
     * metodo para obtener el primer elemento de la ListaSimple
     * @return primero
     */
    public Nodo getPrimero() {
        return primero;
    }
    /**
     * metodo para definir el primer elemento de la clase lista
     * @param primero
     */
    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    /**
     * metodo para obtener la getCapacidad de la lista
     * @return getCapacidad
     */
    public int getCapacidad() {
        return capacidad;
    }
    /**
     * metodo para definir la getCapacidad
     * @param capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


    //########################################################
    //metodos requeridos para el acoplamiento con el programa
    /**
     * metodo que retorna los valores hasta la posicion solicitada
     * @param i
     * @return Dato
     */
    public T getData(int i){
        Nodo<T> aux = this.getPrimero();
        int x = 0;
        while(x != i){
            aux = aux.getSiguiente();
            x++;
        }
        return aux.getDato();
    }
    /**
     *
     * @param i
     * @return
     */
    public T getNodo(int i){
        Nodo<T> aux = this.getPrimero();
        int x = 0;
        while(x != i){
            aux = aux.getSiguiente();
            x++;
        }
        return (T) aux;
    }
    /**
     * metodo para vaciar la lista
     */
    public void vaciar() {
    	this.setPrimero(null);
    	this.setCapacidad(0);
    }
}
