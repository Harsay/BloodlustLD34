package com.harsay.ludumdare34.levels;

import java.util.Comparator;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Sort;
import com.harsay.ludumdare34.Blood;
import com.harsay.ludumdare34.Collision;
import com.harsay.ludumdare34.Gfx;
import com.harsay.ludumdare34.Sfx;
import com.harsay.ludumdare34.Tiles;
import com.harsay.ludumdare34.entities.BodyPart;
import com.harsay.ludumdare34.entities.Enemy;
import com.harsay.ludumdare34.entities.Entity;
import com.harsay.ludumdare34.entities.Player;
import com.harsay.ludumdare34.screens.EndScreen;
import com.harsay.ludumdare34.screens.GameScreen;
import com.harsay.ludumdare34.screens.WinScreen;

public class Level {
	
	public int tilesWidth;
	public int tilesHeight;
	
	public IntArray map = new IntArray();
	public Array<Entity> entities = new Array<Entity>();
	
	int lvl = -1;
	
	Random rand = new Random();
	
	Sort s = new Sort();
	
	public Player player = null;
	
	GameScreen scr;
	
	Game game;
	
	public Level(GameScreen scr, Game game) {
		
		this.scr = scr;
		this.game = game;
		
		loadNextLevel();
		
	}
	
	public void loadNextLevel() {
		lvl++ ;
		
		entities.clear();
		
		map = Levels.level[lvl];
		tilesWidth = Levels.levelWidth[lvl];
		tilesHeight = Levels.levelHeight[lvl];
		check();
		
		scr.cam.position.set(player.getCenterX(), player.getCenterY(), 0);
	}
	
