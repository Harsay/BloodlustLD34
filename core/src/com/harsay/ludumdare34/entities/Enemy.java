package com.harsay.ludumdare34.entities;

import java.util.Random;

import com.harsay.ludumdare34.Gfx;

public class Enemy extends Entity {
	
	Random rand = new Random();
	
	float time = 0f;
	float velX = 0;
	float velY = 0;

	public Enemy(float x, float y) {
		super(x, y, 64, 64, Gfx.playerTest);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		if(time <= 0) {
			time = rand.nextFloat()*10f;
			velX = rand.nextInt(200)-100;
			velY = rand.nextInt(200)-100;
		}
		
		time -= delta;
		
		x += velX*delta;
		y += velY*delta;
		
		
	}

}
