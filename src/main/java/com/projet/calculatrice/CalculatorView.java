package com.projet.calculatrice;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    @Getter
    private JTextField textField = new JTextField();
    @Getter
    private JButton[] buttons = new JButton[16];
    private String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
    };

    public CalculatorView() {
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            panel.add(buttons[i]);
        }

        add(panel, BorderLayout.CENTER);
    }

}