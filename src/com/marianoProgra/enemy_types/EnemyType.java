package com.marianoProgra.enemy_types;
//###############Importaciones###########################################
import java.awt.Graphics2D;
<<<<<<< HEAD

import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaCircular;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;
=======
import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
>>>>>>> parent of 47cbb82... Trabajando en la Clase D
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaDoble;
import com.marianoProgra.Game_Screen.Player;
/**
 * Clase Padre de los tipos de enemigos, aqui se definen los metodos por default que deben tener las subclases
 */
public abstract class EnemyType {
	/**
	 * metodo para dibujar en el canvas
	 * @param g
	 */
	public abstract void draw(Graphics2D g);
	/**
	 * metodo para actualizar el canvas
	 * @param delta
	 * @param player
	 */
	public abstract void update(double delta, Player player);
	/**
	 * metodo para cambiar la direccion de los enemigos
	 * @param delta
	 */
	public abstract void changeDirection(double delta);
	/**
	 * metodo que nos permite ver la animacion de la muerte de un enemigo
	 * @return
	 */
	public abstract boolean deathScene();
	/**
	 * metodo para saber si hubo una colision con el Subdito
	 * @param i
	 * @param player
	 * @param enemys
	 * @return
	 */
<<<<<<< HEAD
	public abstract boolean collide(int i, Player player, ListaSimple<EnemyType> enemys);

=======
	public abstract boolean collide(int i, Player player, Lista<EnemyType> enemys);
>>>>>>> parent of 47cbb82... Trabajando en la Clase D
	/**
	 * metodo para saber si hubo una colision con el Jefe
	 * @param i
	 * @param player
	 * @param enemys
	 * @return
	 */
	public abstract boolean collide(int i ,Player player, ListaDoble<EnemyType> enemys);
	/**
	 * metodo para saber si hubo una colision con el Jefe
	 * @param i
	 * @param player
	 * @param enemys
	 * @return
	 */
	public abstract boolean collide(int i ,Player player, ListaCircular<EnemyType> enemys);
	/**
	 * Nos indica si el enemigo esta fuera de los limites de la pantalla de juego
	 * @return
	 */
	public abstract boolean isOutOfBounds();
	/**
	 * metodo para saber si las naves enemigas chocaron con el jugador
	 * @return
	 */
	public abstract boolean passPlayer();




}
