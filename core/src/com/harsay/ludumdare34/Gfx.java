package com.harsay.ludumdare34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Gfx {
	
	public static BitmapFont font;
	public static Texture playerTest, playerTest2, wall, ceiling, floor;

	public static void load() {
		// FUCK THIS
		// JUST REMEMBER
		// FONT HAS TOP LEFT CORNER COORDINATES!!!
		//FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("opensans.ttf"));
		//FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		//parameter.size = 48;
		//font = generator.generateFont(parameter);
		
		playerTest = new Texture(Gdx.files.internal("playerTest.png"));
		playerTest2 = new Texture(Gdx.files.internal("playerTest2.png"));
		floor = new Texture(Gdx.files.internal("tileFloor.png"));
		ceiling = new Texture(Gdx.files.internal("tileWallBack.png"));
		wall = new Texture(Gdx.files.internal("tileWallFront.png"));

	}
	
}
