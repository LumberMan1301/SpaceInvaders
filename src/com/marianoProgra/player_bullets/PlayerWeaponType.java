package com.marianoProgra.player_bullets;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * Clase que permite crear el arma del jugador
 */
public abstract class PlayerWeaponType {
	/**
	 * atributos de la clase
	 */
	protected double xPos, yPos;
	protected int width, height;

	/**
	 * metodo para dibujar
	 * @param g
	 */
	public abstract void draw(Graphics2D g);

	/**
	 * metodo para actualizar
	 * @param delta
	 */
	public abstract void update(double delta);

	/**
	 * metodo para saber si se destruyo
	 * @return
	 */
	public abstract boolean destory();

	/**
	 * metodo para saber si esta fuera de rango
	 */
	protected abstract void isOutofBounds();

	public abstract boolean collisionRect(Rectangle rect);

	/**
	 * Getters Y Setters
	 *
	 */
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
	
	
}
