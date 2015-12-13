package com.harsay.ludumdare34.entities;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.harsay.ludumdare34.Blood;
import com.harsay.ludumdare34.Gfx;

public class BodyPart extends Entity {
	

	public Sprite sprite;
	
	public int bounces = 8;
	public float maxZ = 16, rotateSpeed;
	public boolean goesUp = true, goesDown = false;
		
	public int maxBloods = 100;
	
	public int n;
	
	
	Random rand = new Random();
	
	public BodyPart(float x, float y, int faces, int n, TextureRegion currentTexture) {
		super(x, y, 16, 16, currentTexture);
		
		sprite = new Sprite(currentTexture);
		
		y -= 10;
		
		this.n = n;
		
		float spd = rand.nextFloat()*200;
		if(faces == Entity.UP || faces == Entity.DOWN) {
			velX = spd*n;
		}
		else if(faces == Entity.LEFT || faces == Entity.RIGHT) {
			velY = spd*n;
		}
	}
	
	
	public void update(float delta) {	
		
		x+= velX*delta;
		y+= velY*delta;
		
		if(maxBloods > 0) {
			for(int i=0; i<4; i++) {
				maxBloods--;
				Blood b = new Blood();
				b.x = getCenterX();
				b.y = getCenterY();
				b.velX = n*rand.nextFloat()*5;
				b.velY = n*rand.nextFloat()*5;
				bloods.add(b);
			}
		}
		
		for(int i=0; i<bloods.size; i++) {
			bloods.get(i).update(delta);
		}
		
		if(goesUp) {
			if(z <= maxZ) {
				z += 100*delta;
				if(z >= maxZ) {
					maxZ /= 2;
					goesDown = true;
					goesUp = false;
				}
			}
		}
		else if(goesDown) {
			if(z > 0) {
				z -= 100*delta;
				if(z <= 0) {
					bounces--;
					if(bounces > 0)  {
						goesUp = true;
						sprite.rotate(90);
						velX /= 2;
						velY /= 2;
					}
					else {
						velX = 0;
						velY = 0;
					}
		
					goesDown = false;
					
				}
			}
		}
		
		
		sprite.setPosition(x, y+z);
	}
	
	public void render(SpriteBatch sb) {
		// i kno
		collisionCircle.set(x + width/2, y + height/2, width/4);
		//
		sprite.draw(sb);
	}

}
