package com.marianoProgra.enemy_type;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;

public interface EnemyType {
	
	void draw(Graphics2D g);
	void update (double delta, Player player);
	void changeDirection(double delta);
	
	boolean deathScene();
	boolean collide(int i, Player player, Lista<EnemyType> enemies);
	boolean isOutOfBounds();
	

}
