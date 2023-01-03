

import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
//import java.awt.event.addActionListener;

    public class AWTAccumulator extends Frame {
        private TextField tfInput;
        private TextField tfOutput;
        private int sum = 0;        //Accumulated sum, init to 0

        // constructor to setup the GUI Component and event handler
        public AWTAccumulator() {
            setLayout(new GridLayout(2, 2));
            add(new Label("Enter an interger: "));
            tfInput = new TextField(10);
            add(tfInput);
            tfInput.addActionListener(new TFInputListener());

            add(new Label("The Accumulator Sum Is : "));
            tfOutput = new TextField(10);
            tfOutput.setEditable(false);
            add(tfOutput);

            setTitle("AWT Accumulator");
            setSize(350, 120);
            setVisible(true);

        }

        public static void main(String[] args) {
            new AWTAccumulator();
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
    }
