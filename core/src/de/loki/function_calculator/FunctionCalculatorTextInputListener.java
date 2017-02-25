package de.loki.function_calculator;

import com.badlogic.gdx.Input;

/**
 * Created by Loki on 19.02.2017.
 */
public class FunctionCalculatorTextInputListener implements Input.TextInputListener {
    @Override
    public void input(String text) {
        //Eingabe des Textes
        FunctionCalculator.FORMULAR = text;
        FunctionCalculatorInput.read();
    }

    @Override
    public void canceled() {

    }
}
