package com.marianoProgra.hileras;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.enemy_types.EnemyType;
import com.marianoProgra.enemy_types.Subdito;
import com.marianoProgra.sound.Sound;

import java.awt.*;

public class ClaseD implements SuperLevel {
    /**
     * Atributos de la clase
     */
    private Player player;
    private ListaSimple<EnemyType> enemies = new ListaSimple<EnemyType>();
    private Sound beep, boop;
    private boolean beepboop;



    /**
     * Contrusctor de la clase
     * @param player
     */
    public ClaseD(Player player){
        this.player = player;

        addEnemies();

        beep = new Sound("/com/marianoProgra/sounds/beep.wav");
        boop = new Sound("/com/marianoProgra/sounds/boop.wav");
    }

    @Override
    public void draw(Graphics2D g) {
        if(enemies == null)
            return;

        for(int i = 0; i < enemies.getCapacidad(); i++){
            enemies.getData(i).draw(g);
        }

    }

    @Override
    public void update(double delta) {
        if(enemies == null)
            return;

        for(int i = 0; i < enemies.getCapacidad(); i++){
            enemies.getData(i).update(delta, player);
        }
        for(int i = 0; i < enemies.getCapacidad(); i++){
            enemies.getData(i).collide(i, player, enemies);
        }
        hasDirectionChange(delta);


    }

    @Override
    public void hasDirectionChange(double delta) {
        if(enemies == null)
            return;

        for(int i = 0; i < enemies.getCapacidad(); i++){
            if(enemies.getData(i).isOutOfBounds()){
                changeDurectionAllEnemys(delta);
                isGameOver();
            }
        }

    }

    @Override
    public void changeDurectionAllEnemys(double delta) {
        for(int i = 0; i < enemies.getCapacidad(); i++){
            enemies.getData(i).changeDirection(delta);
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
        for(int i = 0; i<enemies.getCapacidad(); i++){
            if(enemies.getData(i).passPlayer())
                return true;
        }
        return false;
    }



    @Override
    public void reset() {
        enemies.vaciar();
        addEnemies();


    }

    /**
     * metodo para agregar enemigos
     */
    public void addEnemies() {
        for (int y = 0; y <1+ GameScreen.getCant_hileras(); y++) {
            for (int x = 0; x < 10; x++) {
                EnemyType e = new Subdito(150 + (x * 40), 35 + (y * 40), 1, 3, 2,1.5d+GameScreen.getSpeed());
                enemies.agregar(e);
            }
        }
    }


    @Override
    public boolean isComplete() {
        return enemies.estaVacia();
    }

    @Override
    public String getNombre() {
        return "Clase D";
    }
}
