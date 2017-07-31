package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.States.PlayState;

/**
 * Created by ADI on 6/24/2017.
 */

public class Bird {
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture bird;
    private static final int MOVEMENT =100;

   public Bird(int x,int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bird = new Texture("bird.png");
        bounds = new Rectangle(x,y,bird.getWidth(),bird.getHeight());
    }


    public void update(Float dt){

            if(position.y>0) {
                velocity.add(0, GRAVITY, 0);
                velocity.scl(dt);
               position.add(0, velocity.y, 0);
               position.add(MOVEMENT*dt,velocity.y,0);
                velocity.scl(1 / dt);
            }
        else
            {
                position.y=0;

            }





        bounds.setPosition(position.x,position.y);
    }

    public Texture getBird() {
        return bird;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void jump(){
        velocity.y= 250;
    }
}
