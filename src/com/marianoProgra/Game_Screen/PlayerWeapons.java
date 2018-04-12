package com.marianoProgra.game_screen;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.marianoProgra.explosion.ExplosionManager;
import com.marianoProgra.player_bullets.MachineGun;
import com.marianoProgra.player_bullets.PlayerWeaponType;
import com.marianoProgra.sound.Sound;
import com.marianoProgra.timer.Timer;

public class PlayerWeapons {

	private Timer timer;
	private ExplosionManager explosionManager;
	public ArrayList<PlayerWeaponType> weapons = new ArrayList<PlayerWeaponType>();
	private Sound shootSound;
	
	public PlayerWeapons(){
		explosionManager = new ExplosionManager();
		timer = new Timer();
		shootSound = new Sound("/com/marianoProgra/sounds/shoot.wav");
	}
	
	public void draw(Graphics2D g){
		
		explosionManager.draw(g);
		for(int i = 0; i < weapons.size(); i++){
			weapons.get(i).draw(g);
		}
	}
	
	public void update(double delta){
		
		explosionManager.update(delta);
		for(int i = 0; i < weapons.size(); i++){
			weapons.get(i).update(delta);
			if(weapons.get(i).destory()) {
				ExplosionManager.createPixelExplosion(weapons.get(i).getxPos(), weapons.get(i).getyPos());
				weapons.remove(i);
			}
		}
	}
	
	public void shootBullet(double xPos, double yPos, int width, int height){
		if(timer.timerEvent(200)) {
			if (shootSound.isPlaying()) {
				shootSound.stop();
			}
			shootSound.play();
			weapons.add(new MachineGun(xPos + 22, yPos + 15, width, height));
		}
	}

	public void reset() {
		weapons.clear();
	}
}
