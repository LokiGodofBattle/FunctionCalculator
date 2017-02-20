package de.loki.function_calculator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Loki on 18.02.2017.
 */
public class CoordinateSystem {

    public static int markerWidth;

    public static void init(){
        markerWidth = 50;
    }

    public static void draw(ShapeRenderer shapeRenderer) {

        Gdx.gl20.glLineWidth(2);

        shapeRenderer.setColor(Color.BLACK);

        for(int i = 0; i<Graph.range*2 - 1; i++){
            shapeRenderer.line((i+1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)), 0, (i+1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)), FunctionCalculator.getViewportHeight());
        }

        for(int i = 0; i<Graph.range*2 - 1; i++){
            shapeRenderer.line(0, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                                         FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

        for(int i = 0; i<Graph.range*2 - 1; i++){
            shapeRenderer.line(0, FunctionCalculator.getViewportHeight()/2 + (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                    FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight()/2 + (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

        shapeRenderer.end();
        Gdx.gl20.glLineWidth(5);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH/2, 0, FunctionCalculator.VIEWPORT_WIDTH/2, FunctionCalculator.getViewportHeight());
        shapeRenderer.line(0, FunctionCalculator.getViewportHeight() / 2, FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight() / 2);

        for(int i = 0; i<Graph.range*2-1; i++){
            shapeRenderer.line((i+1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)), FunctionCalculator.getViewportHeight()/2-markerWidth/2, (i+1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)), FunctionCalculator.getViewportHeight()/2+markerWidth/2);
        }

        for(int i = 0; i<Graph.range*2-1; i++){
            shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH/2 - markerWidth/2, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                                FunctionCalculator.VIEWPORT_WIDTH/2 + markerWidth/2, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

        for(int i = 0; i<Graph.range*2-1; i++){
            shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH/2 - markerWidth/2, FunctionCalculator.getViewportHeight()/2 + (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                    FunctionCalculator.VIEWPORT_WIDTH/2 + markerWidth/2, FunctionCalculator.getViewportHeight()/2 + (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

    }

}
