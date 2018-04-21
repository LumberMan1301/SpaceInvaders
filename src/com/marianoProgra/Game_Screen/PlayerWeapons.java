package com.marianoProgra.Game_Screen;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.explosion.ExplosionManager;
import com.marianoProgra.player_bullets.MachineGun;
import com.marianoProgra.player_bullets.PlayerWeaponType;
import com.marianoProgra.sound.Sound;
import com.marianoProgra.timer.Timer;

/**
 * Clase que controla las balas del jugador
 */
public class PlayerWeapons {
	/**
	 * Atributos de la Clase
	 */
	private Timer timer;
	private ExplosionManager explosionManager;
	public Lista<PlayerWeaponType> weapons = new Lista<>();
	private Sound shootSound;

	/**
	 * Constructor de la clase
	 */
	public PlayerWeapons(){
		explosionManager = new ExplosionManager();
		timer = new Timer();
		shootSound = new Sound("/com/marianoProgra/sounds/shoot.wav");
	}

	/**
	 * metodo para dibujas las balas
	 * @param g
	 */
	public void draw(Graphics2D g){
		
		explosionManager.draw(g);
		for(int i = 0; i < weapons.capacidad(); i++){
			weapons.getData(i).draw(g);
		}
	}

	/**
	 * metodo para actualiazr las balas
	 * @param delta
	 */
	public void update(double delta){
		
		explosionManager.update(delta);
		for(int i = 0; i < weapons.capacidad(); i++){
			weapons.getData(i).update(delta);
			if(weapons.getData(i).destory()) {
				ExplosionManager.createPixelExplosion(weapons.getData(i).getxPos(), weapons.getData(i).getyPos());
				weapons.eliminar(i);
			}
		}
	}

	/**
	 * metodo para controlar la velocidad de las balas
	 * @param xPos
	 * @param yPos
	 * @param width
	 * @param height
	 */
	public void shootBullet(double xPos, double yPos, int width, int height){
		if(timer.timerEvent(100)) {
			if (shootSound.isPlaying()) {
				shootSound.stop();
			}
			shootSound.play();
			weapons.agregar(new MachineGun(xPos + 22, yPos + 15, width, height));
		}
	}

	/**
	 * metodo para reiniciar el PlayerWeapons
	 */
	public void reset() {
		weapons.vaciar();
	}

	public Lista<PlayerWeaponType> getWeapons() {
		return weapons;
	}
}
