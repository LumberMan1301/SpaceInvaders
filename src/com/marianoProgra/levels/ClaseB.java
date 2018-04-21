package com.marianoProgra.levels;


import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaDoble;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.enemy_types.EnemyType;
import com.marianoProgra.enemy_types.Jefe;
import com.marianoProgra.enemy_types.Subdito;
import com.marianoProgra.sound.Sound;

import java.awt.*;

public class ClaseB implements SuperLevel {
    private Player player;
    private ListaDoble<EnemyType> enemies = new ListaDoble<EnemyType>();

    private Sound beep, boop;
    private boolean beepboop;
    private int posJefe = (int) Math.floor(Math.random()*10);
    private int posR = (int) Math.floor((Math.random()*4)+1);

    private static int x2 = 0;
    private static int flag = 0;
    private static int cant = 10;

    public ClaseB(Player player){
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
                if(flag%2==1){
                    enemies.vaciar();
                    addEnemies();
                }
            }
        }
    }


    @Override
    public void changeDurectionAllEnemys(double delta) {
        for(int i = 0; i < enemies.capacidad(); i++){
            enemies.getDato(i).changeDirection(delta);
        }
        flag++;
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

    public void addEnemies() {
        int pos = (int) Math.floor(Math.random()*10);
        for (int x=0; x < cant; x++) {
            if(x==pos){
                EnemyType e = new Jefe(0+(x*40),65+x2,1,3,5,2.5d);
                enemies.agregar(e);
            }else {
                EnemyType e = new Subdito(0 + (x * 40), 65+x2, 1, 3, 2, 2.5d);
                enemies.agregar(e);
            }
        }x2+=20;

    }


    @Override
    public boolean isComplete() {
        return enemies.estaVacia();
    }
    public static int getCant(){
        return cant;
    }
    public static void setCant(int i){
        cant = i;
    }
}
