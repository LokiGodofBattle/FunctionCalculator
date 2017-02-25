package de.loki.function_calculator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Loki on 18.02.2017.
 */
public class CoordinateSystem {

    //Länge der Linien die die 1er Schritte makieren
    public static int markerWidth;

    public static void init(){
        markerWidth = 50;
    }

    public static void draw(ShapeRenderer shapeRenderer) {

        Gdx.gl20.glLineWidth(2);

        shapeRenderer.setColor(Color.BLACK);

        //Zeichnen der Vertikalen Linien vom linken Rand aus
        for(int i = 0; i<Graph.range*2 - 1; i++){
            shapeRenderer.line((i + 1) * (FunctionCalculator.VIEWPORT_WIDTH / (Graph.range * 2)), 0, (i + 1) * (FunctionCalculator.VIEWPORT_WIDTH / (Graph.range * 2)), FunctionCalculator.getViewportHeight());
        }

        //Zeichnen der Horizontalen Linien von der Mitte nach unten
        for(int i = 0; i<Graph.range*2 - 1; i++){
            shapeRenderer.line(0, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                                         FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

        //Zeichnen der Horizontalen Linien von der Mitte nach oben
        for(int i = 0; i<Graph.range*2 - 1; i++){
            shapeRenderer.line(0, FunctionCalculator.getViewportHeight()/2 + (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                    FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight()/2 + (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

        shapeRenderer.end();
        Gdx.gl20.glLineWidth(5);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        //Zeichnen der X- und Y- Achsen
        shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH/2, 0, FunctionCalculator.VIEWPORT_WIDTH/2, FunctionCalculator.getViewportHeight());
        shapeRenderer.line(0, FunctionCalculator.getViewportHeight() / 2, FunctionCalculator.VIEWPORT_WIDTH, FunctionCalculator.getViewportHeight() / 2);

        //Zeichnen der Marker auf der X-Achse vom linken Rand aus
        for(int i = 0; i<Graph.range*2-1; i++){
            shapeRenderer.line((i+1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)), FunctionCalculator.getViewportHeight()/2-markerWidth/2, (i+1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)), FunctionCalculator.getViewportHeight()/2+markerWidth/2);
        }

        //Zeichnen der Marker auf der Y-Achse von der Mitte aus nach unten
        for(int i = 0; i<Graph.range*2-1; i++){
            shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH/2 - markerWidth/2, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)),
                                FunctionCalculator.VIEWPORT_WIDTH/2 + markerWidth/2, FunctionCalculator.getViewportHeight()/2 - (i + 1)*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
        }

        //Zeichnen der Marker auf der Y-Achse von der Mitte aus nach oben
        for(int i = 0; i<Graph.range*2-1; i++){
            shapeRenderer.line(FunctionCalculator.VIEWPORT_WIDTH / 2 - markerWidth / 2, FunctionCalculator.getViewportHeight() / 2 + (i + 1) * (FunctionCalculator.VIEWPORT_WIDTH / (Graph.range * 2)),
                    FunctionCalculator.VIEWPORT_WIDTH / 2 + markerWidth / 2, FunctionCalculator.getViewportHeight() / 2 + (i + 1) * (FunctionCalculator.VIEWPORT_WIDTH / (Graph.range * 2)));
        }

    }

    //Zeichnen der Beschriftungen an den Achsen
    public static void drawText(SpriteBatch batch, BitmapFont font, GlyphLayout glyphLayout){
        float x = -Graph.range;
        float y = 0;
        float z = 0;

        //X-Achse vom linken Rand aus
        for(int i = 0; i<Graph.range*2; i++) {
            if(x != 0)font.draw(batch, "" + (int) x, i * (FunctionCalculator.VIEWPORT_WIDTH / (Graph.range * 2)), FunctionCalculator.getViewportHeight()/2 - 50);
            x++;
        }

        //Y-Achse von der Mittelline nach unten
        for(int i = 0; i<Graph.range*2; i++){
            glyphLayout.setText(font, "" + (int) y);
            if(y != 0)font.draw(batch, "" + (int) y, FunctionCalculator.VIEWPORT_WIDTH/2 -glyphLayout.width -50, FunctionCalculator.getViewportHeight()/2 - i*(FunctionCalculator.VIEWPORT_WIDTH/(Graph.range*2)));
            y--;
        }

        //Y-Achse von der Mittelline nach oben
        for(int i = 0; i<Graph.range*2; i++){
            glyphLayout.setText(font, "" + (int) z);
            if(z != 0)font.draw(batch, "" + (int) z, FunctionCalculator.VIEWPORT_WIDTH/2 -glyphLayout.width -50, FunctionCalculator.getViewportHeight() / 2 + i * (FunctionCalculator.VIEWPORT_WIDTH / (Graph.range * 2)));
            z++;
        }

    }

}
