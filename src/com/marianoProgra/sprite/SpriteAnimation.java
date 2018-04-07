package com.marianoProgra.sprite;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.marianoProgra.timer.Timer;
import com.marianoPrograma.EstructurasDeDatosLineales.Listas.Lista;

public class SpriteAnimation {
	
	
	private Lista<BufferedImage> sprites = new Lista<BufferedImage>();
	private byte currentSprite;
	
	private boolean loop = false;
	private boolean play = false;
	private boolean destroyAfterAnimation = false;
	
	private Timer timer;

	private int animationSpeed;
	private double xPos, yPos;
	
	public SpriteAnimation(double xPos, double yPos, int animationSpeed) {
		this.animationSpeed = animationSpeed;
		this.xPos = xPos;
		this.yPos = yPos;
		
		timer = new Timer();
	}
	
	public void draw(Graphics2D g) {
		if(isSpriteDestroyed())
			return;
		g.drawImage(sprites.get(currentSprite),(int)getxPos(),(int)getyPos(), null);
	}
	
	
	public void update(double delta) {
		if(isDestroyAfterAnimation())
			return;
		if(loop && !play)
			loopAnimation();
		if(play && !loop)
			playAnimation();
	}
	
	public void stopAnimation() {
		loop = false;
		play = false;
		
	}
	
	public void resetSprite() {
		loop = false;
		play = false;
		currentSprite = 0;
	}
	
	
	private void loopAnimation() {
		if(timer.isTimerReady(animationSpeed)&&currentSprite == sprites.getCapacidad()-1){
			currentSprite = 0;
			timer.resetTimer();
		}else if(timer.timerEvent(animationSpeed)&&currentSprite != sprites.getCapacidad()-1) {
			currentSprite ++;
		} 
	}
	
	private void playAnimation() {
		if(timer.timerEvent(animationSpeed)&&currentSprite != sprites.getCapacidad()-1 && !isDestroyAfterAnimation()) {
			play = false;
			currentSprite = 0;
		}else if(timer.timerEvent(animationSpeed)&&currentSprite == sprites.getCapacidad()-1 && isDestroyAfterAnimation()){
			sprites.nul();
		}else if (timer.timerEvent(animationSpeed)&&currentSprite == sprites.getCapacidad()-1) {
			currentSprite++;
		}
	}
	
	public boolean isSpriteDestroyed() {
		if (sprites == null)
			return true;
		return false;
	}
	
	public void addSprite(BufferedImage spriteMap, int xPos, int yPos, int width, int height) {
		sprites.agregar(spriteMap.getSubimage(xPos, yPos, width, height));
	}
	
	public void PlayerAnimation(boolean play, boolean destroyAfterAnimation) {
		this.play = play;
		this.destroyAfterAnimation = destroyAfterAnimation;
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

	public boolean isDestroyAfterAnimation() {
		return destroyAfterAnimation;
	}

	public void setDestroyAfterAnimation(boolean destroyAfterAnimation) {
		this.destroyAfterAnimation = destroyAfterAnimation;
	}

	public byte getCurrentSprite() {
		return currentSprite;
	}

	public void setCurrentSprite(byte currentSprite) {
		this.currentSprite = currentSprite;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	
	
	
}
