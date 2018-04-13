package com.marianoProgra.Game_Screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.marianoProgra.display.Display;
import com.marianoProgra.levels.Basic;
import com.marianoProgra.State.StateMachine;
import com.marianoProgra.State.SuperStateMachine;
import com.marianoProgra.levels.ClaseA;
import com.marianoProgra.timer.TickTimer;


public class GameScreen extends SuperStateMachine {
	
	private Player player;
	private Basic levelBasic;
	private ClaseA levelA;

	private static int SCORE = 0;
	private Font gameScreen = new Font("Berlin Sans FB Demi", Font.PLAIN, 48);



	private TickTimer gameOverTimer = new TickTimer(180);
	private TickTimer completeTimer = new TickTimer(180);
	
	public GameScreen(StateMachine stateMachine){
		super(stateMachine);

		player = new Player(Display.getWIDTH()/2-50, Display.getHEIGHT()-75, 50, 50);
		levelBasic = new Basic(player);
		levelA = new ClaseA(player);
	}



	@Override
	public void update(double delta) {
		player.update(delta);
		levelBasic.update(delta);
		
		if (levelBasic.isGameOver()) {
			gameOverTimer.tick(delta);
			if (gameOverTimer.isEventReady()) {
				levelBasic.reset();

				getStateMachine().setState((byte) 0);
				SCORE = 0;
			}
		}
		
		if (levelBasic.isComplete()) {
			completeTimer.tick(delta);
			if (completeTimer.isEventReady()) {
				levelBasic.reset();
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.drawString("PUNTUACION: " + SCORE, 5, 15);

		player.draw(g);
		levelBasic.draw(g);
		
		if (levelBasic.isGameOver()) {
			g.setColor(Color.red);
			g.setFont(gameScreen);
			String gameOver = "FIN DEL JUEGO MACHO!";
			int gameOverWidth = g.getFontMetrics().stringWidth(gameOver);
			g.drawString(gameOver, (Display.getWIDTH()/2)-(gameOverWidth/2), Display.getHEIGHT()/2);
		}
		
		if (levelBasic.isComplete()) {
			g.setColor(Color.lightGray);
			g.setFont(gameScreen);
			String complete = "NIVEL EXTERMINADO, ERES UN MAJO!";
			int completeWidth = g.getFontMetrics().stringWidth(complete);
			g.drawString(complete, (Display.getWIDTH()/2)-(completeWidth/2), Display.getHEIGHT()/2);
		}
	}

	@Override
	public void init(Canvas canvas) {
		canvas.addKeyListener(player);
	}

	public static void aumentarSCORE(int aumento) {
		SCORE+=aumento;
	}
}
