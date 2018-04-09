package com.marianoProgra.player_bullets;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

import com.marianoProgra.Display.Display;

public class MachineGun extends PlayerWeaponType{

	private Rectangle bullet;
	private final double speed = 2.0d;
	
	public MachineGun(double xPos, double yPos, int width, int height) {
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.setWidth(width);
		this.setHeight(height);
		
		this.bullet = new Rectangle((int)getxPos(),(int) getyPos(), getWidth(), getHeight());
	}
	
		@Override
	public void draw(Graphics2D g) {
		if(bullet==null)
			return;
		g.setColor(Color.YELLOW);
		g.fill(bullet);
	}

	@Override
	public void update(double delta) {
		if(bullet==null)
			return;
		this.setyPos(getyPos() - (delta*speed));
		bullet.y = (int)this.getyPos();
		isOutOfBounds();
		
	}

	@Override
	public boolean colisionRect(Rectangle rect) {
		if(this.bullet == null)
			return false;
		if(bullet.intersects(rect)) {
			this.bullet = null;
			return true;
		}
		return false;
			
	}

	@Override
	public boolean colisionPoly(Polygon poly) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean destroy() {
		if(bullet==null)
			return true;
		return false;
	}

	@Override
	protected void isOutOfBounds() {
		if(bullet==null)
			return;
		if(bullet.y<0 || bullet.y > Display.getHEIGHT() || bullet.x < 0 || bullet.x > Display.getWIDTH()) {
			bullet = null;
			
		}
			
	}

}
