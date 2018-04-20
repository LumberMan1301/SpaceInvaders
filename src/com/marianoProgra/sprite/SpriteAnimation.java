package com.marianoProgra.sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;
import com.marianoProgra.timer.Timer;

/**
 * Clase para realizar las diferentes animaciones
 */
public class SpriteAnimation {
	/**
	 * Atributos de la clase
	 */
	private ListaSimple<BufferedImage> sprites = new ListaSimple<BufferedImage>();
	private byte currentSprite;

	private boolean loop = false;
	private boolean play = false;
	private boolean destoryAfterAnim = false;

	private Timer timer;
	private int animationSpeed;
	private double xPos, yPos;
	private int width, height;
	private int limit;

	/**
	 * Constructor de la clase
	 * @param xPos
	 * @param yPos
	 * @param rows
	 * @param columns
	 * @param animationSpeed
	 * @param imgPath
	 */
	public SpriteAnimation(double xPos, double yPos, int rows, int columns, int animationSpeed, String imgPath) {
		this.animationSpeed = animationSpeed;
		this.xPos = xPos;
		this.yPos = yPos;
		
		try{
			URL url = this.getClass().getResource(imgPath);
			BufferedImage pSprite = ImageIO.read(url);
			int spriteWidth = pSprite.getWidth() / columns;
			int spriteHeight = pSprite.getHeight() / rows;
			for(int y = 0; y < rows; y++) {
				for(int x = 0; x < columns; x++){
					addSprite(pSprite
							, 0 + (x * spriteWidth)
							, 0 + (y * spriteHeight)
							, spriteWidth
							, spriteHeight);
				}
			}
					
			
		}catch(IOException e){};

		timer = new Timer();
		limit = sprites.getCapacidad() - 1;
	}

	/**
	 * metodo para dibujar el objeto
	 * @param g
	 */
	public void draw(Graphics2D g) {
		if (isSpriteAnimDestroyed())
			return;
		
		g.drawImage(sprites.getData(currentSprite), (int) getxPos(), (int) getyPos(), width, height, null);
	}

	/**
	 * metoodo para actualizar el objeto
	 * @param delta
	 */
	public void update(double delta) {
		if (isSpriteAnimDestroyed())
			return;

		if (loop && !play)
			loopAnimation();
		if (play && !loop)
			playAnimation();
	}

	/**
	 * metodo para rebobinar la animacion
	 */
	private void loopAnimation() {
		if (timer.isTimerReady(animationSpeed) && currentSprite == limit) {
			currentSprite = 0;
			timer.resetTimer();
		}else if (timer.timerEvent(animationSpeed) && currentSprite != limit) {
			currentSprite++;
		} 
	}

	/**
	 * metodo para iniciar la animacion
	 */
	private void playAnimation() {
		if (timer.isTimerReady(animationSpeed) && currentSprite != limit && !isDestoryAfterAnim()) {
			play = false;
			currentSprite = 0;
		} else if (timer.isTimerReady(animationSpeed) && currentSprite == limit && isDestoryAfterAnim()) {
			sprites = null;
		}else if (timer.timerEvent(animationSpeed) && currentSprite != limit) {
			currentSprite++;
		}
	}
	
	/*
	Getters and Setters
	 */



	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public boolean isSpriteAnimDestroyed() {
		if (sprites == null)
			return true;

		return false;
	}

	public void addSprite(BufferedImage spriteMap, int xPos, int yPos,
			int width, int height) {
		sprites.agregar(spriteMap.getSubimage(xPos, yPos, width, height));
	}

	public void setPlay(boolean play, boolean destoryAfterAnim) {
		if(loop) {
			loop = false;
		}
		
		this.play = play;
		this.setDestoryAfterAnim(destoryAfterAnim);
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public boolean isDestoryAfterAnim() {
		return destoryAfterAnim;
	}

	public void setDestoryAfterAnim(boolean destoryAfterAnim) {
		this.destoryAfterAnim = destoryAfterAnim;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public void setAnimationSpeed(int animationSpeed) {
		this.animationSpeed = animationSpeed;
	}



	public void setLimit(int limit) {
		if(limit > 0) {
			this.limit = limit - 1;
		} else {
			this.limit = limit;
		}
	}
	
	public void resetLimit() {
		limit = sprites.getCapacidad() - 1;
	}

	public boolean isPlay() {
		return play;
	}
}
