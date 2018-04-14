package com.marianoProgra.State;

import java.awt.Canvas;
import java.awt.Graphics2D;

/**
 * Calse para crear el contenedor
 */
public abstract class SuperStateMachine {

	private StateMachine stateMachine;

	/**
	 * Constructor de la clase
	 * @param stateMachine
	 */
	public SuperStateMachine(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	/**
	 * metodo para actualizar
	 * @param delta
	 */
	public abstract void update(double delta);

	/**
	 * metodo para dibujar
	 * @param g
	 */
	public abstract void draw(Graphics2D g);

	/**
	 * metodo para iniciar
	 * @param canvas
	 */
	public abstract void init(Canvas canvas);

	/**
	 * metodo que obtinene el StateMachine
	 * @return
	 */
	public StateMachine getStateMachine() {
		return stateMachine;
	}
}
