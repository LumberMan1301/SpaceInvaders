package com.marianoProgra.enemy_type;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.marianoProgra.Display.Display;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.sprite.SpriteAnimation;

public class EnemyTypeBasic implements EnemyType{
	
	private double speed = 0.5d;
	
	private Rectangle rect;	
	private SpriteAnimation enemySprite;
	
	
	
	public EnemyTypeBasic(double xPos, double yPos, int width, int heigtht, String ImPath) {
		 enemySprite = new SpriteAnimation(xPos, yPos,width, heigtht, 200); 
		 try {
				URL url = this.getClass().getResource(ImPath);
				BufferedImage pSprite = ImageIO.read(url);
				for(int i= 0; i<2; i++) {
					enemySprite.addSprite(pSprite, 0 + (i*44), 0 , 44,32);
				}
			}catch (IOException e) {}
		 
		 this.setRect(new Rectangle((int)enemySprite.getxPos(),(int)enemySprite.getyPos(), width, heigtht));
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
	public void update(double delta, Player player) {
		enemySprite.update(delta);
		
		enemySprite.setxPos(enemySprite.getxPos()-(delta*speed));
		this.getRect().x = (int)enemySprite.getxPos();
	}

	@Override
	public void changeDirection(double delta) {
		speed *= -1.005d;
		
		enemySprite.setxPos(enemySprite.getxPos()-(delta * speed));
		this.getRect().x = (int) enemySprite.getxPos();
		
		enemySprite.setyPos(enemySprite.getyPos()+(delta * 20));
		this.getRect().y = (int)enemySprite.getyPos();
	}

	@Override
	public boolean deathScene() {
		return false;
	}

	@Override
	public boolean collide(int i, Player player, Lista<EnemyType> enemys) {
		for(int w=0; w< player.getPlayerWeapons().weapons.size();w++) {
			if(enemys != null && player.getPlayerWeapons().weapons.get(w).colisionRect(((EnemyTypeBasic)enemys.get(i)).getRect()))
				return true;
		}
		
		return false;
	}

	@Override
	public boolean isOutOfBounds() {
		if(rect.x > 10 && rect.x < Display.getWIDTH()-rect.width-20)
			return false;
		return true;
	}

}