	public void update(float delta) {
				
		if(Gdx.input.isKeyJustPressed(Keys.K)) {
			entities.add(new Enemy(player.getCenterX(), player.getCenterY(), false));
		}
				
		s.sort(entities, new Comparator<Entity>() {
			@Override
			public int compare(Entity ent1, Entity ent2) {
				final float y1 = ent1.y+ent1.height;
				final float y2 = ent2.y+ent2.height;
				return y1 > y2 ? -1 : y1 < y2 ? 1 : 0;
			}
		});
		
		// Level bounds collision and updates and stuff
		for(int i=0; i<entities.size; i++) {
			Entity ent = entities.get(i);
			
			// update every entity
			ent.update(delta);
			
			// level bounds
			if(ent.x < 0) ent.x = 0;
			else if(ent.x+ent.width > getWidth()) ent.x = getWidth() - ent.width;
			if(ent.y < 0) ent.y = 0;
			else if(ent.y+ent.height > getHeight()) ent.y = getHeight() - ent.height;
			
			// player attack collision
			if(player.kills) {
				if(ent.getClass().getSimpleName().equals("Enemy")) {
					if(player.attackBounds.overlaps(new Rectangle(ent.x, ent.y, ent.width, ent.height))) {						
						switch(rand.nextInt(3)) {
						case 0: entities.add(new BodyPart(ent.x, ent.y, player.faces, 1, Gfx.enemyHalf1)); entities.add(new BodyPart(ent.x, ent.y, player.faces, -1, Gfx.enemyHalf2)); break;
						case 1: entities.add(new BodyPart(ent.x, ent.y, player.faces, -1, Gfx.enemyHalfDown)); entities.add(new BodyPart(ent.x, ent.y, player.faces, 1, Gfx.enemyHalfUp)); break;
						case 2: entities.add(new BodyPart(ent.x, ent.y, player.faces, -1, Gfx.enemyHead)); entities.add(new BodyPart(ent.x, ent.y, player.faces, 1, Gfx.enemyNoHead)); break;
						}
						
						entities.removeIndex(i);

						scr.shakeTime = 0.3f;
						
						player.addFury();
						
						Sfx.randomHit().play(0.2f);
						
						// Guys from Vlambeer said that it works. idk
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
			
		}
		
		// Collisions each other
		for(int i=0; i<entities.size; i++) {
			for(int j=0; j<entities.size; j++) {
				if(i == j) continue;
				Entity ent1 = entities.get(i);
				Entity ent2 = entities.get(j);
				if(ent1.collides(ent2)) {
					ent1.hadCollision = true;
					ent2.hadCollision = true;
					Collision.response(ent1, ent2);
				}
			}
		}
		
		// Tiles collision
		for(int i=0; i<entities.size; i++) {
			Entity ent = entities.get(i);
			ent.updateCollisionPoints();
			Vector2 tilePos = getTilePosition(ent);
			for(int x=-1; x<2; x++) {
				for(int y=-1; y<2; y++) {
					if(ent.collides(this, (int)tilePos.x+x, (int)tilePos.y+y)) {
						ent.hadCollision = true;
						Collision.response(ent, (int)tilePos.x+x, (int)tilePos.y+y);
					}
				}
			}
		}
		
		if(getTile(player) == Tiles.FINISH) {
			loadNextLevel();
		}
		
		if(player.fury < 0) {
			player.freeze = true;
			
			if(lvl != 5) game.setScreen(new EndScreen(game, player, scr.cam));
			else game.setScreen(new WinScreen(game, player, scr.cam));
		}
		
	}
	
	public void render(SpriteBatch sb, ShapeRenderer sr) {
		sb.begin();
		TextureRegion toDraw = Gfx.floor;
		for(int i=0; i<map.size; i++) {
			int val = map.get(i);
			
			switch(val) {
				default: toDraw = Gfx.floor; break;
				case Tiles.CEILING: toDraw = Gfx.ceiling; break;
				case Tiles.WALL: toDraw = Gfx.wall; break;
			}
			sb.draw(toDraw, (i%tilesWidth)*Tiles.SIZE, (tilesHeight * Tiles.SIZE) - Tiles.SIZE - ((int)Math.ceil(i/tilesWidth)*Tiles.SIZE));
		}
		sb.end();
		
		/*Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		sr.begin(ShapeType.Filled);
		for(int i=0; i<entities.size; i++) {
			//EntityShadow.draw(entities.get(i), sr);
		}
		sr.end();
	    Gdx.gl.glDisable(GL20.GL_BLEND);*/
		
		sb.begin();
		for(int i=0; i<entities.size; i++) {
			Entity ent = entities.get(i);
			for(int j=0; j<ent.bloods.size; j++) {
				Blood b = ent.bloods.get(j);
				if(getTile((int)Math.floor(b.x/Tiles.SIZE), (int)Math.floor(b.y/Tiles.SIZE)) != 0) {
					sb.draw(Gfx.blood, b.x, b.y);
				}
			}
		}
		
		for(int i=0; i<entities.size; i++) {
			entities.get(i).render(sb);
		}
		sb.end();

	}
	
	public void check() {
		for(int i=0; i<map.size; i++) {
			if(i + tilesWidth >= tilesWidth*tilesHeight) {
				//map.set(i, Tiles.CEILING);  
			}
			else if(i < tilesWidth && map.get(i) == 1) {
				map.set(i, Tiles.WALL);
			}
			else if(map.get(i) != 0) {
				int tileHigher = i - tilesWidth;
				if(tileHigher >= 0 && map.get(tileHigher) == 0) map.set(i, Tiles.WALL);
			}
			if(map.get(i) == Tiles.PLAYER) {
				Vector2 v = getTilePosFromWidth(i);
				if(player == null) player = new Player(v.x*Tiles.SIZE, v.y*Tiles.SIZE);
				else {
					player.x = v.x*Tiles.SIZE;
					player.y = v.y*Tiles.SIZE;
				}
				entities.add(player);
			}
			else if(map.get(i) == Tiles.ENEMY) {
				Vector2 v = getTilePosFromWidth(i);
				entities.add(new Enemy(v.x*Tiles.SIZE, v.y*Tiles.SIZE, lvl == 0));
			}
		}
	}
	
	public Vector2 getTilePosFromWidth(int width) {
		
		int y = tilesHeight - (int) Math.floor(width/tilesWidth) - 1;
		int x = (width%tilesWidth);
						
		return new Vector2(x, y);
	}
	
	public void debugRender(ShapeRenderer sr) {
		sr.setColor(Color.GREEN);
		for(int i=0; i<entities.size; i++) {
			entities.get(i).debugRender(sr);
		}
	}
	
	public int getWidth() {
		return tilesWidth*Tiles.SIZE;
	}
	
	public int getHeight() {
		return tilesHeight*Tiles.SIZE;
	}
	
	public Vector2 getTilePosition(Entity ent) {
		return new Vector2((int)Math.floor(ent.getCenterX()/Tiles.SIZE), (int)Math.floor(ent.getCenterY()/Tiles.SIZE));
	}
	
	public int getTile(Entity ent) {
		Vector2 v = getTilePosition(ent);
		return getTile((int)v.x, (int)v.y);
	}
	
	public int getTile(int x, int y) {
		int p = (((tilesHeight-1 - y) * tilesWidth) + x);
		if(p < 0 || p >= tilesWidth*tilesHeight) return -1;
		return map.get(p);
	}


}
