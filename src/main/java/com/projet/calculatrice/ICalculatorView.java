package com.projet.calculatrice;

public interface ICalculatorView {
    void setTextField(String value);
    String getTextField();
    void setButtonHandler(ButtonHandler handler);

    @FunctionalInterface
    interface ButtonHandler {
        void handle(String command);
    }
}
