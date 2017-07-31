package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.States.GameStateManager;
import com.mygdx.game.States.Menu;

public class FlappyDemo extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameStateManager gsm;


	public static final int WIDTH = 1080;
	public static final int HEIGHT = 1920;
	public static final String TITLE = "Flappy Bird";
	
	@Override
	public void create () {
		batch = new SpriteBatch();	//don't create more than one sprite batches
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);//wipes the screen clean and redraws everything
		gsm.push(new Menu(gsm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());//it will tell the delta time at which the update takes place
		gsm.render(batch); // rendering command
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
