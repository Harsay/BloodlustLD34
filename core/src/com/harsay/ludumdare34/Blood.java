package com.harsay.ludumdare34;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Blood {
	
	public float x, y, velX, velY;
	public TextureRegion txt;
	
	public float ticks = 0.05f;
	
	public Blood() {
		txt = Gfx.blood;
	}
	
	public void update(float delta) {
		if(ticks <= 0) return;
		ticks-=delta;
		x += velX;
		y += velY;
	}
	
}
