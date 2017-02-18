package de.loki.function_calculator;

import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Loki on 18.02.2017.
 */
public class Graph {

    public static int accuracy;
    public static float range;

    public static void init(){
        accuracy = 2;
        range = 100;
    }

    public static float[] getGraph(){
        float[] vertices = new float[FunctionCalculator.VIEWPORT_WIDTH/accuracy];

        float x = -range;

        for(int i = 0; i<vertices.length; i++){
            if(i%2==0) vertices[i] = map(x, -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH);
            else{
                vertices[i] = map((float) Math.pow(x, 2), -range, range, 0, FunctionCalculator.getViewportHeight());
                x += range*2/(vertices.length/2);
             }
        }

        return vertices;
    }

    private static float map(float x, float a, float b, float c, float d){
        return (x-a)/(b-a) * (d-c) + c;
    }

}
