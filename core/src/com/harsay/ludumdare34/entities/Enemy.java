package com.harsay.ludumdare34.entities;

import com.harsay.ludumdare34.Gfx;

public class Enemy extends Entity {

	public Enemy(float x, float y) {
		super(x, y, 50, 100, Gfx.playerTest);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		x += 50*delta;
		
		
	}

}
