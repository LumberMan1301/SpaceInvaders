package com.marianoProgra.enemy_types;

import java.awt.Graphics2D;
import java.awt.Rectangle;


<<<<<<< HEAD
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaCircular;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;
=======
import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
>>>>>>> parent of 47cbb82... Trabajando en la Clase D
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaDoble;
import com.marianoProgra.display.Display;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.Game_Screen.Player;
<<<<<<< HEAD
=======
import com.marianoProgra.levels.ClaseB;
>>>>>>> parent of 47cbb82... Trabajando en la Clase D
import com.marianoProgra.sound.Sound;
import com.marianoProgra.sprite.SpriteAnimation;

public class Subdito extends EnemyType{

	/**
	 * Atributos de la clase
	 */
	private double speed;//velocidad del enemigo
	private static int vida;// vida del enemigo
	private Rectangle rect;// variable que nos permite comparar posiciones
	private SpriteAnimation enemySprite; // variable para almacenar imagenes
	private Sound explosionSound;//Sonido de la explosion
	
	public Subdito(double xPos, double yPos, int rows, int columns, int vida, double speed){

		this.vida = vida;
		this.speed = speed;
		
		enemySprite = new SpriteAnimation(xPos, yPos, rows, columns, 300, "/com/marianoProgra/images/Subdito.png");
		enemySprite.setWidth(30);
		enemySprite.setHeight(30);
		enemySprite.setLimit(2);

		this.setRect(new Rectangle((int) enemySprite.getxPos(), (int) enemySprite.getyPos(), enemySprite.getWidth(), enemySprite.getHeight()));
		enemySprite.setLoop(true);



		explosionSound = new Sound("/com/marianoProgra/sounds/explosion.wav");
	}
	@Override
	public void draw(Graphics2D g) {
		enemySprite.draw(g);
	}
	@Override
	public void update(double delta, Player player) {
		enemySprite.update(delta);
		
		enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
		

	}
	@Override
	public void changeDirection(double delta) {
		speed *= -1.15d;
		enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
		
		enemySprite.setyPos(enemySprite.getyPos() + (delta * 25));
		this.getRect().y = (int) enemySprite.getyPos();
	}
	@Override
	public boolean deathScene() {
		if(!enemySprite.isPlay())
			return false;
		
		if(enemySprite.isSpriteAnimDestroyed()) {
			if (!explosionSound.isPlaying()) {
				explosionSound.play();
			}
			return true;
		}
		
		return false;
	}
	@Override
	public boolean collide(int i, Player player, Lista<EnemyType> enemys) {
		if(enemySprite.isPlay()) {
			if(enemys.getData(i).deathScene()) {
				enemys.eliminar(i);
			}
			return false;
		}
<<<<<<< HEAD
		for(int w = 0; w < player.getPlayerWeapons().getWeapons().getCapacidad(); w++) {
				if (enemys != null && player.getPlayerWeapons().getWeapons().getData(w).collisionRect(((Subdito) enemys.getData(i)).getRect())) {
=======
		for(int w = 0; w < player.playerWeapons.weapons.capacidad(); w++) {
				if (enemys != null && player.playerWeapons.weapons.getData(w).collisionRect(((Subdito) enemys.getData(i)).getRect())) {
>>>>>>> parent of 47cbb82... Trabajando en la Clase D
					this.vida--;
				}if(vida==0){
					enemySprite.resetLimit();
					enemySprite.setAnimationSpeed(120);
					enemySprite.setPlay(true, true);
					GameScreen.aumentarSCORE(5);
					return true;
			}
		}
		return false;
	}
	@Override
	public boolean collide(int i, Player player, ListaDoble<EnemyType> enemys) {
		if(enemySprite.isPlay()) {
			if(enemys.getDato(i).deathScene()) {
				enemys.eliminarPos(i);
			}
			return false;
		}
<<<<<<< HEAD
		for(int w = 0; w < player.getPlayerWeapons().getWeapons().getCapacidad(); w++) {
			if (enemys != null && player.getPlayerWeapons().getWeapons().getData(w).collisionRect(((Subdito) enemys.obtenerDato(i)).getRect())) {
=======
		for(int w = 0; w < player.playerWeapons.weapons.capacidad(); w++) {
			if (enemys != null && player.playerWeapons.weapons.getData(w).collisionRect(((Subdito) enemys.getDato(i)).getRect())) {
>>>>>>> parent of 47cbb82... Trabajando en la Clase D
				this.vida--;
			}if(vida==0){
				enemySprite.resetLimit();
				enemySprite.setAnimationSpeed(120);
				enemySprite.setPlay(true, true);
				GameScreen.aumentarSCORE(8);
				ClaseB.setCant(ClaseB.getCant()-1);
				return true;
			}
		}
		return false;
	}

	/**
	 * metodo para saber si hubo una colision con el Jefe
	 *
	 * @param i
	 * @param player
	 * @param enemys
	 * @return
	 */
	@Override
	public boolean collide(int i, Player player, ListaCircular<EnemyType> enemys) {
		if(enemySprite.isPlay()) {
			if(enemys.getData(i).deathScene()) {
				enemys.eliminarPos(i);
			}
			return false;
		}
		for(int w = 0; w < player.getPlayerWeapons().getWeapons().getCapacidad(); w++) {
			if (enemys != null && player.getPlayerWeapons().getWeapons().getData(w).collisionRect(((Subdito) enemys.getData(i)).getRect())) {
				this.vida--;
			}if(vida==0){
				enemySprite.resetLimit();
				enemySprite.setAnimationSpeed(120);
				enemySprite.setPlay(true, true);
				GameScreen.aumentarSCORE(8);
				return true;
			}
		}return false;
}

	@Override
	public boolean isOutOfBounds() {
		if(rect.x > 0 && rect.x < Display.getWIDTH() - rect.width)
			return false;
		return true;
	}
	@Override
	public boolean passPlayer() {
		if(rect.y > Display.getHEIGHT()-80)
			return true;
		return false;
	}

	public static int getVida() {
		return vida;
	}

	//###########Getters y Setters#############################################
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
