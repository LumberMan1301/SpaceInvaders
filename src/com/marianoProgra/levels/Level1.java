package com.marianoProgra.levels;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.enemy_type.EnemyType;


public class Level1 implements SuperLevel{

	private Player player;
	private Lista<EnemyType> enemys = new Lista<EnemyType>();
	
	
	public Level1(Player player) {
		this.player = player;
	}
	@Override
	public void draw(Graphics2D g) {
		
	}

	@Override
	public void update(double delta) {
		
	}

	@Override
	public void hasDirectionChange(double delta) {
	
	}

	@Override
	public void changeDirectionAllEnemies(double delta) {
		
	}

	@Override
	public boolean isGameOver() {
		return false;
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void reset() {
		
	}
	

}
