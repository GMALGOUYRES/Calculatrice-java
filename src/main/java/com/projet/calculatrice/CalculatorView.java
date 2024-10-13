package com.projet.calculatrice;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame implements ICalculatorView {
    private JTextField textField = new JTextField();
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
        for (JButton button : buttons) {
            button.addActionListener(e -> handler.handle(button.getText()));
        }
    }
}
