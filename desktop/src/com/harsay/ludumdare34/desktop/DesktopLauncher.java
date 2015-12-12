package com.harsay.ludumdare34.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.harsay.ludumdare34.Game;
import com.harsay.ludumdare34.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Settings.NATIVE_WIDTH;
		config.height = Settings.NATIVE_HEIGHT;
		config.title = "LudumDare 34";
		new LwjglApplication(new Game(), config);
	}
}
