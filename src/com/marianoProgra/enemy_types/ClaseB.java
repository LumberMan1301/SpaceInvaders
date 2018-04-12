package com.marianoProgra.enemy_types;

import com.marianoProgra.EstructurasDeDatosLineales.Listas.Lista;
import com.marianoProgra.Game_Screen.GameScreen;
import com.marianoProgra.Game_Screen.Player;
import com.marianoProgra.display.Display;
import com.marianoProgra.sound.Sound;
import com.marianoProgra.sprite.SpriteAnimation;

import java.awt.*;

public class ClaseB extends EnemyType{

    private static double speed = 1.2d;

    private Rectangle rect;
    private SpriteAnimation enemySpriteA;

    private Sound explosionSound;

    public ClaseB(double xPos, double yPos, int rows, int columns) {
        enemySpriteA = new SpriteAnimation(xPos, yPos, rows, columns, 300, "/com/marianoProgra/images/ClaseA.png");
        enemySpriteA.setWidth(30);
        enemySpriteA.setHeight(30);
        enemySpriteA.setLimit(2);

        this.setRect(new Rectangle((int) enemySpriteA.getxPos(), (int) enemySpriteA.getyPos(), enemySpriteA.getWidth(), enemySpriteA.getHeight()));
        enemySpriteA.setLoop(true);


        explosionSound = new Sound("/com/marianoProgra/sounds/explosion.wav");


    }


    @Override
    public void draw(Graphics2D g) {
        enemySpriteA.draw(g);
    }

    @Override
    public void update(double delta, Player player) {
        enemySpriteA.update(delta);

        enemySpriteA.setxPos(enemySpriteA.getxPos() - (delta * speed));
        this.getRect().x = (int) enemySpriteA.getxPos();


    }

    @Override
    public void changeDirection(double delta) {
        speed *= -1.5d;
        enemySpriteA.setxPos(enemySpriteA.getxPos() - (delta * speed));
        this.getRect().x = (int) enemySpriteA.getxPos();

        enemySpriteA.setyPos(enemySpriteA.getyPos() + (delta * 25));
        this.getRect().y = (int) enemySpriteA.getyPos();
    }

    @Override
    public boolean deathScene() {
        if(!enemySpriteA.isPlay())
            return false;

        if(enemySpriteA.isSpriteAnimDestroyed()) {
            if (!explosionSound.isPlaying()) {
                explosionSound.play();
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean collide(int i, Player player, Lista<EnemyType> enemys) {
        if(enemySpriteA.isPlay()) {
            if(enemys.get(i).deathScene()) {
                enemys.eliminar(i);
            }
            return false;
        }

        for(int w = 0; w < player.playerWeapons.weapons.size(); w++) {
            if(enemys != null && player.playerWeapons.weapons.get(w).collisionRect(((ClaseB) enemys.get(i)).getRect())) {
                enemySpriteA.resetLimit();
                enemySpriteA.setAnimationSpeed(60);
                enemySpriteA.setPlay(true, true);
                GameScreen.SCORE += 6;
                return true;
            }
        }

        return false;
    }



    @Override
    public boolean isOutOfBounds() {
        if(rect.x > 0 && rect.x < Display.getWIDTH() - rect.width)
            return false;
        return true;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

}
