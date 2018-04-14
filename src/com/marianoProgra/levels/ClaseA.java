package com.marianoProgra.levels;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.enemy_types.EnemyType;
import com.marianoProgra.enemy_types.Jefe;
import com.marianoProgra.enemy_types.Subdito;
import com.marianoProgra.sound.Sound;

import java.awt.*;

/**
 * Clase de la Hilera tipo A
 */
public class ClaseA implements SuperLevel {
    private Player player;
    private Lista<EnemyType> enemies = new Lista<EnemyType>();

    private Sound beep, boop;
    private boolean beepboop;

    public ClaseA(Player player){
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
        enemies.vaciar();
        addEnemies();

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
    public void reset() {
        player.reset();
        enemies.vaciar();
        addEnemies();


    }
    /**
     * metodo para agregar enemigos
     */
    public void addEnemies() {
        int xpos = (int) Math.floor(Math.random()*10);
        System.out.println(xpos);
        for (int x = 0; x < 10; x++) {
            if(x==xpos){
                EnemyType e = new Jefe(150+(x*40),65,1,3,5,2.0d);
                enemies.agregar(e);
            }else {
                EnemyType e = new Subdito(150 + (x * 40), 65, 1, 3, 2, 2.0d);
                enemies.agregar(e);
            }
        }
    }


    @Override
    public boolean isComplete() {
        return enemies.isEmpty();
    }
}
