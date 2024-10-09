package com.projet.calculatrice;

import javax.swing.JButton; // Add this import
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorModel model;
    private CalculatorView view;
    private double firstNumber;
    private String operator;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        for (JButton button : view.getButtons()) {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                view.getTextField().setText(view.getTextField().getText() + command);
            } else if (command.equals("C")) {
                view.getTextField().setText("");
                firstNumber = 0;
                operator = "";
            } else if (command.equals("=")) {
                double secondNumber = Double.parseDouble(view.getTextField().getText());
                switch (operator) {
                    case "+":
                        model.add(firstNumber, secondNumber);
                        break;
                    case "-":
                        model.subtract(firstNumber, secondNumber);
                        break;
                    case "*":
                        model.multiply(firstNumber, secondNumber);
                        break;
                    case "/":
                        model.divide(firstNumber, secondNumber);
                        break;
                }
                view.getTextField().setText(String.valueOf(model.getResult()));
            } else {
                if (!view.getTextField().getText().isEmpty()) {
                    firstNumber = Double.parseDouble(view.getTextField().getText());
                    operator = command;
                    view.getTextField().setText("");
                }
            }
        } catch (ArithmeticException ex) {
            view.getTextField().setText(ex.getMessage());
        } catch (NumberFormatException ex) {
            view.getTextField().setText("Invalid input");
        }
    }
}