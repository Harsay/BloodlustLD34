package com.harsay.ludumdare34.screens;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.harsay.ludumdare34.levels.Level;

public class PlayScreen extends GameScreen {
	
	Level level = new Level();
	
	public PlayScreen() {
		super();
	}
	
	public void update(float delta) {
		super.update(delta);
		level.update(delta);
		
		cam.position.lerp(new Vector3(level.player.getCenterX(), level.player.getCenterY(), 0), 10.0f*delta);
						
		float camMinX = cam.viewportWidth/2;
		float camMaxX = level.getWidth() - camMinX;
		float camMinY = cam.viewportHeight/2;
		float camMaxY = level.getHeight() - camMinY;
		
		if(cam.position.x < camMinX) cam.position.x = camMinX;
		else if(cam.position.x > camMaxX) cam.position.x = camMaxX;
		if(cam.position.y < camMinY) cam.position.y = camMinY;
		else if(cam.position.y > camMaxY) cam.position.y = camMaxY;
	}
	
	public void render(float delta) {
		super.render(delta);
		sb.begin();
		level.render(sb);
		sb.end();
		
		sr.begin(ShapeType.Line);
		level.debugRender(sr);
		sr.end();
	}

}
