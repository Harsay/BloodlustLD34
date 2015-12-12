package com.harsay.ludumdare34.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.harsay.ludumdare34.Game;
import com.harsay.ludumdare34.Settings;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(Settings.NATIVE_WIDTH, Settings.NATIVE_HEIGHT);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new Game();
        }
}