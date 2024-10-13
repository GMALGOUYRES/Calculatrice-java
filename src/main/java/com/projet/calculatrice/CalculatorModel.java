package com.projet.calculatrice;

public class CalculatorModel {
    private double result;

    public void add(double firstNumber, double secondNumber) {
        result = firstNumber + secondNumber;
    }

    public void subtract(double firstNumber, double secondNumber) {
        result = firstNumber - secondNumber;
    }

    public void multiply(double firstNumber, double secondNumber) {
        result = firstNumber * secondNumber;
    }

    public void divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Impossible de diviser par zéro");
        }
        result = firstNumber / secondNumber;
    }

    public double getResult() {
        return result;
    }
}