package de.loki.function_calculator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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
	public static String FORMULAR;
	public static boolean drawCurves;
	private static BitmapFont font;
	private static FreeTypeFontGenerator ftfGenerator;
	private static FreeTypeFontGenerator.FreeTypeFontParameter ftfParameter;
	private static SpriteBatch batch;
	private static GlyphLayout glyphLayout;
	
	@Override
	public void create () {

		//Variable die ausgelesen wird -  a b c d e range complete?
		FORMULAR = "1 0 -5 0 4";
		drawCurves = true;

		ftfGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Calibri.ttf"));
		ftfParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		ftfParameter.size = 75;
		ftfParameter.color = Color.BLACK;
		ftfParameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?:-+";

		font = ftfGenerator.generateFont(ftfParameter);

		glyphLayout = new GlyphLayout();

		shapeRenderer = new ShapeRenderer();
		batch = new SpriteBatch();

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

		//Initialisierungen
		Calculation.init();
		Graph.init();
		FunctionCalculatorInput.init();
		CoordinateSystem.init();
		FunctionCalculatorInput.read();

		Calculation.calculateZeropoints();

		Gdx.gl20.glLineWidth(5);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Rendern
		FunctionCalculatorInput.render();

		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

		//Zeichnen
		CoordinateSystem.draw(shapeRenderer);

		shapeRenderer.setColor(Color.RED);
		shapeRenderer.polyline(Graph.getGraph());

		shapeRenderer.setColor(Color.GREEN);
		//Abfrage zum vermeiden von Funktionen ohne x
		if(Graph.c != 0 && drawCurves)shapeRenderer.polyline(Graph.getGraphA1());

		shapeRenderer.setColor(Color.BLUE);
		//Abfrage zum vermeiden von Funktionen ohne x
		if((Graph.b != 0 || Graph.a != 0) && drawCurves)shapeRenderer.polyline(Graph.getGraphA2());
		shapeRenderer.end();

		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		CoordinateSystem.drawText(batch, font, glyphLayout);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
		camera.position.set(VIEWPORT_WIDTH / 2f, VIEWPORT_WIDTH * aspect_ratio / 2f, 0);
	}

	public static float getSizeDifference(){
		return getViewportHeight() - VIEWPORT_WIDTH;
	}

	public static float getViewportHeight(){
		return VIEWPORT_WIDTH * aspect_ratio;
	}
}
