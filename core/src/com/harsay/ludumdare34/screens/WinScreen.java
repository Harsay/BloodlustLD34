package com.harsay.ludumdare34.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector3;
import com.harsay.ludumdare34.Gfx;
import com.harsay.ludumdare34.entities.Player;

public class WinScreen  extends GameScreen {
	
	Player player;
	
	GlyphLayout l, k;

	public WinScreen(Game game, Player player, OrthographicCamera cam) {
		super(game);
		this.cam = cam;
		this.player = player;
		clearColor = new Color(15/255f, 15/255f, 15/255f, 1);
		backgroundColor = clearColor;
		l = new GlyphLayout(Gfx.font, "FINISHED! Thanks for playing!");
		k = new GlyphLayout(Gfx.font, "Press ENTER to start again.");
	}
	
	public void update(float delta) {
		super.update(delta);
		cam.position.lerp(new Vector3(player.getCenterX(),player.getCenterY(), 0), 1f*delta);
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			game.setScreen(new WelcomeScreen(game));
		}
		
	}
	
	public void render(float delta) {
		super.render(delta);
		
		sb.begin();
		player.render(sb);
	
		Gfx.font.draw(sb, l, player.getCenterX()-l.width/2, player.getCenterY()+50);
		Gfx.font.draw(sb, k, player.getCenterX()-k.width/2, player.getCenterY()-50);

		sb.end();
	}
}
