package com.marianoProgra.Game_Screen;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.marianoProgra.Display.Display;

public class Player implements KeyListener{

	private final double speed = 3.0d;
	
	private BufferedImage pSprite;
	private Rectangle rect;
	private double xPos, yPos;
	private int width, height;
	
	
	private boolean left=false, right = false, shoot = false;
	
	private PlayerWeapons playerWeapons;	
	
	public Player() {
		this.xPos = (Display.getWIDTH()/2)-40;
		this.yPos = Display.getHEIGHT()-60;
		this.height = 50;
		this.width = 50;
		
		rect = new Rectangle((int)xPos, (int)yPos, width, height);
		
		try {
			URL url = this.getClass().getResource("/com/marianoProgra/imagenes/Player.png");
			pSprite = ImageIO.read(url);
			
		}catch (IOException e) {}
		
		playerWeapons = new PlayerWeapons();
	}
	 
	public void draw(Graphics2D g) {
		g.drawImage(pSprite, (int)xPos, (int)yPos, width, height, null);
		playerWeapons.draw(g);
	}
	
	public void update (double delta) {
		if(right && !left&& xPos<Display.getWIDTH()-width-5) {
			xPos += speed * delta;
			rect.x=(int)xPos;
		}if(!right && left && xPos>10) {
			xPos -= speed * delta;
			rect.x=(int)xPos;
		}
		playerWeapons.update(delta);
		if(shoot) {
			playerWeapons.shootBullet(xPos, yPos, 5, 5);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			right = true;
		}else if(key == KeyEvent.VK_LEFT){
			left = true;
		}
		if (key == KeyEvent.VK_SPACE) {
			shoot = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			right = false;
		}else if(key == KeyEvent.VK_LEFT){
			left = false;
		}
		if (key == KeyEvent.VK_SPACE) {
			shoot = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
