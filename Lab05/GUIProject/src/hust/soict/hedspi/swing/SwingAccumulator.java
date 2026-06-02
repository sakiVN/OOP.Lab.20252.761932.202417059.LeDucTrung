package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAccumulator extends JFrame {

    private JLabel lbInput;
    private JLabel lbOutput;

    private JTextField tfInput;
    private JTextField tfOutput;

    private int sum = 0;

    public SwingAccumulator() {

        Container cp = getContentPane();

        cp.setLayout(new GridLayout(2, 2));

        lbInput = new JLabel("Enter an Integer: ");
        cp.add(lbInput);

        tfInput = new JTextField(10);
        tfInput.addActionListener(new TFInputListener());
        cp.add(tfInput);

        lbOutput = new JLabel("The Accumulated Sum is: ");
        cp.add(lbOutput);

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class TFInputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {

            int numberIn = Integer.parseInt(tfInput.getText());

            sum += numberIn;

            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}