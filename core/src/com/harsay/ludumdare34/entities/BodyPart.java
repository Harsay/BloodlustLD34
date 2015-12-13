package com.harsay.ludumdare34.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BodyPart extends Entity {
	

	public Sprite sprite;
	
	public BodyPart(float x, float y, TextureRegion currentTexture) {
		super(x, y, 16, 16, currentTexture);
		
		sprite = new Sprite(currentTexture);
	}
	
	public void update(float delta) {
		z+= 10*delta;
		sprite.setPosition(x, y+z);
		sprite.rotate(0.3f);
	}
	
	public void render(SpriteBatch sb) {
		// i kno
		collisionCircle.set(x + width/2, y + height/2, width/4);
		//
		sprite.draw(sb);
	}

}
