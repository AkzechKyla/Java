import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringChecker extends JFrame implements ActionListener{
    public JLabel lblEnterString = new JLabel("Enter two strings:");
    public JTextArea txtString1 = new JTextArea(1,25);
    public JTextArea txtString2 = new JTextArea(1,25);
    public JLabel lblPalindrome = new JLabel("Palindrome Checker");
    public JTextArea txtPalindrome1 = new JTextArea(1,25);
    public JTextArea txtPalindrome2 = new JTextArea(1,25);
    public JLabel lblAnagram = new JLabel("Anagram Checker");
    public JTextArea txtAnagram1 = new JTextArea(1,25);
    public JTextArea txtAnagram2 = new JTextArea(1,25);
    public JButton btnCheck = new JButton("Check");
    public JButton btnClear = new JButton("Clear");
    public JButton btnClose = new JButton("Close");

    public StringChecker() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("String Checker");
        setSize(320,400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        addComponents();
        addListeners();
    }

    public void addComponents() {
        add(lblEnterString);
        add(txtString1);
        add(txtString2);
        add(lblPalindrome);
        add(txtPalindrome1);
        add(txtPalindrome2);
        add(lblAnagram);
        add(txtAnagram1);
        add(txtAnagram2);
        add(btnCheck);
        add(btnClear);
        add(btnClose);
    }

    public void addListeners() {
        btnCheck.addActionListener(this);
        btnClear.addActionListener(this);
        btnClose.addActionListener(this);
    }

    public void setToDefault() {
        txtPalindrome1.setEditable(false);
        txtPalindrome2.setEditable(false);
        txtAnagram1.setEditable(false);
        txtAnagram2.setEditable(false);
    }

    public void palindromeChecker() {
        String origString = txtString1.getText();
        String strText = origString.toLowerCase();

        StringBuilder reverseString = new StringBuilder();
        reverseString.append(strText);
        reverseString.reverse();
        String arrReversedString = reverseString.toString();

        if (strText.equals(arrReversedString)) {
            txtPalindrome1.setText(origString.concat(" is a palindrome."));
        } else {
            txtPalindrome1.setText(origString.concat(" is not a palindrome."));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheck) {
            palindromeChecker();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StringChecker());
    }
}
