package com.marianoProgra.EstructurasDeDatosLineales.Listas;

public class Main {
	public static void main(String [] args) {
		Lista l = new Lista();
		l.agregar(2);
		l.agregar(4);
		l.imprimirL();
		l.eliminar(1);
		l.imprimirL();
		l.eliminar(0);
		l.imprimirL();
		System.out.print(l.estaVacia());
		if(l.estaVacia())
			System.out.print("si");
		
		
	}
}
