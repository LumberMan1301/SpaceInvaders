package com.marianoProgra.EstructurasDeDatosLineales.Listas;

public class Main {
    public static void main(String[] args) {
        ListaDoble ld = new ListaDoble();
        ld.agregar(1);
        ld.agregar(2);
        ld.agregar(3);
        System.out.println(ld.capacidad());
        ld.imprimirL();


        ld.swap(2,0);
        ld.imprimirL();
    }

}
