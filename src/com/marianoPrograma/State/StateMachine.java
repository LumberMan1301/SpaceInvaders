package com.marianoPrograma.State;

import java.awt.Canvas;

import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoPrograma.EstructurasDeDatosLineales.Listas.Lista;

public class StateMachine {
	
	private Lista<SuperStateMachine> states = new Lista <SuperStateMachine>();
	private Canvas canvas;
	
	public StateMachine(Canvas canvas) {
		this.canvas = canvas;
		SuperStateMachine game = new GameScreen();
		states.agregar(game);
		
	}
}
