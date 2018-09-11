package unq.edu.ar.intropv.leandroantunez.minionone.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import unq.edu.ar.intropv.leandroantunez.minionone.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640;
		config.height = 360;
		new LwjglApplication(new MainGame(), config);
	}
}
