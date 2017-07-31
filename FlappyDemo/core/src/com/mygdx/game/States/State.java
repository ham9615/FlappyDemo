package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.States.GameStateManager;

/**
 * Created by ADI on 6/17/2017.
 */

public abstract class State {

    protected OrthographicCamera cam; //It is the camera
    protected Vector3 mouse ;   // It gives the coordinates x-y-z
    protected GameStateManager gsm;  //A game state manager is something that manages the state of the game


    protected State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();


    }

    protected abstract void handleInput();
    public abstract void update(Float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
