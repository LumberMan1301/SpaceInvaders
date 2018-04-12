package com.marianoProgra.enemy_types;

import java.awt.Graphics2D;
import java.awt.Rectangle;


import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.display.Display;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.sound.Sound;
import com.marianoProgra.sprite.SpriteAnimation;

public class EnemyTypeBasic extends EnemyType{

	private double speed = 2.0d;
	
	private Rectangle rect;
	private SpriteAnimation enemySprite;
	

	
	private Sound explosionSound;
	
	public EnemyTypeBasic(double xPos, double yPos, int rows, int columns){

		
		enemySprite = new SpriteAnimation(xPos, yPos, rows, columns, 300, "/com/marianoProgra/images/Invaders.png");
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
			if(enemys.get(i).deathScene()) {
				enemys.eliminar(i);
			}
			return false;
		}

		for(int w = 0; w < player.playerWeapons.weapons.size(); w++) {
			if(enemys != null && player.playerWeapons.weapons.get(w).collisionRect(((EnemyTypeBasic) enemys.get(i)).getRect())) {
				enemySprite.resetLimit();
				enemySprite.setAnimationSpeed(120);
				enemySprite.setPlay(true, true);
				GameScreen.SCORE += 8;
				return true;
			}
		}

		return false;
	}



	@Override
	public boolean isOutOfBounds() {
		if(rect.x > 0 && rect.x < Display.getWIDTH() - rect.width)
			return false;
		return true;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

}
