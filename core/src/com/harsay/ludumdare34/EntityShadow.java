package com.harsay.ludumdare34;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.harsay.ludumdare34.entities.Entity;

public class EntityShadow {
	
	public static void draw(Entity ent, ShapeRenderer sr) {
		sr.setColor(0, 0, 0, 0.5f);
		float shadowWidth = ent.width * (50 - ent.z) / 50;
		float shadowHeight = (ent.width/2) * (50 - ent.z) / 50;
		if(shadowWidth > 0) sr.ellipse(ent.getCenterX() - shadowWidth/2, ent.y-(shadowHeight/2), shadowWidth, shadowHeight );
	}

}
