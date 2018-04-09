package com.marianoProgra.enemy_type;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.sprite.SpriteAnimation;

public class EnemyTypeBasic implements EnemyType{
	
	private Rectangle rect;	
	private SpriteAnimation enemySprite;
	
	private double xPos, yPos;
	private int width, height;
	private String ImPath;
	
	public EnemyTypeBasic(double xPos, double yPos, int width, int heigtht, String ImPath) {
		 enemySprite = new SpriteAnimation(xPos, yPos,width, heigtht, 300); 
		 try {
				URL url = this.getClass().getResource(ImPath);
				BufferedImage eSprite = ImageIO.read(url);
				for(int i= 0; i<2; i++) {
					enemySprite.addSprite(eSprite, 0 + (i*88), 0 , 88,64 );
				}
			}catch (IOException e) {}
		 
		 this.setRect(new Rectangle((int)xPos,(int)yPos, width, heigtht));
		 enemySprite.setLoop(true);
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	@Override
	public void draw(Graphics2D g) {
		enemySprite.draw(g);
	}

	@Override
	public void update(double delta) {
		enemySprite.update(delta);
	}

	@Override
	public void changeDirection(double delta) {

	}

	@Override
	public boolean deathScene() {
		return false;
	}

	@Override
	public boolean collide(int i, Player player, Lista<EnemyType> enemy) {
		return false;
	}

	@Override
	public boolean isOutOfBounds() {
		return false;
	}

}
