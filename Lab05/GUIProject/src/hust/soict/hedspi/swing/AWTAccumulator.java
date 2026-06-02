package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {

    private Label lbInput;
    private Label lbOutput;

    private TextField tfInput;
    private TextField tfOutput;

    private int sum = 0;

    public AWTAccumulator() {

        setLayout(new GridLayout(2, 2));

        lbInput = new Label("Enter an Integer: ");
        add(lbInput);

        tfInput = new TextField(10);
        tfInput.addActionListener(new TFInputListener());
        add(tfInput);

        lbOutput = new Label("The Accumulated Sum is: ");
        add(lbOutput);

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
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
        new AWTAccumulator();
    }
}