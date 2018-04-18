package com.marianoProgra.Game_Screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.display.Display;
import com.marianoProgra.levels.Basic;
import com.marianoProgra.State.StateMachine;
import com.marianoProgra.State.SuperStateMachine;
import com.marianoProgra.levels.SuperLevel;
import com.marianoProgra.timer.TickTimer;

/**
 * Clase para inicializar los valores de player y los respectivos nivlees
 */
public class GameScreen extends SuperStateMachine {
	
	private Player player;
	private SuperLevel level;

	/**
	 * atributos de la Clase
	 */
	private static int Puntuacion = 0;
	private static int Nivel = 1;
	private static double speed = 1.0d;
	private Font gameScreen = new Font("Berlin Sans FB Demi", Font.PLAIN, 48);

	private TickTimer gameOverTimer = new TickTimer(180);
	private TickTimer completeTimer = new TickTimer(180);

	private Lista<SuperLevel> leves = new Lista <>();

	/**
	 * Constructor de la Clase
	 * @param stateMachine
	 */
	public GameScreen(StateMachine stateMachine){
		super(stateMachine);

		player = new Player(Display.getWIDTH()/2-50, Display.getHEIGHT()-75, 50, 50);
		level = new Basic(player);

	}



	@Override
	public void update(double delta) {
		player.update(delta);
		level.update(delta);
		
		if (level.isGameOver()) {
			gameOverTimer.tick(delta);
			if (gameOverTimer.isEventReady()) {
				level.reset();

				getStateMachine().setState((byte) 0);
				Puntuacion = 0;
				Nivel = 1;
				speed=1.0d;
			}
		}
		
		if (level.isComplete()) {
			completeTimer.tick(delta);
			if (completeTimer.isEventReady()) {
				level.reset();
				Nivel++;
				speed+=0.5d;
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.drawString("PUNTUACION: " + Puntuacion, 5, 15);

		g.setColor(Color.CYAN);
		g.drawString("NIVEL: "+Nivel, 5,25 );

		player.draw(g);
		level.draw(g);
		
		if (level.isGameOver()) {
			g.setColor(Color.red);
			g.setFont(gameScreen);
			String gameOver = "FIN DEL JUEGO MACHO!";
			int gameOverWidth = g.getFontMetrics().stringWidth(gameOver);
			g.drawString(gameOver, (Display.getWIDTH()/2)-(gameOverWidth/2), Display.getHEIGHT()/2);
		}
		
		if (level.isComplete()) {
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


	/**
	 * metodo para aumentar el Score
	 * @param aumento
	 */
	public static void aumentarSCORE(int aumento) {
		Puntuacion +=aumento;
	}
// getters y Setters
	public static int getNivel() {
		return Nivel;
	}

	public static double getSpeed() {
		return speed;
	}
}
