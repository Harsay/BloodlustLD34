package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.harsay.ludumdare34.Gfx;

public class Player extends Entity {
		
	public Rectangle attackBounds;
	public boolean attacks = false;

	public Player(float x, float y) {
		super(x, y, 64, 64, Gfx.playerTest2);
		attackBounds = new Rectangle(x+width, y, width, height);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		float move = 1000*delta;
		
		boolean up = Gdx.input.isKeyPressed(Keys.UP);
		boolean down = Gdx.input.isKeyPressed(Keys.DOWN);
		boolean left = Gdx.input.isKeyPressed(Keys.LEFT);
		boolean right = Gdx.input.isKeyPressed(Keys.RIGHT);
		boolean space = Gdx.input.isKeyJustPressed(Keys.SPACE);
		
		//TODO: strafe fix
		
		velX = 0;
		velY = 0;
		
		if(up) {
			faces = UP;
			velY += move;
		}
		else if(down) {
			faces = DOWN;
			velY -= move;
		}
		
		if(right) {
			faces = RIGHT;
			velX += move;
		}
		else if(left) {
			faces = LEFT;
			velX -= move;
		}
		
		attacks = false;
		if(space) {
			attacks = true;
			switch(faces) {
				case UP: attackBounds.setPosition(x, y+height); break;
				case DOWN: attackBounds.setPosition(x, y-attackBounds.height); break;
				case LEFT: attackBounds.setPosition(x-attackBounds.width, y); break;
				case RIGHT: attackBounds.setPosition(x+width, y); break;
			}
		}
		
		
		x += velX;
		y += velY;
		
	}
	
	public void debugRender(ShapeRenderer sr) {
		super.debugRender(sr);
		sr.rect(attackBounds.x, attackBounds.y, attackBounds.width, attackBounds.height);
	}
}
