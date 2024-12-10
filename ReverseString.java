import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReverseString extends JFrame implements ActionListener {
    public JLabel lblInputString = new JLabel("Input a string:");
    public JTextArea txtInputString = new JTextArea(3, 30);
    public JButton btnReverse = new JButton("Reversify");
    public JLabel lblReversedString = new JLabel("Reversed String:");
    public JTextArea txtReversedString = new JTextArea(3, 30);
    public JLabel lblReversedSentence = new JLabel("Reversed Sentence:");
    public JTextArea txtReversedSentence = new JTextArea(3, 30);

    public ReverseString() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Reverse String");
        setSize(350, 400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        addComponents();
        addListeners();

        setVisible(true);
    }

    public void addComponents() {
        add(lblInputString);
        add(txtInputString);
        add(lblReversedString);
        add(txtReversedString);
        add(lblReversedSentence);
        add(txtReversedSentence);
        add(btnReverse);
    }

    public void addListeners() {
        btnReverse.addActionListener(this);
    }

    public void reverseString() {
        StringBuilder reversedString = new StringBuilder();
        String inputString = txtInputString.getText();
        reversedString.append(inputString);
        reversedString.reverse();
        txtReversedString.setText(reversedString.toString());
    }

    public void reverseSentence() {
        String[] arrSentence = txtInputString.getText().split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = arrSentence.length - 1; i >= 0; i--) {
            reversedSentence.append(arrSentence[i]).append(" ");
        }

        txtReversedSentence.setText(reversedSentence.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReverse) {
            reverseString();
            reverseSentence();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReverseString());
    }
}
