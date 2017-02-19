package de.loki.function_calculator;

import com.badlogic.gdx.Gdx;

/**
 * Created by Loki on 19.02.2017.
 */
public class FunctionCalculatorInput {

    private static FunctionCalculatorTextInputListener listener;

    public static void init() {
        listener = new FunctionCalculatorTextInputListener();
    }

    public static void read(){
        Graph.a = Float.parseFloat(FunctionCalculator.FORMULAR.substring(0, 2));
        Graph.b = Float.parseFloat(FunctionCalculator.FORMULAR.substring(3, 5));
        Graph.c = Float.parseFloat(FunctionCalculator.FORMULAR.substring(6, 8));
        Graph.d = Float.parseFloat(FunctionCalculator.FORMULAR.substring(9, 11));
        Graph.range = Float.parseFloat(FunctionCalculator.FORMULAR.substring(12));
    }

    public static void render(){
        if(Gdx.input.justTouched()) Gdx.input.getTextInput(listener, "Input", "", "a|b|c|d");
    }

}
