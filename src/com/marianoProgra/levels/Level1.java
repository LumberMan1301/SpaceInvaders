package com.marianoProgra.levels;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.enemy_type.EnemyType;
import com.marianoProgra.enemy_type.EnemyTypeBasic;


public class Level1 implements SuperLevel{

	private Player player;
	private Lista<EnemyType> enemies = new Lista<EnemyType>();
	
	
	public Level1(Player player) {
		this.player = player;
		for(int y = 0; y<2; y++) {
			for (int x = 0; x < 10; x++) {
				EnemyType e = new EnemyTypeBasic(150 + (x*80), 50+(y*60), 1, 2);
				enemies.agregar(e);
			}
		}
	}
	@Override
	public void draw(Graphics2D g) {
		if(enemies==null) {
			return;
		}
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
	}

	@Override
	public void update(double delta) {
		if(enemies==null) {
			return;
		} 
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update(delta, player);
		}
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).collide(i, player, enemies );
		}
		hasDirectionChange(delta);
	}

	@Override
	public void hasDirectionChange(double delta) {
		if(enemies==null) {
			return;
		} 
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i).isOutOfBounds())
				changeDirectionAllEnemies(delta);
		}
	}

	@Override
	public void changeDirectionAllEnemies(double delta) {
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).changeDirection(delta);
		}
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
