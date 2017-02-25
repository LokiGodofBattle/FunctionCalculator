package de.loki.function_calculator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Loki on 25.02.2017.
 */
public class Calculation {

    public static Array<Float> graphZeroPoints;

    public static void init(){
        graphZeroPoints = new Array<Float>();
    }

    public static void calculateZeropoints(){

        graphZeroPoints.clear();

        if(Graph.a != 0) calculateZeropointsG3();
        else if(Graph.b != 0) calculateZeropointsG2();
        else claculateZeropointsG1();

        for(int i = 0; i<graphZeroPoints.size; i++){
            Gdx.app.log("debug", "" + graphZeroPoints.get(i));
        }

    }

    private static float getFirstZeropoint(float range){
        for(int i = 0; i<range*2+1; i++){
            if((Graph.a*Math.pow(i-range, 3) +Graph.b*Math.pow(i-range, 2) + Graph.c*(i-range) + Graph.d) == 0) return i-range;
        }
        return 0;
    }

    private static float[] getABCZeropoints(float a,float b,float c){

        float[] floats = new float[2];

        if((Math.pow(b, 2) - 4*a*c)>0) {
            floats[0] = (float) ((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
            Gdx.app.log("debug3", "" + floats[0]);
            floats[1] = (float) ((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
        }

        return floats;
    }

    private static void calculateZeropointsG3(){

        float n1, n2, n3;
        float a, b, c;

        n1 = getFirstZeropoint(Graph.d);
        graphZeroPoints.add(n1);

        a = Graph.a;
        b = Graph.b + a*n1;
        c = Graph.c + b*n1;

        Gdx.app.log("debug2", "a " + a);
        Gdx.app.log("debug2", "b " + b);
        Gdx.app.log("debug2", "c " + c);

        float[] floats = getABCZeropoints(a, b, c);

        if(floats.length>0){
            n2 = floats[0];
            n3 = floats[1];

            graphZeroPoints.add(n2);
            graphZeroPoints.add(n3);
        }

    }

    private static void calculateZeropointsG2(){
        graphZeroPoints.clear();

        float n1, n2;

        float[] floats = getABCZeropoints(Graph.b, Graph.c, Graph.d);

        n1 = floats[0];
        n2 = floats[1];

        graphZeroPoints.add(n1);
        graphZeroPoints.add(n2);
    }

    private static void claculateZeropointsG1(){
        graphZeroPoints.clear();

        float n1;

        if(Graph.c != 0) n1 = -Graph.d/Graph.c;
        else n1 = -Graph.d;

        graphZeroPoints.add(n1);
    }

}
