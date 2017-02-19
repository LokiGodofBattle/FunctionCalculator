package de.loki.function_calculator.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.loki.function_calculator.FunctionCalculator;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 1080;
		config.height = 1920;
		config.fullscreen = false;
		config.resizable = false;

		new LwjglApplication(new FunctionCalculator(), config);
	}
}
