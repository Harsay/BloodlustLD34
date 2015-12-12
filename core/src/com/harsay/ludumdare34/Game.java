package com.harsay.ludumdare34;

import com.harsay.ludumdare34.screens.GameScreen;


public class Game extends com.badlogic.gdx.Game {

	@Override
	public void create() {
		Sfx.load();
		Gfx.load();
		
		setScreen(new GameScreen());
	}

}
