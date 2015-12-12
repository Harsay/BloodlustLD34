package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.harsay.ludumdare34.Gfx;

public class Player extends Entity {

	public Player(float x, float y) {
		super(x, y, 50, 100, Gfx.playerTest);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		float move = 300*delta;
		
		boolean up = Gdx.input.isKeyPressed(Keys.UP);
		boolean down = Gdx.input.isKeyPressed(Keys.DOWN);
		boolean left = Gdx.input.isKeyPressed(Keys.LEFT);
		boolean right = Gdx.input.isKeyPressed(Keys.RIGHT);
		
		//TODO: strafe fix
		
		if(up) {
			y += move;
		}
		else if(down) {
			y -= move;
		}
		
		if(right) {
			x += move;
		}
		else if(left) {
			x -= move;
		}
		
	}

}
