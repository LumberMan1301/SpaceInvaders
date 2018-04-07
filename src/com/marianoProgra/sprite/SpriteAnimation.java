package com.marianoProgra.sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.marianoPrograma.EstructurasDeDatosLineales.Listas.Lista;

public class SpriteAnimation {
	
	
	private Lista<BufferedImage> sprites = new Lista<BufferedImage>();
	
	private boolean loop = false;
	private boolean play = false;
	private boolean destroyAfterAnimation = false;
	

	private int animationSpeed;
	private double xPos, yPos;
	
	public SpriteAnimation(double xPos, double yPos, int animationSpeed) {
		this.animationSpeed = animationSpeed;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void draw(Graphics2D g) {
		
	}
	public void update(double delta) {
		
	}
	
	public void addSprite(BufferedImage spriteMap, int xPos, int yPos, int width, int height) {
		sprites.agregar(spriteMap.get);
	}
	
	public void PlayerAnimation(boolean play, boolean destroyAfterAnimation) {
		this.play = play;
		this.destroyAfterAnimation = destroyAfterAnimation;
	}
	
	
}
