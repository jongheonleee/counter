import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame{

    private JLabel lblNum;
    private JButton btnPlus;
    private JButton btnMinus;
    private  JButton btnReset;

    public Counter() {
        init();
        setDisplay();
        addListener();
        showFrame();
    }

    private void init() {

        // init number
        lblNum = new JLabel("0", JLabel.CENTER);
        lblNum.setText("0");
        lblNum.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));

        // set buttons
        btnPlus = new JButton();
        btnPlus.setText("Plus");

        btnMinus = new JButton();
        btnMinus.setText("Minus");

        btnReset = new JButton();
        btnReset.setText("Reset");

    }

    private void setDisplay() {

        JPanel southPanel = new JPanel(new GridLayout(1, 0));
        southPanel.add(btnPlus);
        southPanel.add(btnMinus);
        southPanel.add(btnReset);

        add(lblNum, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

    }

    private void addListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // user pressed plus button
                if (btnPlus.equals(e.getSource())) {
                    String numStr = lblNum.getText();
                    int numInt = Integer.parseInt(numStr);
                    numInt++;

                    numStr = String.valueOf(numInt);
                    lblNum.setText(numStr);
                }

                // user pressed minus button
                if (btnMinus.equals(e.getSource())) {
                    String numStr = lblNum.getText();
                    int numInt = Integer.parseInt(numStr);
                    numInt--;

                    numStr = String.valueOf(numInt);
                    lblNum.setText(numStr);
                }

                // user pressed reset button
                if (btnReset.equals(e.getSource())) {
                    lblNum.setText("0");
                }
            }
        };

        btnPlus.addActionListener(listener);
        btnMinus.addActionListener(listener);
        btnReset.addActionListener(listener);
    }

    // setting frame
    private void showFrame() {
        setTitle("Counter");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Counter();
    }
}