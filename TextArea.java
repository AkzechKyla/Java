import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SortingNumbers extends JFrame implements ActionListener {
    public JLabel lblSortNumbers = new JLabel("Sort numbers");
    public String[] arrSortMethods = {"Ascending", "Descending"};
    public JComboBox<String> dropSortMethod = new JComboBox<>(arrSortMethods);
    public JLabel lblNumbers = new JLabel("Enter numbers to sort:");
    public JTextArea txtNumbers = new JTextArea(5, 25);
    public JButton btnSort = new JButton("Sort");

    public JLabel lblSortedNumbers = new JLabel("                 Here are the sorted numbers:");
    public JTextArea txtSortedNumbers = new JTextArea(5, 25);

    public SortingNumbers() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sorting Numbers");
        setSize(300, 400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        addComponents();
        addListeners();
        setToDefault();

        setVisible(true);
    }

    public void addComponents() {
        add(lblSortNumbers);
        add(dropSortMethod);
        add(lblNumbers);
        add(txtNumbers);
        add(btnSort);

        add(lblSortedNumbers);
        add(txtSortedNumbers);
    }

    public void addListeners() {
        btnSort.addActionListener(this);
    }

    public void setToDefault() {
        txtSortedNumbers.setEditable(false);
    }

    public boolean isNumberRepeated(int[] intUnsortedNumbers) {
        for (int i = 0; i < intUnsortedNumbers.length - 1; i++) {
            for (int j = i + 1; j < intUnsortedNumbers.length; j++) {
                if (intUnsortedNumbers[i] == intUnsortedNumbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sortNumbers() {
        try {
            String strUnsortedNumbers = txtNumbers.getText();
            String[] arrUnsortedNumbers = strUnsortedNumbers.split(" "); // To split numbers with spaces and turn into array
            int[] intUnsortedNumbers = new int[arrUnsortedNumbers.length];

            for (int i = 0; i < arrUnsortedNumbers.length; i++) {
                intUnsortedNumbers[i] = Integer.parseInt(arrUnsortedNumbers[i]);
            }

            Arrays.sort(intUnsortedNumbers);
            if (isNumberRepeated(intUnsortedNumbers) == true) {
                JOptionPane.showMessageDialog(null, "Input unique numbers only.", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder strSortedNumbers = new StringBuilder();
                for (int num : intUnsortedNumbers) {
                    strSortedNumbers.append(num).append(" ");
                }

                if (dropSortMethod.getSelectedIndex() == 0) {
                    txtSortedNumbers.setText(strSortedNumbers.toString());
                } else {
                    txtSortedNumbers.setText(strSortedNumbers.reverse().toString());
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter valid numbers only", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSort) {
            sortNumbers();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortingNumbers());
    }
}
