package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Entity {

	public float x, y, width, height;
	public Circle collisionCircle;
	
	public Texture currentTexture;
	
	public Entity(float x, float y, float width, float height, Texture currentTexture) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.currentTexture = currentTexture;
		collisionCircle = new Circle(x + width/2, y + height/2, width/2);
	}
	
	public void update(float delta) {
		
	}
	
	public void render(SpriteBatch sb) {
		// i kno
		collisionCircle.set(x + width/2, y + height/2, width/2);
		//
		
		sb.draw(currentTexture, x, y);
	}
	
	public void debugRender(ShapeRenderer sr) {
		sr.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius);
	}
	
	public boolean collides(Entity ent) {
		return collisionCircle.overlaps(ent.collisionCircle);
	}
	
	public float getCenterX() {
		return x + width/2;
	}
	
	public float getCenterY() {
		return y + height/2;
	}	
}
