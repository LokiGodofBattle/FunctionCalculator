package de.loki.function_calculator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class FunctionCalculator extends ApplicationAdapter {

	private ShapeRenderer shapeRenderer;
	private static OrthographicCamera camera;
	private Viewport viewport;
	public final static int VIEWPORT_WIDTH = 2560;
	private static float aspect_ratio;
	private static float scale;
	
	@Override
	public void create () {

		shapeRenderer = new ShapeRenderer();

		//Ausrechnen des Größenverhältnisses des Geräts
		aspect_ratio = Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

		//Ausrechnung Scalierung des Gerätes (Echte Bildschirmauflösung - Auflösung des Viewports)
		scale = Gdx.graphics.getWidth() / (float) VIEWPORT_WIDTH;

		camera = new OrthographicCamera();

		//FitViewport damit es auf allen Geräten gleich aussieht
		viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_WIDTH*aspect_ratio, camera);
		viewport.apply();

		//Kamera zentrieren
		camera.position.set(VIEWPORT_WIDTH / 2f, VIEWPORT_WIDTH * aspect_ratio / 2f, 0);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

		shapeRenderer.end();
	}

	public static float getViewportHeight(){
		return VIEWPORT_WIDTH * aspect_ratio;
	}
}
