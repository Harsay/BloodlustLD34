package com.harsay.ludumdare34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Gfx {
	
	public static BitmapFont font;
	public static Texture playerTest, tileTest;

	public static void load() {
		// FUCK THIS
		// JUST REMEMBER
		// FONT HAS TOP LEFT CORNER COORDINATES!!!
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("opensans.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 48;
		font = generator.generateFont(parameter);
		
		playerTest = new Texture(Gdx.files.internal("playerTest.png"));
		tileTest = new Texture(Gdx.files.internal("tileTest.png"));
	}
	
}
