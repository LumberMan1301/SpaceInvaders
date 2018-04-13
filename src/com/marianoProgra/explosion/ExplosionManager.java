package com.marianoProgra.explosion;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;

import java.awt.Graphics2D;

public class ExplosionManager {

	private static Lista<ExplosionType> explosions = new Lista<ExplosionType>();
	
	public void draw (Graphics2D g) {
		for (int i = 0; i < explosions.capacidad(); i++) {
			explosions.getDato(i).draw(g);
		}
	}
	
	public void update(double delta) {
		for (int i = 0; i < explosions.capacidad(); i++) {
			explosions.getDato(i).update(delta);
			if(explosions.getDato(i).destory()) {
				explosions.eliminar(i);
			}
		}
	}
	
	public static void createPixelExplosion(double xPos, double yPos) {
		ExplosionType et = new PixelExplosion(xPos, yPos);
		explosions.agregar(et);
	}
}
