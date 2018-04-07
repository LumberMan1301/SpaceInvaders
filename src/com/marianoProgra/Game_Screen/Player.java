package com.marianoProgra.Game_Screen;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player implements KeyListener{

	
	private BufferedImage pSprite;
	
	private Rectangle rect;
	
	private double xPos, yPos;
	private int width, height;
	
	
	
	
	public Player(double xPos, double yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		
		rect = new Rectangle((int)xPos, (int)yPos, width, height);
		
		try {
			URL url = this.getClass().getResource("/com/marianoProgra/imagenes/Player.png");
			pSprite = ImageIO.read(url);
		}catch (IOException e) {}
		
	}
	 
	public void draw(Graphics2D g) {
		g.drawImage(pSprite, (int)xPos, (int)yPos, width, height, null);
		
	}
	
	public void update (double delta) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
