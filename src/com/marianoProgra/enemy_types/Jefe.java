package com.marianoProgra.enemy_types;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaCircular;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaSimple;
import com.marianoProgra.EstructurasDeDatosLineales.Listas.ListaDoble;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.display.Display;
import com.marianoProgra.sound.Sound;
import com.marianoProgra.sprite.SpriteAnimation;
import java.awt.*;

/**
 * clase derivada de EnemyType, que se encarga de recrear el jefe
 */
public class Jefe extends EnemyType{
    /**
     * Atributos de la clase
     */
    private double speed;//velocidad del enemigo
    private int vida;// vida del enemigo
    private Rectangle rect;// variable que nos permite comparar posiciones
    private SpriteAnimation enemySprite; // variable para almacenar imagenes
    private Sound explosionSound;//Sonido de la explosion
    /**
     * Constructor de la Clase Jefe
     * @param xPos
     * @param yPos
     * @param rows
     * @param columns
     * @param vida
     * @param speed
     */
    public Jefe(double xPos, double yPos, int rows, int columns, int vida, double speed){
        this.vida = vida;
        this.speed = speed;
        enemySprite = new SpriteAnimation(xPos, yPos, rows, columns, 300, "/com/marianoProgra/images/Jefe.png");
        enemySprite.setWidth(30);
        enemySprite.setHeight(30);
        enemySprite.setLimit(2);
        this.setRect(new Rectangle((int) enemySprite.getxPos(), (int) enemySprite.getyPos(), enemySprite.getWidth(), enemySprite.getHeight()));
        enemySprite.setLoop(true);
        explosionSound = new Sound("/com/marianoProgra/sounds/explosion.wav");
    }
    @Override
    public void draw(Graphics2D g) {enemySprite.draw(g);}
    @Override
    public void update(double delta, Player player) {
        enemySprite.update(delta);
        enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
        this.getRect().x = (int) enemySprite.getxPos();
    }
    @Override
    public void changeDirection(double delta) {
        speed *= -1.15d;
        enemySprite.setxPos(enemySprite.getxPos() - (delta * speed));
        this.getRect().x = (int) enemySprite.getxPos();

        enemySprite.setyPos(enemySprite.getyPos() + (delta * 25));
        this.getRect().y = (int) enemySprite.getyPos();
    }
    @Override
    public boolean deathScene() {
        if(!enemySprite.isPlay())
            return false;
        if(enemySprite.isSpriteAnimDestroyed()) {
            if (!explosionSound.isPlaying()) {
                explosionSound.play();
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean collide(int i, Player player, ListaSimple<EnemyType> enemys) {
        if(enemySprite.isPlay()) {
            if(enemys.getData(i).deathScene()) {
                enemys.eliminar(i);
            }
            return false;
        }
        for(int w = 0; w < player.getPlayerWeapons().getWeapons().getCapacidad(); w++) {
            if (enemys != null && player.getPlayerWeapons().getWeapons().getData(w).collisionRect(((Jefe) enemys.getData(i)).getRect())) {
                this.vida--;
            }if(vida==0){
                enemySprite.resetLimit();
                enemySprite.setAnimationSpeed(120);
                enemySprite.setPlay(true, true);
                GameScreen.aumentarSCORE(10);
                enemys.vaciar();
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean collide(int i, Player player, ListaDoble<EnemyType> enemys) {
        if(enemySprite.isPlay()) {
            if(enemys.obtenerDato(i).deathScene()) {
                enemys.eliminarPos(i);
            }
            return false;
        }
        for(int w = 0; w < player.getPlayerWeapons().getWeapons().getCapacidad(); w++) {
            if (enemys != null && player.getPlayerWeapons().getWeapons().getData(w).collisionRect(((Jefe) enemys.obtenerDato(i)).getRect())) {
                this.vida--;
            }if(vida==0){
                enemySprite.resetLimit();
                enemySprite.setAnimationSpeed(120);
                enemySprite.setPlay(true, true);
                GameScreen.aumentarSCORE(15);
                enemys.vaciar();
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para saber si hubo una colision con el Jefe
     *
     * @param i
     * @param player
     * @param enemys
     * @return
     */
    @Override
    public boolean collide(int i, Player player, ListaCircular<EnemyType> enemys) {
        return false;
    }

    @Override
    public boolean isOutOfBounds() {
        if(rect.x > 0 && rect.x < Display.getWIDTH() - rect.width)
            return false;
        return true;
    }
    @Override
    public boolean passPlayer() {
        if(rect.y > Display.getHEIGHT()-80)
            return true;
        return false;
    }


    public int getVida() {
        return vida;
    }
//##############Getters y Setters################################################
    /**
     * metodo para obtener el rectangulo
     * @return
     */
    public Rectangle getRect() {
        return rect;
    }
    /**
     * metodo para definir el rectangulo
     * @param rect
     */
    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

}
