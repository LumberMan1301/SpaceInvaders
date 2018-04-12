package com.marianoProgra.levels;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.enemy_types.ClaseA;
import com.marianoProgra.enemy_types.EnemyType;
import com.marianoProgra.enemy_types.Basic;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.sound.Sound;

public class Level1 implements SuperLevel{

	private static int flag=0;
	private Player player;
	private Lista<EnemyType> enemies = new Lista<EnemyType>();

	private Sound beep, boop;
	private boolean beepboop;
	
	public Level1(Player player){
		this.player = player;

		addEnemies();
		
		beep = new Sound("/com/marianoProgra/sounds/beep.wav");
		boop = new Sound("/com/marianoProgra/sounds/boop.wav");
	}
	
	@Override
	public void draw(Graphics2D g) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.get(i).draw(g);
		}

	}

	@Override
	public void update(double delta) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.get(i).update(delta, player);
		}
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.get(i).collide(i, player, enemies);
		}
		hasDirectionChange(delta);

	}

	@Override
	public void hasDirectionChange(double delta) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.capacidad(); i++){
			if(enemies.get(i).isOutOfBounds()){
				changeDurectionAllEnemys(delta);
			}
		}
	}

	@Override
	public void changeDurectionAllEnemys(double delta) {
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.get(i).changeDirection(delta);
		}
		if (beepboop) {
			beepboop = false;
			boop.play();
		} else {
			beepboop = true;
			beep.play();
		}
	}

	@Override
	public boolean isGameOver() {
		return false;
	}

	@Override
	public void destory() {
		
	}

	@Override
	public void reset() {
		player.reset();
		enemies.vaciar();
		addEnemies();
		

	}
	
	public void addEnemies() {

		int variable = (int)(Math.random()*10);
			for (int y = 0; y < 2; y++) {
				for (int x = 0; x < 10; x++) {
					if (variable % 2 == 0) {
						EnemyType e = new Basic(150 + (x * 40), 25 + (y * 40), 1, 3);
						enemies.agregar(e);
					}
					if (variable % 2 == 1) {
						EnemyType e = new ClaseA(150 + (x * 40), 25 + (y * 40), 1, 3);
						enemies.agregar(e);

					}
			}
		}
	}


	@Override
	public boolean isComplete() {
		return enemies.isEmpty();
	}

	public Lista<EnemyType> getEnemies() {
		return enemies;
	}
}
