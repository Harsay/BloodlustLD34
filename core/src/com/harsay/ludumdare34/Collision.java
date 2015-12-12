package com.harsay.ludumdare34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
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

}
