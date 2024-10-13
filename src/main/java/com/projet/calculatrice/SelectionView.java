package com.projet.calculatrice;

import javax.swing.*;
import java.awt.*;

public class SelectionView extends JFrame {

    public SelectionView() {
        setTitle("Choix d'interface graphique");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Bouton pour choisir Swing
        JButton swingButton = new JButton("Lancer avec Swing");
        swingButton.addActionListener(e -> launchSwing());

        // Bouton pour choisir JavaFX
        JButton javafxButton = new JButton("Lancer avec JavaFX");
        javafxButton.addActionListener(e -> launchJavaFX());

        // Ajouter les boutons à la fenêtre
        add(swingButton);
        add(javafxButton);
    }

    private void launchSwing() {
        // Fermer la fenêtre de sélection
        this.dispose();

        // Lancer l'application avec Swing
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();
            CalculatorView swingView = new CalculatorView();
            new CalculatorController(model, swingView);
            swingView.setVisible(true);
        });
    }

    private void launchJavaFX() {
        // Fermer la fenêtre de sélection
        this.dispose();

        // Lancer JavaFX dans son propre thread
        new Thread(() -> {
            // Appeler la méthode launch de JavaFX, qui va déclencher la méthode start()
            javafx.application.Application.launch(CalculatorViewFX.class);
        }).start();
    }
}
