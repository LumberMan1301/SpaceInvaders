package com.marianoProgra.menu_screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.marianoProgra.display.Display;
import com.marianoProgra.State.StateMachine;
import com.marianoProgra.State.SuperStateMachine;

/**
 * Clase para recibir al jugador con un menu
 */
public class MenuScreen extends SuperStateMachine implements KeyListener {
	/**
	 * Atributos de la clase
	 */
	private Font tittleFont = new Font("Arial", Font.PLAIN, 64);
	private Font startFont = new Font("Arial", Font.PLAIN, 32);
	private String tittle = "Space Invaders";
	private String start = "Press Enter";

	/**
	 * Constructor de la clase
	 * @param stateMachine
	 */
	public MenuScreen(StateMachine stateMachine) {
		super(stateMachine);
	}

	@Override
	public void update(double delta) {

	}

	@Override
	public void draw(Graphics2D g) {
		g.setFont(tittleFont);
		int tittleWidth = g.getFontMetrics().stringWidth(tittle);
		g.setColor(Color.yellow);
		g.drawString(tittle, ((Display.getWIDTH()/2)-(tittleWidth/2))-2, (Display.getHEIGHT()/2)-123);
		g.setColor(Color.green);
		g.drawString(tittle, (Display.getWIDTH()/2)-(tittleWidth/2), (Display.getHEIGHT()/2)-125);
		
		g.setFont(startFont);
		g.setColor(Color.white);
		int startWidth = g.getFontMetrics().stringWidth(start);
		g.drawString(start, (Display.getWIDTH()/2)-(startWidth/2), (Display.getHEIGHT()/2)+75);
	}

	@Override
	public void init(Canvas canvas) {
		canvas.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			getStateMachine().setState((byte) 1);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
