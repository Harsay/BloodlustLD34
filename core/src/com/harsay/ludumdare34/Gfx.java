package com.harsay.ludumdare34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Gfx {
	
	public static BitmapFont font;
	public static TextureAtlas atlas;
	public static TextureRegion 
	floor, ceiling, wall, blood,
	enemyHalf1, enemyHalf2, 
	enemyHalfUp, enemyHalfDown,
	enemyHead, enemyNoHead;
	
	public static Array<TextureRegion> frames = new Array<TextureRegion>();

	public static void load() {
		// FUCK THIS
		// JUST REMEMBER
		// FONT HAS TOP LEFT CORNER COORDINATES!!!
		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("opensans.ttf"));
		//FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		//parameter.size = 48;
		//font = generator.generateFont(parameter);
		
		atlas = new TextureAtlas(Gdx.files.internal("game.atlas"));
		
		
		frames.add(atlas.findRegion("idle1"));
		frames.add(atlas.findRegion("idle2"));
		
		frames.add(atlas.findRegion("run1"));
		frames.add(atlas.findRegion("run2"));
		frames.add(atlas.findRegion("run3"));
		
		frames.add(atlas.findRegion("hitprepare"));
		
		frames.add(atlas.findRegion("hitdone"));

		frames.add(atlas.findRegion("enemywalk1"));
		frames.add(atlas.findRegion("enemywalk2"));
		frames.add(atlas.findRegion("enemywalk3"));
		frames.add(atlas.findRegion("enemywalk4"));

		frames.add(atlas.findRegion("enemyrun1"));
		frames.add(atlas.findRegion("enemyrun2"));
		frames.add(atlas.findRegion("enemyrun3"));

		frames.add(atlas.findRegion("enemyrunhead1"));
		frames.add(atlas.findRegion("enemyrunhead2"));
		frames.add(atlas.findRegion("enemyrunhead3"));

		floor = atlas.findRegion("tileFloor");
		ceiling = atlas.findRegion("tileWallBack");
		wall = atlas.findRegion("tileWallFront");
		
		enemyHalf1 = atlas.findRegion("enemyHalf1");
		enemyHalf2 = atlas.findRegion("enemyHalf2"); 
		enemyHalfUp = atlas.findRegion("enemyHalfUp");
		enemyHalfDown = atlas.findRegion("enemyHalfDown");
		enemyHead = atlas.findRegion("enemyHead");
		enemyNoHead = atlas.findRegion("enemyNoHead");
		blood = atlas.findRegion("blood");

	}
	
}
