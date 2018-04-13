package com.marianoProgra.enemy_types;

import java.awt.Graphics2D;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaDoble;
import com.marianoProgra.Game_Screen.Player;

public abstract class EnemyType {
	
	public EnemyType() {

	}

	public abstract void draw(Graphics2D g);
	public abstract void update(double delta, Player player);
	public abstract void changeDirection(double delta);
	
	public abstract boolean deathScene();
	public abstract boolean collide(int i, Player player, Lista<EnemyType> enemys);
	public abstract boolean collide(int i ,Player player, ListaDoble<EnemyType> enemys);
	public abstract boolean isOutOfBounds();
	public abstract boolean passPlayer();


}
