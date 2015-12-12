package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {

	public float x, y, width, height;
	
	public Texture currentTexture;
	
	public Entity(float x, float y, float width, float height, Texture currentTexture) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.currentTexture = currentTexture;
	}
	
	public void update(float delta) {
		
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(currentTexture, x, y);
	}
	
}
