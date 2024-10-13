package com.projet.calculatrice;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;

public class CalculatorViewFX extends Application implements ICalculatorView {

    private TextField textField = new TextField();
    private Button[] buttons = new Button[16];
    private String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // Configurer le TextField
        textField.setEditable(false);
        textField.setAlignment(Pos.CENTER_RIGHT);

        // Configurer les boutons dans une GridPane
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        int index = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[index] = new Button(buttonLabels[index]);
                buttons[index].setMinSize(50, 50);
                gridPane.add(buttons[index], col, row);
                index++;
            }
        }

        // Organisation principale dans un VBox
        VBox root = new VBox(20, textField, gridPane);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 10;");

        // Création de la scène et affichage
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialisation du modèle et du contrôleur après l'interface
        CalculatorModel model = new CalculatorModel();
        new CalculatorController(model, this);
    }

    @Override
    public void setTextField(String value) {
        textField.setText(value);
    }

    @Override
    public String getTextField() {
        return textField.getText();
    }

    @Override
    public void setButtonHandler(ButtonHandler handler) {
        for (Button button : buttons) {
            button.setOnAction(e -> handler.handle(button.getText()));
        }
    }
}
