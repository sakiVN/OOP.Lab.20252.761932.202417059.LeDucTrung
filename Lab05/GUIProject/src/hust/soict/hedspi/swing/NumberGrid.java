package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {

    private JButton btnNumbers[] = new JButton[10];
    private JButton btnDelete;
    private JButton btnReset;

    private JTextField tfDisplay;

    public NumberGrid() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        tfDisplay = new JTextField();
        cp.add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));

        addButtons(panelButtons);

        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {

        ButtonListener btnListener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {

            btnNumbers[i] = new JButton("" + i);

            panelButtons.add(btnNumbers[i]);

            btnNumbers[i].addActionListener(btnListener);
        }

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String buttonText =
                    ((JButton) e.getSource()).getText();

            if (buttonText.matches("\\d")) {

                tfDisplay.setText(
                        tfDisplay.getText() + buttonText
                );

            } else if (buttonText.equals("DEL")) {

                String currentText = tfDisplay.getText();

                if (currentText.length() > 0) {

                    tfDisplay.setText(
                            currentText.substring(
                                    0,
                                    currentText.length() - 1
                            )
                    );
                }

            } else if (buttonText.equals("C")) {

                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {

        new NumberGrid();
    }
}