package com.mygdx.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by ADI on 6/17/2017.
 */
public class GameStateManager { // a game state manager mainatains the state of the game like when it is in pause state or when is
                                //in play state. It basically does that by using stack that stores each state in it

private Stack<State> states;

public GameStateManager(){

 states = new Stack<State>();

}

    public void push(State state){
        states.push(state);
    }

    public  void pop(){
        states.pop();
    }

    public void set(State state){ // For instantly popping and pushing the element to the stack
        states.pop();
        states.push(state);
    }

    public void update(Float dt){//for updating information onto the screen where dt is the time
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){//to render everything to the screen using spritebatch
        states.peek().render(sb);
    }




}
