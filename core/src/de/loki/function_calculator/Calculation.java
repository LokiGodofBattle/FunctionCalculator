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


    //Oberste Methode die aufgerufen wird für die Berechnung
    public static void calculateZeropoints(){

        graphZeroPoints.clear();

        if(Graph.a != 0) calculateZeropointsG4();
        else if(Graph.b != 0) calculateZeropointsG3();
        else if(Graph.c != 0) calculateZeropointsG2();
        else calculateZeropointsG1();

        for(int i = 0; i<graphZeroPoints.size; i++){
            Gdx.app.log("debug", "" + graphZeroPoints.get(i));
        }

    }

    //Methode zum raten der ersten Nullstelle
    private static float getFirstZeropoint(float range){
        for(int i = 0; i<range*2+1; i++){
            if((Graph.a*Math.pow(i-range, 4) +Graph.b*Math.pow(i-range, 3) + Graph.c*Math.pow(i-range, 2)+ Graph.d*(i-range) + Graph.e) == 0) return i-range;
        }
        return 0;
    }

    //Methode für die ABC- oder Mitternachts Formel
    private static float[] getABCZeropoints(float a,float b,float c){

        float[] floats = new float[2];

        if((Math.pow(b, 2) - 4*a*c)>0) {
            floats[0] = (float) ((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
            floats[1] = (float) ((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
        }

        return floats;
    }

    //Methode zur Berechnung der Nullstellen für eine Funktion 4. Grades (nur Substitution)
    private static void calculateZeropointsG4(){

        float[] floats = getABCZeropoints(Graph.a, Graph.c, Graph.e);

        if(floats[0] >= 0){
            graphZeroPoints.add((float) Math.sqrt(floats[0]));
            graphZeroPoints.add((float) -Math.sqrt(floats[0]));
        }

        if(floats[1] >= 0){
            graphZeroPoints.add((float) Math.sqrt(floats[1]));
            graphZeroPoints.add((float) -Math.sqrt(floats[1]));
        }

    }

    //Methode zur Berechnung der Nullstellen für eine Funktion 3. Grades
    private static void calculateZeropointsG3(){

        float n1, n2, n3;
        float a, b, c;

        n1 = getFirstZeropoint(Graph.e);
        graphZeroPoints.add(n1);

        a = Graph.b;
        b = Graph.c + a*n1;
        c = Graph.d + b*n1;

        float[] floats = getABCZeropoints(a, b, c);

        if(floats.length>0){
            n2 = floats[0];
            n3 = floats[1];

            graphZeroPoints.add(n2);
            graphZeroPoints.add(n3);
        }

    }

    //Methode zur Berechnung der Nullstellen für eine quadratische Grades
    private static void calculateZeropointsG2(){
        graphZeroPoints.clear();

        float n1, n2;

        float[] floats = getABCZeropoints(Graph.b, Graph.c, Graph.d);

        n1 = floats[0];
        n2 = floats[1];

        graphZeroPoints.add(n1);
        graphZeroPoints.add(n2);
    }

    //Methode zur Berechnung der Nullstellen für eine Funktion 1. Grades
    private static void calculateZeropointsG1(){
        graphZeroPoints.clear();

        float n1;

        if(Graph.c != 0) n1 = -Graph.d/Graph.c;
        else n1 = -Graph.d;

        graphZeroPoints.add(n1);
    }

}
