package com.harsay.ludumdare34.screens;

import com.harsay.ludumdare34.levels.Level;

public class PlayScreen extends GameScreen {
	
	Level level = new Level();
	
	public PlayScreen() {
		super();
	}
	
	public void update(float delta) {
		super.update(delta);
		level.update(delta);
	}
	
	public void render(float delta) {
		super.render(delta);
		sb.begin();
		level.render(sb);
		sb.end();
	}

}
