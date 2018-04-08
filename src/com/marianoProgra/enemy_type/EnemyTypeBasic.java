package com.marianoProgra.enemy_type;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;

public class EnemyTypeBasic implements EnemyType{

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDirection(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deathScene() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collide(int i, Player player, Lista<EnemyType> enemy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOutOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}

}
