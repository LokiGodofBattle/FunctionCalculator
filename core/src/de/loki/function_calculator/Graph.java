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
        range = 5;

        a = 0;
        b = 0;
        c = 0;
        d = 0;
    }

    public static float[] getGraph(){
        float[] vertices = new float[FunctionCalculator.VIEWPORT_WIDTH/accuracy];

        float x = -range;

        //setzen der Vertices des Graphen, x, y in einem 1-Dimensionalen Array
        for(int i = 0; i<vertices.length; i++){
            if(i%2==0) vertices[i] = map(x, -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH);
            else{
                vertices[i] = map((float) (a*Math.pow(x, 3) +b*Math.pow(x, 2) + c*x + d), -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH)  + FunctionCalculator.getSizeDifference()/2;
                x += range*2/(vertices.length/2);
             }
        }

        return vertices;
    }

    //setzen der Vertices des Graphen der 1. Ableitung, x, y in einem 1-Dimensionalen Array
    public static float[] getGraphA1(){
        float[] vertices = new float[FunctionCalculator.VIEWPORT_WIDTH/accuracy];

        float x = -range;

        for(int i = 0; i<vertices.length; i++){
            if(i%2==0) vertices[i] = map(x, -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH);
            else{
                vertices[i] = map((float) (a*3*Math.pow(x, 2) +b*2*x + c), -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH)  + FunctionCalculator.getSizeDifference()/2;
                x += range*2/(vertices.length/2);
            }
        }

        return vertices;
    }

    //setzen der Vertices des Graphen der 2. Ableitung, x, y in einem 1-Dimensionalen Array
    public static float[] getGraphA2(){
        float[] vertices = new float[FunctionCalculator.VIEWPORT_WIDTH/accuracy];

        float x = -range;

        for(int i = 0; i<vertices.length; i++){
            if(i%2==0) vertices[i] = map(x, -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH);
            else{
                vertices[i] = map((a*6*x +b*2), -range, range, 0, FunctionCalculator.VIEWPORT_WIDTH)  + FunctionCalculator.getSizeDifference()/2;
                x += range*2/(vertices.length/2);
            }
        }

        return vertices;
    }

    //Funktion zum Mappen der Werte
    private static float map(float x1, float a1, float b1, float c1, float d1){
        return (x1-a1)/(b1-a1) * (d1-c1) + c1;
    }

}
