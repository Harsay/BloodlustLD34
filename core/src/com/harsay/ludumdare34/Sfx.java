package com.harsay.ludumdare34;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sfx {

	static Sound[] hit = new Sound[3];
	static Sound[] splat = new Sound[3];

	static Random rand = new Random();
	
	public static void load() {
		hit[0] = Gdx.audio.newSound(Gdx.files.internal("hit.wav"));
		hit[1] = Gdx.audio.newSound(Gdx.files.internal("hit2.wav"));
		hit[2] = Gdx.audio.newSound(Gdx.files.internal("hit3.wav"));
		splat[0] = Gdx.audio.newSound(Gdx.files.internal("splat.wav"));
		splat[1] = Gdx.audio.newSound(Gdx.files.internal("splat3.wav"));
		splat[2] = Gdx.audio.newSound(Gdx.files.internal("splat2.wav"));
	}
	
	public static Sound randomHit() {
		return hit[rand.nextInt(3)];
	}
	
	public static Sound randomSplat() {
		return splat[rand.nextInt(2)];
	}
	
}
