package com.marianoProgra.levels;

import java.awt.Graphics2D;

public interface SuperLevel {

	void draw(Graphics2D g);
	void update(double delta);
	void hasDirectionChange(double delta);
	void changeDurectionAllEnemys(double delta);
	
	boolean isGameOver();
	boolean isComplete();
	
	void destory();
	void reset();
}
