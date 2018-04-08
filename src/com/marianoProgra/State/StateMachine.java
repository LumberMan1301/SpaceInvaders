package com.marianoProgra.State;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;

public class StateMachine {
	
	private Lista<SuperStateMachine> states = new Lista <SuperStateMachine>();
	
	private Canvas canvas;
	private byte selectState = 0;
	
	
	public StateMachine(Canvas canvas) {
		this.canvas = canvas;
		SuperStateMachine game = new GameScreen();
		states.agregar(game);
	
		
	}
	public void draw(Graphics2D g) {
		states.get(selectState).draw(g);
	}
	
	public void update(double delta) {
		states.get(selectState).update(delta);
	}
	
	public void setState(byte i) {
		for(int r = 0; r < canvas.getKeyListeners().length; r++) {
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		}
		selectState = 0;
		states.get(selectState).init(canvas);
	}
	
	public byte getStates() {
		return selectState;
	}
}
