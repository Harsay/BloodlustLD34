package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.harsay.ludumdare34.Gfx;

public class Player extends Entity {
		
	public Rectangle attackBounds;
	public boolean attacks = false, kills = false;
	
	public Animation idle, run;
	
	public float animTime = 0.0f;
	
	public int animFace = RIGHT, tickWait = 0;

	public Player(float x, float y) {
		super(x, y, 16, 16, Gfx.playerIdle1);
		attackBounds = new Rectangle(x+width, y, width, height);
		
		idle = new Animation(0.8f, Gfx.playerIdle1, Gfx.playerIdle2);
		run = new Animation(0.1f, Gfx.playerRun1, Gfx.playerRun2, Gfx.playerRun3);
		run.setPlayMode(PlayMode.LOOP_PINGPONG);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		float move = 100*delta;
		
		boolean up = Gdx.input.isKeyPressed(Keys.UP);
		boolean down = Gdx.input.isKeyPressed(Keys.DOWN);
		boolean left = Gdx.input.isKeyPressed(Keys.LEFT);
		boolean right = Gdx.input.isKeyPressed(Keys.RIGHT);
		boolean space = Gdx.input.isKeyJustPressed(Keys.SPACE);
		
		//TODO: strafe fix
		
		velX = 0;
		velY = 0;
		kills = false;
		if(tickWait > 0) tickWait--;
		
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
			animFace = RIGHT;
			velX += move;
		}
		else if(left) {
			faces = LEFT;
			animFace = LEFT;
			velX -= move;
		}
		
		if(space && !attacks) {
			attacks = true;
			tickWait = 15;
		}
		
		switch(faces) {
		case UP: attackBounds.setPosition(x, y+height); break;
		case DOWN: attackBounds.setPosition(x, y-attackBounds.height); break;
		case LEFT: attackBounds.setPosition(x-attackBounds.width, y); break;
		case RIGHT: attackBounds.setPosition(x+width, y); break;
	}
		
		
		x += velX;
		y += velY;
		
		animTime += delta;
		if(attacks) {
			currentTexture = Gfx.playerPrepare;
			if(tickWait == 0) {
				currentTexture = Gfx.playerAttacked;
				kills = true;
				attacks = false;
				tickWait = 5;
			}
		}
		else if(tickWait == 0) {
			if(velX == 0 && velY == 0) currentTexture = idle.getKeyFrame(animTime, true);
			else currentTexture = run.getKeyFrame(animTime, true);
		}

	}
	
	public void render(SpriteBatch sb) {
		// i kno
		collisionCircle.set(x + width/2, y + height/2, width/4);
		//
		sb.draw(currentTexture, animFace == LEFT ? x+width : x, y, animFace == LEFT ? -width : width, height);
	}
	
	public void debugRender(ShapeRenderer sr) {
		super.debugRender(sr);
		sr.rect(attackBounds.x, attackBounds.y, attackBounds.width, attackBounds.height);
	}
}
