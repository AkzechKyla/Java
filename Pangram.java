import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

public class Pangram extends JFrame implements ActionListener {
    public JLabel lblTitle = new JLabel("Is this string a Pangram? Let's find out.");
    public JLabel lblInstructions = new JLabel("Enter a string: ");
    public JTextArea txtInputString = new JTextArea(3, 20);
    public JButton btnCheck = new JButton("Check");
    public JTextArea txtIsPangram = new JTextArea(3, 25);

    public Pangram() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pangram");
        setSize(320,300);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        addComponents();
        addListener();
        txtIsPangram.setEditable(false);

        setVisible(true);
    }

    public void addListener() {
        btnCheck.addActionListener(this);
    }

    public void addComponents() {
        add(lblTitle);
        add(lblInstructions);
        add(txtInputString);
        add(btnCheck);
        add(txtIsPangram);
    }

    public void checkPangram() {
        String strInput = txtInputString.getText();
        String strInputLower = strInput.toLowerCase();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' , 'm', 'n', 'o',
                            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < alphabet.length; i++) {
            if (!strInputLower.contains(String.valueOf(alphabet[i]))) {
                txtIsPangram.setText("Not pangram");
                break;
            } else {
                txtIsPangram.setText("pangram");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCheck) {
            checkPangram();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pangram());
    }
}
