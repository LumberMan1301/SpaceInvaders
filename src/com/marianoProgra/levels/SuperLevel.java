package com.marianoProgra.levels;

import java.awt.Graphics2D;

public interface SuperLevel {
	
	public void draw(Graphics2D g);
	public void update(double delta);
	public void hasDirectionChange(double delta);
	public void changeDirectionAllEnemies(double delta);
	
	boolean isGameOver();
	
	void destroy();
	void reset();	

}
