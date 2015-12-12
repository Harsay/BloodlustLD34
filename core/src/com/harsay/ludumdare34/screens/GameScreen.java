package com.harsay.ludumdare34.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.harsay.ludumdare34.Gfx;
import com.harsay.ludumdare34.Settings;

public class GameScreen implements Screen {
	
	public OrthographicCamera cam;
	public Viewport viewport;
	public SpriteBatch sb = new SpriteBatch();
	public ShapeRenderer sr = new ShapeRenderer();
	public Color clearColor = new Color(Color.BLACK);
	public Color backgroundColor = new Color(Color.ORANGE);
	
	GlyphLayout hello;
	
	public GameScreen() {
		cam = new OrthographicCamera(Settings.NATIVE_WIDTH, Settings.NATIVE_HEIGHT);
		cam.position.set(Settings.NATIVE_WIDTH/2, Settings.NATIVE_HEIGHT/2, 0);
		cam.setToOrtho(false);
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
		
		hello = new GlyphLayout(Gfx.font, "Hello World!");
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
		
		// Background color
		sr.begin(ShapeType.Filled);
		sr.setColor(backgroundColor);
		sr.rect(0, 0, Settings.NATIVE_WIDTH, Settings.NATIVE_HEIGHT);
		sr.end();
		
		sb.begin();
		Gfx.font.draw(sb, hello, Settings.NATIVE_WIDTH/2-hello.width/2, Settings.NATIVE_HEIGHT/2+hello.height/2);
		sb.end();
		
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
