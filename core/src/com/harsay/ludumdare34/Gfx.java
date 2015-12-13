package com.harsay.ludumdare34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Gfx {
	
	public static BitmapFont font;
	public static TextureAtlas atlas;
	public static TextureRegion 
	floor, ceiling, wall, playerIdle1, playerIdle2, playerRun1, playerRun2, playerRun3, playerPrepare, playerAttacked;

	public static void load() {
		// FUCK THIS
		// JUST REMEMBER
		// FONT HAS TOP LEFT CORNER COORDINATES!!!
		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("opensans.ttf"));
		//FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		//parameter.size = 48;
		//font = generator.generateFont(parameter);
		
		atlas = new TextureAtlas(Gdx.files.internal("game.atlas"));
		
		
		playerIdle1 = atlas.findRegion("idle1");
		playerIdle2 = atlas.findRegion("idle2");
		playerRun1 = atlas.findRegion("run1");
		playerRun2 = atlas.findRegion("run2");
		playerRun3 = atlas.findRegion("run3");
		playerPrepare = atlas.findRegion("hitprepare");
		playerAttacked = atlas.findRegion("hitdone");


		floor = atlas.findRegion("tileFloor");
		ceiling = atlas.findRegion("tileWallBack");
		wall = atlas.findRegion("tileWallFront");

	}
	
}
