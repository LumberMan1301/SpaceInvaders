package com.marianoProgra.levels;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.enemy_types.EnemyType;
import com.marianoProgra.enemy_types.Subdito;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.sound.Sound;

public class Basic implements SuperLevel{

	private Player player;
	private Lista<EnemyType> enemies = new Lista<EnemyType>();

	private Sound beep, boop;
	private boolean beepboop;
	
	public Basic(Player player){
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
			enemies.getDato(i).draw(g);
		}

	}

	@Override
	public void update(double delta) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.getDato(i).update(delta, player);
		}
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.getDato(i).collide(i, player, enemies);
		}
		hasDirectionChange(delta);

	}

	@Override
	public void hasDirectionChange(double delta) {
		if(enemies == null)
			return;
		
		for(int i = 0; i < enemies.capacidad(); i++){
			if(enemies.getDato(i).isOutOfBounds()){
				changeDurectionAllEnemys(delta);
			}
		}
	}

	@Override
	public void changeDurectionAllEnemys(double delta) {
		for(int i = 0; i < enemies.capacidad(); i++){
			enemies.getDato(i).changeDirection(delta);
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
			for (int y = 0; y < 2; y++) {
				for (int x = 0; x < 10; x++) {
					EnemyType e = new Subdito(150 + (x * 40), 25 + (y * 40), 1, 3, 2,1.5d);
					enemies.agregar(e);
			}
		}
	}


	@Override
	public boolean isComplete() {
		return enemies.isEmpty();
	}


}