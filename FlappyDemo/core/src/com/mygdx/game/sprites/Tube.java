package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by ADI on 7/2/2017.
 */

public class Tube {
    private Texture TopTube,BottomTube;
    private static final int FLUCTUATION = 130;
    private Vector2 posTopTube,posBotTube;
    private Random rand;
    public static final int TUBE_WIDTH = 52;
    private static final int TUBE_GAP= 100;
    private static final int LOWEST_OPENING = 120;
    private Rectangle boundsTop,boundsBot;

    public Tube(float x){

        TopTube = new Texture("toptube.png");
        BottomTube = new Texture("bottomtube.png");
        rand = new Random();
        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x,posTopTube.y - TUBE_GAP - TopTube.getHeight());
        boundsTop = new Rectangle(posTopTube.x,posTopTube.y,TopTube.getWidth(),TopTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x,posBotTube.y, BottomTube.getWidth(), BottomTube.getHeight());



    }

    public Texture getBottomTube() {
        return BottomTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Texture getTopTube() {
        return TopTube;
    }

    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube.set(x,(posTopTube.y-TUBE_GAP-BottomTube.getHeight()));
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
    }

    public Boolean collides(Rectangle player){
        return player.overlaps(boundsTop)||player.overlaps(boundsBot);
    }

}
