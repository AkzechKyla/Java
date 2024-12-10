import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrimeFactorization extends JFrame implements ActionListener {
    public JLabel lblInputNumber = new JLabel("Input Number: ");
    public JTextField txtNumber = new JTextField(20);
    public JButton btnCheck = new JButton("Check");
    public JButton btnClear = new JButton("Clear");
    public JLabel lblPrimeFactors = new JLabel("Prime Factors:");
    public JTextField txtPrimeFactors = new JTextField(20);

    public PrimeFactorization() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Prime Factorization");
        setSize(250, 350);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        addComponents();
        btnCheck.addActionListener(this);
        btnClear.addActionListener(this);
        txtPrimeFactors.setEditable(false);
    }

    public void addComponents() {
        add(lblInputNumber);
        add(txtNumber);
        add(btnCheck);
        add(btnClear);
        add(lblPrimeFactors);
        add(txtPrimeFactors);
    }

    public void computePrimeFactors() {
        int num = Integer.parseInt(txtNumber.getText());

        if (num < 2) {
            JOptionPane.showMessageDialog(null, "1 has no prime factors.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

        StringBuilder strNum = new StringBuilder();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                strNum.append(String.valueOf(i)).append(" ");
                num /= i;
            }
        }

        txtPrimeFactors.setText(String.valueOf(strNum));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheck) {
            try {
                computePrimeFactors();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter numbers only.", "Information", JOptionPane.MESSAGE_INFORMATION);
            }
        }

        if (e.getSource() == btnClear) {
            txtNumber.setText("");
            txtPrimeFactors.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrimeFactorization());
    }
}
