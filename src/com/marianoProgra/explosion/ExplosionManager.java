package com.marianoProgra.explosion;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;

import java.awt.Graphics2D;

/**
 * Clase para el control de explosiones, su precencia no afecta el curso normal edl juego
 */
public class ExplosionManager {

	private static ListaSimple<ExplosionType> explosions = new ListaSimple<ExplosionType>();
	
	public void draw (Graphics2D g) {
		for (int i = 0; i < explosions.getCapacidad(); i++) {
			explosions.getData(i).draw(g);
		}
	}
	
	public void update(double delta) {
		for (int i = 0; i < explosions.getCapacidad(); i++) {
			explosions.getData(i).update(delta);
			if(explosions.getData(i).destory()) {
				explosions.eliminar(i);
			}
		}
	}
	
	public static void createPixelExplosion(double xPos, double yPos) {
		ExplosionType et = new PixelExplosion(xPos, yPos);
		explosions.agregar(et);
	}
}
