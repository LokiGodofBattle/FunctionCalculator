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

        String[] text = FunctionCalculator.FORMULAR.split(" ");

        Graph.a = Float.parseFloat(text[0]);
        Graph.b = Float.parseFloat(text[1]);
        Graph.c = Float.parseFloat(text[2]);
        Graph.d = Float.parseFloat(text[3]);
        if(text.length >= 5) Graph.range = Float.parseFloat(text[4]);
        else Graph.range = 5;
        if(text.length >= 6) FunctionCalculator.drawCurves = Boolean.parseBoolean(text[5]);
    }

    public static void render(){
        if(Gdx.input.justTouched()) Gdx.input.getTextInput(listener, "Input", "", "a b c d range");
    }

}
