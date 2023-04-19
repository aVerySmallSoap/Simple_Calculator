package Graphics;

import Graphics.CustomComponents.Button;
import Interfaces.IGraphics;
import actionEvents.onHistoryClickEvent;
import com.formdev.flatlaf.FlatLightLaf;
import actionEvents.onEqualClickEvent;

import javax.swing.*;
import java.awt.*;

public class CalculatorG implements IGraphics {

    ImageIcon Logo = new ImageIcon("./src/Images/Logo_256.png");
    ImageIcon history = new ImageIcon("./src/Images/icon_history.png");

    @Override
    public void Draw() {
        FlatLightLaf.setup();
        JFrame frame = new JFrame("Calculator");
        JPanel topPanel = new JPanel();
        JPanel viewPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JButton historyButton = new JButton(history);
        JTextField numF = new JTextField();
        Button clear = new Button("CLS");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button bAdd = new Button("+");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button bSub = new Button("-");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button bMul = new Button("*");
        Button bDot = new Button(".");
        Button button0 = new Button("0");
        Button bDiv = new Button("/");
        Button bEquals = new Button("=");

        frame.setVisible(true);
        frame.setIconImage(Logo.getImage());
        frame.setSize(new Dimension(375,500));
        frame.setLayout(new GridLayout(2,1));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(topPanel);
        frame.add(viewPanel);
        frame.add(buttonsPanel);

        viewPanel.setLayout(new GridLayout(3,1));
        viewPanel.add(topPanel);
        viewPanel.add(numF);
        numF.setFocusable(false);
        topPanel.setLayout(new FlowLayout());
        topPanel.add(Box.createHorizontalStrut(300));
        topPanel.add(historyButton);
        historyButton.setFocusPainted(false);

        buttonsPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonsPanel.add(Box.createRigidArea(null));
        buttonsPanel.add(Box.createRigidArea(null));
        buttonsPanel.add(Box.createRigidArea(null));
        buttonsPanel.add(clear);
        historyButton.addActionListener(e ->
                {
                    onHistoryClickEvent event = new onHistoryClickEvent();
                    event.refreshPanel();
                    event.getHistory(numF);
                }
        );
        clear.addActionListener(e -> numF.setText(""));

        buttonsPanel.add(button1);
        button1.addActionListener(e -> numF.setText(numF.getText()+"1"));

        buttonsPanel.add(button2);
        button2.addActionListener(e -> numF.setText(numF.getText()+"2"));

        buttonsPanel.add(button3);
        button3.addActionListener(e -> numF.setText(numF.getText()+"3"));

        buttonsPanel.add(bAdd);
        bAdd.addActionListener(e -> numF.setText(numF.getText()+"+"));

        buttonsPanel.add(button4);
        button4.addActionListener(e -> numF.setText(numF.getText()+"4"));

        buttonsPanel.add(button5);
        button5.addActionListener(e -> numF.setText(numF.getText()+"5"));

        buttonsPanel.add(button6);
        button6.addActionListener(e -> numF.setText(numF.getText()+"6"));

        buttonsPanel.add(bSub);
        bSub.addActionListener(e -> numF.setText(numF.getText()+"-"));

        buttonsPanel.add(button7);
        button7.addActionListener(e -> numF.setText(numF.getText()+"7"));

        buttonsPanel.add(button8);
        button8.addActionListener(e -> numF.setText(numF.getText()+"8"));

        buttonsPanel.add(button9);
        button9.addActionListener(e -> numF.setText(numF.getText()+"9"));

        buttonsPanel.add(bMul);
        bMul.addActionListener(e -> numF.setText(numF.getText()+"*"));

        buttonsPanel.add(bDot);
        bDot.addActionListener(e -> numF.setText(numF.getText()+"."));

        buttonsPanel.add(button0);
        button0.addActionListener(e -> numF.setText(numF.getText()+"0"));

        buttonsPanel.add(bDiv);
        bDiv.addActionListener(e -> numF.setText(numF.getText()+"/"));

        buttonsPanel.add(bEquals);
        bEquals.addActionListener(e -> {
            onHistoryClickEvent history = new onHistoryClickEvent();
            history.refreshPanel();
            history.getArray().add(numF.getText());

            onEqualClickEvent equal = new onEqualClickEvent();
            numF.setText(equal.compileStatement(numF.getText()));
        });
    }
}
