package com.projet.calculatrice;

public class Main {
    public static void main(String[] args) {
        // Lancer l'interface de sélection pour choisir Swing ou JavaFX
        javax.swing.SwingUtilities.invokeLater(() -> {
            SelectionView selectionView = new SelectionView();
            selectionView.setVisible(true);
        });
    }
}
