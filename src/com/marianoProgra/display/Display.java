package com.marianoProgra.display;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;
/**
 * Clase Display, en esta clase se crea el JFrame va a contener el canvas
 */
import com.marianoProgra.State.StateMachine;

public class Display extends Canvas implements Runnable {
	/**
	 * atributo propio de Runnable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos
	 * running: este nos dice si la aplicacion esta ejecutandose
	 * thread: este nos dividir el tiempo de procesador para varias tareas
	 * WIDTH y HEIGHT son las variables para el tamaño de la ventana
	 * FPS: es una variable que nos permite controlar cuando el programa esta consumiendo demasiados recursos
	 */

	private boolean running = false;
	private Thread thread;
	private static int WIDTH = (int)(Toolkit.getDefaultToolkit().getScreenSize().width)-50;;
	private static int HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().height)-80;;
	private int FPS;

	private static StateMachine state;


	public static void main(String[] args) {
		Display display = new Display();
		JFrame frame = new JFrame();
		frame.add(display);
		frame.pack();
		frame.setTitle("Space Invaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

		display.start();

	}


	/**
	 * metodo que inicia la ejecucion de los threads
	 */
	public synchronized void start() {
		if (running)
			return;

		running = true;

		thread = new Thread(this);
		thread.start();
	}

	/**
	 * constructor de la clase Display
	 *
	 */
	public Display() {
		this.setSize(WIDTH, HEIGHT);
		this.setFocusable(true);

		state = new StateMachine(this);
		state.setState((byte) 0); 
	}

	/**
	 * metodo propio de la clase Runnable
	 */
	@Override
	public void run() {
		long timer = System.currentTimeMillis();
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		int frames = 0;

		this.createBufferStrategy(3);
		BufferStrategy bs = this.getBufferStrategy();
		while (running) {
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double) OPTIMAL_TIME);

			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				FPS = frames;
				frames = 0;

			}

			draw(bs);
			update(delta);

			try {
				Thread.sleep(((lastLoopTime - System.nanoTime()) + OPTIMAL_TIME) / 1000000);
			} catch (Exception e) {
			}
			;
		}
	}

	/**
	 * metodo para dibujar sobre el Jframe
	 * @param bs
	 */
	public void draw(BufferStrategy bs) {
		do {
			do {
				Graphics2D g = (Graphics2D) bs.getDrawGraphics();
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, WIDTH + 50, HEIGHT + 50);
				
				state.draw(g);

				g.dispose();
			} while (bs.contentsRestored());
			bs.show();
		} while (bs.contentsLost());
	}

	/**
	 * metodo que actualiza la pantalla
	 * @param delta
	 */
	public void update(double delta) {
		state.update(delta);
	}

	/**
	 * metodo que obtiene el ancho de la pantalla
	 * @return WIDTH
	 */
	public static int getWIDTH() {
		return WIDTH;
	}

	/**
	 * metodo que obtiene el alto de la pantalla
	 * @return HEIGHT
	 */
	public static int getHEIGHT() {
		return HEIGHT;
	}
}
