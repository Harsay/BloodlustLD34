package com.harsay.ludumdare34.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.harsay.ludumdare34.Gfx;
import com.harsay.ludumdare34.Tiles;
import com.harsay.ludumdare34.entities.Enemy;
import com.harsay.ludumdare34.entities.Player;

public class Level {
	
	public int tilesWidth = 15;
	public int tilesHeight = 9;
	
	public IntArray map = new IntArray();
	public Array<Enemy> enemies = new Array<Enemy>();
	
	Player player;
	
	public Level() {
		
		player = new Player(0, 0);
		enemies.add(new Enemy(100, 100));
		
		map.addAll(
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
		);
		
	}
	
	public void update(float delta) {
		
		for(int i=0; i<enemies.size; i++) {
			enemies.get(i).update(delta);
		}
		
		player.update(delta);
	}
	
	public void render(SpriteBatch sb) {
		
		for(int i=0; i<map.size; i++) {
			if(map.get(i) == 1) sb.draw(Gfx.tileTest, (i%tilesWidth)*Tiles.SIZE, (tilesHeight * Tiles.SIZE) - Tiles.SIZE - ((int)Math.ceil(i/tilesWidth)*Tiles.SIZE));
		}
		
		for(int i=0; i<enemies.size; i++) {
			enemies.get(i).render(sb);
		}
		
		player.render(sb);
	}
	
	public int getWidth() {
		return tilesWidth*Tiles.SIZE;
	}
	
	public int getHeight() {
		return tilesHeight*Tiles.SIZE;
	}

}
