package com.marianoProgra.State;

import java.awt.Canvas;
import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.menu_screen.MenuScreen;

/**
 * Clase para trabajr en Canvas
 */
public class StateMachine {
	/**
	 * atributos de la clase
	 */
	private ListaSimple<SuperStateMachine> states = new ListaSimple<SuperStateMachine>();
	private Canvas canvas;
	private byte selectState = 0;

	/**
	 * constructor de la clase
	 * @param canvas
	 */
	public StateMachine(Canvas canvas){
		SuperStateMachine game = new GameScreen(this);
		SuperStateMachine menu = new MenuScreen(this);
		states.agregar(menu);
		states.agregar(game);
		
		this.canvas = canvas;
	}

	/**
	 * metodo para dibujar
	 * @param g
	 */
	public void draw(Graphics2D g){
		states.getData(selectState).draw(g);
	}

	/**
	 * metodo para actualñizar
	 * @param delta
	 */
	public void update(double delta){
		states.getData(selectState).update(delta);
	}

	/**
	 * metoodo que asigna en estate
	 * @param i
	 */
	public void setState(byte i){
		for(int r = 0; r < canvas.getKeyListeners().length; r++)
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		selectState = i;
		states.getData(selectState).init(canvas);
	}


}
