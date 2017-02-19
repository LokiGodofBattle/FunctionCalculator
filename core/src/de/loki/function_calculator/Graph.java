package de.loki.function_calculator;

/**
 * Created by Loki on 18.02.2017.
 */
public class Graph {

    public static int accuracy;
    public static float range;
    public static float a;
    public static float b;
    public static float c;
    public static float d;

    public static void init(){
        accuracy = 2;
        range = 10;

        a = 0;
        b = 0;
        c = 0;
        d = 0;
    }

    public static float[] getGraph(){
        float[] vertices = new float[FunctionCalculator.VIEWPORT_WIDTH/accuracy];

        float x = -range;

        for(int i = 0; i<vertices.length; i++){
            if(i%2==0) vertices[i] = map(x, -range, range, 0, FunctionCalculator.getViewportHeight()) + (FunctionCalculator.VIEWPORT_WIDTH-FunctionCalculator.getViewportHeight())/2;
            else{
                vertices[i] = map((float) (a*Math.pow(x, 3) + b*Math.pow(x, 2) +c*x + d), -range, range, 0, FunctionCalculator.getViewportHeight());
                x += range*2/(vertices.length/2);
             }
        }

        return vertices;
    }

    private static float map(float x, float a, float b, float c, float d){
        return (x-a)/(b-a) * (d-c) + c;
    }

}
