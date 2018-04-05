package com.marianoPrograma.Display;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Display extends Canvas implements Runnable{

	public static void main(String [] args) {
		Display display = new Display();
		
		JFrame frame = new JFrame();
		frame.add(display);
		frame.pack();
		frame.setTitle("Space Invaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	}
	@Override
	public void run() {
		
		
	}
	
	

}
