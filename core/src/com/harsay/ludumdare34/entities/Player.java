package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.harsay.ludumdare34.Gfx;

public class Player extends Entity {
		
	public Rectangle attackBounds;
	public boolean attacks = false, kills = false, freeze = false;
	public float baseSpeed = 64, furyAddSpeed = 64;
	
	public Animation idle, run;
	
	public float animTime = 0.0f;
	
	public int fury = 100;
	
	public float furyDecrementTime = 2.0f;
	
	public int animFace = RIGHT, tickWait = 0;

	public Player(float x, float y) {
		super(x, y, 16, 16, Gfx.frames.get(0));
		attackBounds = new Rectangle(x+width, y, width, height);
		
		idle = new Animation(1.0f, Gfx.frames.get(0), Gfx.frames.get(1));
		run = new Animation(0.1f, Gfx.frames.get(2), Gfx.frames.get(3), Gfx.frames.get(4));
		run.setPlayMode(PlayMode.LOOP_PINGPONG);
	}
	
	public void update(float delta) {
		super.update(delta);
		
		if(freeze) return;
		
		float move = (baseSpeed + furyAddSpeed*(fury/100f))*delta;
		
		boolean up = Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W);
		boolean down = Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S);
		boolean left = Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A);
		boolean right = Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D);
		boolean space = Gdx.input.isKeyJustPressed(Keys.SPACE);
		
		//TODO: strafe fix
		
		idle.setFrameDuration(1.1f - (fury/100f));
		
		furyDecrementTime -= delta;
		
		if(furyDecrementTime <= 0)  {
			 fury -= 1;
			furyDecrementTime = 0.2f;
		}
		
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
			currentTexture = Gfx.frames.get(5);
			if(tickWait == 0) {
				currentTexture = Gfx.frames.get(6);
				kills = true;
				attacks = false;
				tickWait = 5;
			}
		}
		else if(tickWait == 0) {
			if(velX == 0 && velY == 0) currentTexture = idle.getKeyFrame(animTime, true);
			else currentTexture = run.getKeyFrame(animTime, true);
		}
		
		//System.out.println(fury);

	}
	
	public void render(SpriteBatch sb) {
		// i kno
		collisionCircle.set(x + width/2, y + height/2, width/4);
		//
		sb.setColor((fury/100f), 0, 0, 1f);
		if(freeze) {
			sb.setColor(Color.WHITE);
			currentTexture = Gfx.playerFail;
		}
		sb.draw(currentTexture, animFace == LEFT ? x+width : x, y, animFace == LEFT ? -width : width, height);
		sb.setColor(Color.WHITE);
	}
	
	public void debugRender(ShapeRenderer sr) {
		super.debugRender(sr);
		sr.rect(attackBounds.x, attackBounds.y, attackBounds.width, attackBounds.height);
	}
	
	public void addFury() {
		fury += 2;
		furyDecrementTime += 0.2f;
		if(fury > 100) fury = 100;
	}
}
