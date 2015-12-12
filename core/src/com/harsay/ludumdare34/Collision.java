package com.harsay.ludumdare34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.harsay.ludumdare34.entities.Entity;

public class Collision {
	
	public static void response(Entity ent1, Entity ent2) {
		
		//TODO: Przewidywanie zamiast wyci¹gania
		
		Circle c1 = ent1.collisionCircle;
		Circle c2 = ent2.collisionCircle;
		Vector2 c1v = new Vector2(c1.x, c1.y);
		Vector2 c2v = new Vector2(c2.x, c2.y);
		
		float distance = c1v.dst(c2v);
		float radiusSum = c1.radius + c2.radius;
		
		float toMove = ((radiusSum - distance) / 2)*15f*Gdx.graphics.getDeltaTime();
		
		if(ent1.x < ent2.x) {
			ent1.x -= toMove;
			ent2.x += toMove;
		}
		else {
			ent1.x += toMove;
			ent2.x -= toMove;
		}
		
		if(ent1.y < ent2.y) {
			ent1.y -= toMove;
			ent2.y += toMove;
		}
		else {
			ent1.y += toMove;
			ent2.y -= toMove;	
		}
	}
	
	public static void response(Entity ent, int tileX, int tileY) {
		float tileRealX = tileX*Tiles.SIZE;
		float tileRealY = tileY*Tiles.SIZE;
		
		boolean goesRight = ent.velX > 0;
		boolean goesLeft = ent.velX < 0;
		boolean goesDown = ent.velY < 0;
		boolean goesUp = ent.velY > 0;	
		
		Rectangle tileRect = new Rectangle(tileRealX, tileRealY, Tiles.SIZE, Tiles.SIZE);
		
		boolean collidesLeft = tileRect.contains(ent.collisionPoints[Entity.COL_LEFT]);
		boolean collidesUp = tileRect.contains(ent.collisionPoints[Entity.COL_UP]);
		boolean collidesRight = tileRect.contains(ent.collisionPoints[Entity.COL_RIGHT]);
		boolean collidesDown = tileRect.contains(ent.collisionPoints[Entity.COL_DOWN]);

		if(collidesDown) ent.y = tileRealY + Tiles.SIZE;
		else if(collidesUp) ent.y = tileRealY - ent.height;
		if(collidesLeft) ent.x = tileRealX + Tiles.SIZE;
		else if(collidesRight) ent.x = tileRealX - ent.width;;
		
		
	}

}
