package com.marianoProgra.Game_Screen;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.player_bullets.MachineGun;
import com.marianoProgra.player_bullets.PlayerWeaponType;
import com.marianoProgra.timer.Timer;

public class PlayerWeapons {
	
	private Timer timer;
	
	public Lista<PlayerWeaponType> weapons = new Lista<PlayerWeaponType>();
	
	public PlayerWeapons() {
		timer = new Timer();
	}
	
	public void draw(Graphics2D g) {
		for(int i=0; i < weapons.size(); i++) {
			weapons.get(i).draw(g);
		}
	}
	public void update(double delta) {
		for(int i=0; i < weapons.size(); i++) {
			weapons.get(i).update(delta);
			if(weapons.get(i).destroy()) {
				weapons.eliminar(i);
			}
		}
	}
	
	public void shootBullet(double xPos, double yPos, int width, int height) {
		if(timer.timerEvent(200))
			weapons.agregar(new MachineGun(xPos+22, yPos+15, width, height));
	}

}
