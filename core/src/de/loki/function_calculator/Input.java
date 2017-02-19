package de.loki.function_calculator;

/**
 * Created by Loki on 19.02.2017.
 */
public class Input {

    public static void read(){
        Graph.a = Float.parseFloat(FunctionCalculator.FORMULAR.substring(0, 1));
        Graph.b = Float.parseFloat(FunctionCalculator.FORMULAR.substring(2, 3));
        Graph.c = Float.parseFloat(FunctionCalculator.FORMULAR.substring(4, 5));
        Graph.d = Float.parseFloat(FunctionCalculator.FORMULAR.substring(6, 7));
    }

}
