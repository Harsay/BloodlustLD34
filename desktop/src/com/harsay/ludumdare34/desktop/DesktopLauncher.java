package com.harsay.ludumdare34.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.harsay.ludumdare34.Game;
import com.harsay.ludumdare34.Settings;



public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Settings.NATIVE_WIDTH*4;
		config.height = Settings.NATIVE_HEIGHT*4;
		config.title = "Bloodlust: Castle Of Cowards (Ludum Dare 34)";
        TexturePacker.process("../core/assets", "../core/assets", "game");

		new LwjglApplication(new Game(), config);
	}
}
