package com.marianoProgra.Game_Screen;

import java.awt.Canvas;
import java.awt.Graphics2D;

import com.marianoProgra.State.SuperStateMachine;
import com.marianoProgra.levels.Level1;

public class GameScreen implements SuperStateMachine {

	
	private Player player;
	private Level1 level1;
	
	public GameScreen() {
		player = new Player();
		level1 = new Level1(player);
		
	}
	
	@Override
	public void update(double delta) {
		player.update(delta);
		level1.update(delta);
	}

	@Override
	public void draw(Graphics2D g) {
		player.draw(g);
		level1.draw(g);
		
	}

	@Override
	public void init(Canvas canvas) {
		canvas.addKeyListener(player);
		
	}

}
