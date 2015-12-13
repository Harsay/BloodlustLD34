package com.harsay.ludumdare34.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.harsay.ludumdare34.Gfx;
import com.harsay.ludumdare34.Settings;

public class WelcomeScreen extends GameScreen {

	public GlyphLayout l, k, s;
	
	public WelcomeScreen(Game game) {
		super(game);
		l = new GlyphLayout(Gfx.font, "BLOODLUST");
		k = new GlyphLayout(Gfx.font, "Castle Of Cowards");
		s = new GlyphLayout(Gfx.font, "Press ENTER to play.");
	}
	
	public void update(float delta) {
		super.update(delta);
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			game.setScreen(new PlayScreen(game));
		}
		
	}
	
	public void render(float delta) {
		super.render(delta);
		
		sb.begin();
	
		Gfx.font.draw(sb, l, Settings.NATIVE_WIDTH/2-l.width/2, Settings.NATIVE_HEIGHT/2+l.height/2+25);
		Gfx.font.draw(sb, k, Settings.NATIVE_WIDTH/2-k.width/2, Settings.NATIVE_HEIGHT/2+k.height/2-15+25);
		Gfx.font.draw(sb, s, Settings.NATIVE_WIDTH/2-s.width/2, Settings.NATIVE_HEIGHT/2+s.height/2-30);

		sb.end();
	}
}
