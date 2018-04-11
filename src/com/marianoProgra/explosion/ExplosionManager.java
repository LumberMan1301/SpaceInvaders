package com.marianoProgra.explosion;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;

public class ExplosionManager {
	private static Lista<ExplosionType> explosion = new Lista <ExplosionType>();
	
	public ExplosionManager() {
		
	}
	public void draw(Graphics2D g) {
		for(int i =0; i < explosion.size(); i++) {
			explosion.get(i).draw(g);
		}
	}
	public void update(double delta) {
for(int i =0; i < explosion.size(); i++) {
			explosion.get(i).update(delta);
			if(explosion.get(i).destroy()){
				explosion.eliminar(i);
			}
		}
	}
	public static void createPixelExplosion(double xPos, double yPos) {
		ExplosionType et = new PixelExplosion(xPos, yPos);
		explosion.agregar(et);
	}
	
}
