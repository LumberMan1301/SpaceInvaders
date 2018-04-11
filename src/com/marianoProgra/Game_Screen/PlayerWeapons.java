package com.marianoProgra.Game_Screen;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.explosion.ExplosionManager;
import com.marianoProgra.explosion.ExplosionType;
import com.marianoProgra.player_bullets.MachineGun;
import com.marianoProgra.player_bullets.PlayerWeaponType;
import com.marianoProgra.timer.Timer;

public class PlayerWeapons {
	
	private Timer timer;
	
	private ExplosionManager explosionManager;
	
	public Lista<PlayerWeaponType> weapons = new Lista<PlayerWeaponType>();
	
	public PlayerWeapons() {
		explosionManager = new ExplosionManager();
		timer = new Timer();
	}
	
	public void draw(Graphics2D g) {
		explosionManager.draw(g);
		for(int i=0; i < weapons.size(); i++) {
			weapons.get(i).draw(g);
		}
	}
	public void update(double delta) {
		explosionManager.update(delta);
		for(int i=0; i < weapons.size(); i++) {
			weapons.get(i).update(delta);
			if(weapons.get(i).destroy()) {
				weapons.eliminar(i);
				ExplosionManager.createPixelExplosion( weapons.get(i).getxPos(), weapons.get(i).getyPos());
			} 
		}
	}
	
	public void shootBullet(double xPos, double yPos, int width, int height) {
		if(timer.timerEvent(200))
			weapons.agregar(new MachineGun(xPos+22, yPos+15, width, height));
	}

}
