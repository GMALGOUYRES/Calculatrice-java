package com.projet.calculatrice;

public class CalculatorController {
    private CalculatorModel model;
    private ICalculatorView view;
    private double firstNumber;
    private String operator;
    private boolean newNumber = true;  // Pour indiquer si on commence un nouveau nombre

    public CalculatorController(CalculatorModel model, ICalculatorView view) {
        this.model = model;
        this.view = view;

        // On configure les boutons via la vue
        this.view.setButtonHandler(this::handleButtonAction);
    }

    private void handleButtonAction(String command) {
        try {
            if (command.matches("[0-9]")) {
                // Si un nouveau nombre commence, effacer le champ texte (après une opération)
                if (newNumber) {
                    view.setTextField("");
                    newNumber = false;
                }
                // Ajouter les chiffres à l'affichage
                view.setTextField(view.getTextField() + command);
            } else if (command.equals("-") && view.getTextField().isEmpty()) {
                // Si le champ est vide, et que "-" est cliqué, traiter comme un nombre négatif
                view.setTextField("-");
                newNumber = false;
            } else if (command.equals("C")) {
                // Remettre à zéro
                view.setTextField("");
                firstNumber = 0;
                operator = "";
                newNumber = true;
            } else if (command.equals("=")) {
                // Effectuer l'opération avec le second nombre
                double secondNumber = Double.parseDouble(view.getTextField());
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
                // Afficher le résultat et préparer pour un nouveau nombre
                view.setTextField(String.valueOf(model.getResult()));
                newNumber = true;
            } else {
                // Pour les opérateurs (+, -, *, /)
                if (!view.getTextField().isEmpty()) {
                    firstNumber = Double.parseDouble(view.getTextField());
                    operator = command;
                    view.setTextField("");
                    newNumber = true;  // Après un opérateur, on commence un nouveau nombre
                }
            }
        } catch (ArithmeticException ex) {
            view.setTextField(ex.getMessage());
        } catch (NumberFormatException ex) {
            view.setTextField("Entrée invalide");
        }
    }
}
