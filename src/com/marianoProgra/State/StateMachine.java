package com.marianoProgra.State;

import java.awt.Canvas;
import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.menu_screen.MenuScreen;

public class StateMachine {

	private Lista<SuperStateMachine> states = new Lista<SuperStateMachine>();
	private Canvas canvas;
	private byte selectState = 0;
	
	public StateMachine(Canvas canvas){
		SuperStateMachine game = new GameScreen(this);
		SuperStateMachine menu = new MenuScreen(this);
		states.agregar(menu);
		states.agregar(game);
		
		this.canvas = canvas;
	}
	
	public void draw(Graphics2D g){
		states.getDato(selectState).draw(g);
	}
	
	public void update(double delta){
		states.getDato(selectState).update(delta);
	}
	
	public void setState(byte i){
		for(int r = 0; r < canvas.getKeyListeners().length; r++)
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		selectState = i;
		states.getDato(selectState).init(canvas);
	}

	public byte getStates() {
		return selectState;
	}
}
