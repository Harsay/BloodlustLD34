package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.harsay.ludumdare34.Blood;
import com.harsay.ludumdare34.Tiles;
import com.harsay.ludumdare34.levels.Level;

public class Entity {

	public float velX = 0, velY = 0, x, y, z = 0, width, height;
	public Circle collisionCircle;
	
	public TextureRegion currentTexture;
	
	public Vector2[] collisionPoints = new Vector2[4];
	
	public Array<Blood> bloods = new Array<Blood>();
	
	public boolean hadCollision = false;

	
	public static final int 
	COL_LEFT = 0,
	COL_UP = 1,
	COL_RIGHT = 2,
	COL_DOWN = 3;
	
	public int faces = RIGHT;
	
	public static final int
	UP = 0,
	DOWN = 1,
	LEFT = 2,
	RIGHT = 3;
	
	public Entity(float x, float y, float width, float height, TextureRegion currentTexture) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.currentTexture = currentTexture;
		collisionCircle = new Circle(x + width/2, y + height/2, width/4);
		
		
		updateCollisionPoints();

	}
	
	public void updateCollisionPoints() {
		collisionPoints[COL_LEFT] = new Vector2(x+0, getCenterY());
		collisionPoints[COL_UP] = new Vector2(getCenterX(), y+height);
		collisionPoints[COL_RIGHT] = new Vector2(x+width, getCenterY());
		collisionPoints[COL_DOWN] = new Vector2(getCenterX(), y+0);
	}
	
	public void update(float delta) {
		updateCollisionPoints();
	}
	
	public void render(SpriteBatch sb) {
		// i kno
		collisionCircle.set(x + width/2, y + height/2, width/4);
		//
		
		sb.draw(currentTexture, x, y+z);
	}
	
	public void debugRender(ShapeRenderer sr) {
		sr.setColor(Color.GREEN);
		sr.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius);
		for(int i=0; i<collisionPoints.length; i++) {
			Vector2 cp = collisionPoints[i];
			sr.setColor(Color.RED);
			sr.rect(cp.x, cp.y, 3, 3);
		}
	}
	
	public boolean collides(Entity ent) {
		return collisionCircle.overlaps(ent.collisionCircle);
	}
	
	public boolean collides(Level level, int tileX, int tileY) {
		int t = level.getTile(tileX, tileY);
		if(t != 0) return false; // collides only with 0's
		Rectangle tileRect = new Rectangle(tileX*Tiles.SIZE, tileY*Tiles.SIZE, Tiles.SIZE, Tiles.SIZE);
		Rectangle entRect = new Rectangle(x, y, width, height);
		return entRect.overlaps(tileRect);
	}
	
	public float getCenterX() {
		return x + width/2;
	}
	
	public float getCenterY() {
		return y + height/2;
	}	
}
