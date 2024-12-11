import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SortAndFind extends JFrame implements ActionListener {
    public JLabel lblInputNumbers = new JLabel("Input a set of numbers:");
    public JTextArea txtInputNumbers = new JTextArea(5,20);
    public JLabel lblSortedNumbers = new JLabel("Here are the numbers in ascending order:");
    public JTextArea txtSortedNumbers = new JTextArea(5,20);
    public JLabel lblReturnNumber = new JLabel("Return number in this position:");
    public JTextField txtReturnNumber = new JTextField(2);
    public JLabel lblPosition = new JLabel("");
    public JTextField txtNumberInPosition = new JTextField(2);
    public JButton btnClick = new JButton("Click Here!");

    public SortAndFind() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(330, 400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        addComponents();
        setToDefault();
        btnClick.addActionListener(this);

        setVisible(true);
    }

    public void addComponents() {
        add(lblInputNumbers);
        add(txtInputNumbers);
        add(lblSortedNumbers);
        add(txtSortedNumbers);
        add(lblReturnNumber);
        add(txtReturnNumber);
        add(lblPosition);
        add(txtNumberInPosition);
        add(btnClick);
    }

    public void setToDefault() {
        txtSortedNumbers.setEditable(false);
        txtNumberInPosition.setEditable(false);
    }

    public void sortNumbers() {
        try {
            String strNumbers = txtInputNumbers.getText();
            String[] strArrayNumbers = strNumbers.split("\\s");
            int[] intArrayNumbers = new int[strArrayNumbers.length];

            for (int i = 0; i < strArrayNumbers.length; i++) {
                intArrayNumbers[i] = Integer.parseInt(strArrayNumbers[i]);
            }

            Arrays.sort(intArrayNumbers);

            StringBuilder sortedNumbers = new StringBuilder();
            for (int num : intArrayNumbers) {
                sortedNumbers.append(num).append(" ");
            }

            txtSortedNumbers.setText(sortedNumbers.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input numbers to sort.", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void returnNumberInPosition() {
        try {
            String sorted = txtSortedNumbers.getText();
            String[] arrSorted = sorted.split("\\s");
            int position = Integer.parseInt(txtReturnNumber.getText());

            txtNumberInPosition.setText(arrSorted[position - 1]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input a number to return.", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClick) {
            sortNumbers();
            returnNumberInPosition();
            lblPosition.setText("The number in this position is: ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortAndFind());
    }
}
