package com.harsay.ludumdare34;

import com.harsay.ludumdare34.levels.Levels;
import com.harsay.ludumdare34.screens.WelcomeScreen;


public class Game extends com.badlogic.gdx.Game {

	@Override
	public void create() {
		Sfx.load();
		Gfx.load();
		
		Levels.set();
		
		setScreen(new WelcomeScreen(this));
	}

}
