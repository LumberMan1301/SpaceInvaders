package com.marianoProgra.player_bullets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.marianoProgra.display.Display;

public class MachineGun extends PlayerWeaponType{

	private Rectangle bullet;
	private final double speed = 3.5d;
	
	public MachineGun(double xPos, double yPos, int width,int height){
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setWidth(width);
		this.setHeight(height);
		
		this.bullet = new Rectangle((int) getxPos(),(int) getyPos(), getWidth(), getHeight());
	}
	
	@Override
	public void draw(Graphics2D g) {
		if(bullet == null)
			return;
		
		g.setColor(Color.GREEN);
		g.fill(bullet);
	}

	@Override
	public void update(double delta) {
		if(bullet == null)
			return;
		
		this.setyPos(getyPos() - (delta * speed));
		bullet.y = (int) this.getyPos();

		isOutofBounds();
	}

	@Override
	public boolean collisionRect(Rectangle rect) {
		if(this.bullet == null)
			return false;
		
		if(bullet.intersects(rect)){
			this.bullet = null;
			return true;
		}
		
		return false;
	}



	@Override
	public boolean destory() {
		if(bullet == null)
			return true;
		
		return false;
	}



	@Override
	protected void isOutofBounds() {
		if(this.bullet == null)
			return;
		
		if(bullet.y < 0 || bullet.y > Display.getHEIGHT() || bullet.x < 0 || bullet.x > Display.getWIDTH()){
			bullet = null;
		}
	}

}
