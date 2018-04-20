package com.marianoProgra.hileras;

import java.awt.Graphics2D;

/**
 * Interface para la creacion de Hileras
 */
public interface SuperLevel {

	String nombre = null;
	/**
	 * metodo para dibujar las hileras
	 * @param g
	 */
	void draw(Graphics2D g);

	/**
	 * metodo par aactuaizar las hileras
	 * @param delta
	 */
	void update(double delta);

	/**
	 * metodo para saber si hubo cambio de direccion
	 * @param delta
	 */
	void hasDirectionChange(double delta);

	/**
	 * metodo para cambiar de direccion
	 * @param delta
	 */
	void changeDurectionAllEnemys(double delta);

	/**
	 * metodo para saber si es el fin del juego
	 * @return
	 */
	boolean isGameOver();

	/**
	 * netodo para saber si el nivel esta completo
	 * @return
	 */
	boolean isComplete();

	/**
	 * metodo para reiniciar
	 */
	void reset();

	String getNombre();
}
