package de.loki.function_calculator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Loki on 18.02.2017.
 */
public class CoordinateSystem {

    public static void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH/2, 0, FunctionCalculator.VIEWPORT_WIDTH/2, FunctionCalculator.getViewportHeight());
        shapeRenderer.line(0, FunctionCalculator.getViewportHeight()/2, FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight()/2);
    }

}
