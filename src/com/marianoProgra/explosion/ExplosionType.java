package com.marianoProgra.explosion;

import java.awt.Graphics2D;

public interface ExplosionType {
	void draw(Graphics2D g);
	void update(double delta);
	boolean destory();
}
