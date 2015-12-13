package com.harsay.ludumdare34.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.harsay.ludumdare34.Settings;

public class GameScreen implements Screen {
	
	public OrthographicCamera cam;
	public Viewport viewport;
	public SpriteBatch sb = new SpriteBatch();
	public ShapeRenderer sr = new ShapeRenderer();
	public Color clearColor = new Color(Color.BLACK);
	public Color backgroundColor = new Color(Color.BLACK);
	
	public float shakeTime = 0, shakeStrength = 25.f;

		
	public GameScreen() {
		cam = new OrthographicCamera(Settings.NATIVE_WIDTH, Settings.NATIVE_HEIGHT);
		viewport = new FitViewport(Settings.NATIVE_WIDTH, Settings.NATIVE_HEIGHT, cam);
	}

	
	public void update(float delta) {
		
	}

	@Override
	public void render(float delta) {
		update(delta);
		cam.update();
		
		// Clear screen
		Gdx.gl.glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		sr.setProjectionMatrix(cam.combined);
		sb.setProjectionMatrix(cam.combined);

		// Background color
		sr.begin(ShapeType.Filled);
		sr.setColor(backgroundColor);
		sr.rect(0, 0, Settings.NATIVE_WIDTH, Settings.NATIVE_HEIGHT);
		sr.end();
		
	}

	@Override
	public void resize(int width, int height) {
	    viewport.update(width, height);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
