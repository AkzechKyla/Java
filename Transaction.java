import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener, ItemListener {
    public JLabel lblTransaction = new JLabel("Type transaction:");
    public JRadioButton rbDefault = new JRadioButton("Default");
    public JRadioButton rbDeposit = new JRadioButton("Deposit");
    public JRadioButton rbWithdraw = new JRadioButton("Withdraw");
    public ButtonGroup rbGroup = new ButtonGroup();

    public JLabel lblPrevBalance = new JLabel("Previous Balance:");
    public JTextField txtPrevBalance = new JTextField(20);

    public JLabel lblDenomination = new JLabel("Denomination   ");
    public JLabel lblPieces = new JLabel("Number of Pieces       ");
    public JLabel lblAmount = new JLabel("Amount       ");

    public JCheckBox chk1000 = new JCheckBox("1,000");
    public JTextField txt1000 = new JTextField(12);
    public JTextField amount1000 = new JTextField(12);

    public JCheckBox chk500 = new JCheckBox("500");
    public JTextField txt500 = new JTextField(12);
    public JTextField amount500 = new JTextField(12);

    public JCheckBox chk200 = new JCheckBox("200");
    public JTextField txt200 = new JTextField(12);
    public JTextField amount200 = new JTextField(12);

    public JCheckBox chk100 = new JCheckBox("100");
    public JTextField txt100 = new JTextField(12);
    public JTextField amount100 = new JTextField(12);

    public JLabel lblTotalDeposit = new JLabel("Total Deposit:");
    public JTextField txtTotalDeposit = new JTextField(20);
    public JLabel lblCurrentBalance = new JLabel("Current Balance:");
    public JTextField txtCurrentBalance = new JTextField(20);
    public JButton btnCompute = new JButton("COMPUTE");

    public int intWithdrawAmount = 0;

    public Transaction() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bank Transactions");
        setSize(350,400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        rbGroup.add(rbDefault);
        rbGroup.add(rbDeposit);
        rbGroup.add(rbWithdraw);
        addComponents();
        addListeners();
        setToDefault();

        setVisible(true);
    }

    public void addListeners() {
        rbDefault.addItemListener(this);
        rbDeposit.addItemListener(this);
        rbWithdraw.addItemListener(this);
        chk1000.addItemListener(this);
        chk500.addItemListener(this);
        chk200.addItemListener(this);
        chk100.addItemListener(this);
        btnCompute.addActionListener(this);
    }

    public void addComponents() {
        add(lblTransaction);
        add(rbDefault);
        add(rbDeposit);
        add(rbWithdraw);
        add(lblPrevBalance);
        add(txtPrevBalance);
        add(lblDenomination);
        add(lblPieces);
        add(lblAmount);
        add(chk1000);
        add(txt1000);
        add(amount1000);
        add(chk500);
        add(txt500);
        add(amount500);
        add(chk200);
        add(txt200);
        add(amount200);
        add(chk100);
        add(txt100);
        add(amount100);
        add(lblTotalDeposit);
        add(txtTotalDeposit);
        add(lblCurrentBalance);
        add(txtCurrentBalance);
        add(btnCompute);
    }

    public void setToDefault() {
        rbDefault.setSelected(true);
        txtPrevBalance.setEnabled(false);
        txtPrevBalance.setText("");
        chk1000.setSelected(false);
        chk1000.setEnabled(false);
        chk1000.setEnabled(false);
        txt1000.setEnabled(false);
        txt1000.setEditable(false);
        amount1000.setEditable(false);
        chk500.setEnabled(false);
        chk500.setEnabled(false);
        txt500.setEnabled(false);
        txt500.setEditable(false);
        amount500.setEditable(false);
        chk200.setEnabled(false);
        chk200.setEnabled(false);
        txt200.setEnabled(false);
        txt200.setEditable(false);
        amount200.setEditable(false);
        chk100.setEnabled(false);
        chk100.setEnabled(false);
        txt100.setEnabled(false);
        txt100.setEditable(false);
        amount100.setEditable(false);
        txtTotalDeposit.setEditable(false);
        txtCurrentBalance.setEditable(false);
        btnCompute.setEnabled(false);
        txtTotalDeposit.setText("");
        txtCurrentBalance.setText("");
    }

    public void computeDeposit() {
        int int1000 = 0;
        int int500 = 0;
        int int200 = 0;
        int int100 = 0;

        try {
            if (chk1000.isSelected()) {
                int pieces1000 = Integer.parseInt(txt1000.getText());
                int1000 = 1000 * pieces1000;
                amount1000.setText(String.valueOf(int1000));
            }

            if (chk500.isSelected()) {
                int pieces500 = Integer.parseInt(txt500.getText());
                int500 = 500 * pieces500;
                amount500.setText(String.valueOf(int500));
            }

            if (chk200.isSelected()) {
                int pieces200 = Integer.parseInt(txt200.getText());
                int200 = 200 * pieces200;
                amount200.setText(String.valueOf(int200));
            }

            if (chk100.isSelected()) {
                int pieces100 = Integer.parseInt(txt100.getText());
                int100 = 100 * pieces100;
                amount100.setText(String.valueOf(int100));
            }

            int intTotalDeposit = int1000 + int500 + int200 + int100;
            txtTotalDeposit.setText(String.valueOf(intTotalDeposit));
            int intPrevBalance = Integer.parseInt(txtPrevBalance.getText());
            int intCurrentBalance = intPrevBalance + intTotalDeposit;
            txtCurrentBalance.setText(String.valueOf(intCurrentBalance));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please input valid positive integer number.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void computeWithdraw() {
        int intPrevBalance = Integer.parseInt(txtPrevBalance.getText());
        int intCurrentBalance = intPrevBalance - intWithdrawAmount;
        txtCurrentBalance.setText(String.valueOf(intCurrentBalance));
    }

    public int getValidInput(String message, String title) {
        int result = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            String userInput = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
            try {
                result = Integer.parseInt(userInput);
                if (result >= 0) isValidInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input valid positive integer number.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCompute) {
            if (rbDeposit.isSelected()) computeDeposit();
            else if (rbWithdraw.isSelected()) computeWithdraw();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == rbDefault) {
            if (rbDefault.isSelected()) setToDefault();
        }
        if (e.getSource() == rbDeposit) {
            if (rbDeposit.isSelected()) {
                txtPrevBalance.setEnabled(true);
                btnCompute.setEnabled(true);
                chk1000.setEnabled(true);
                chk500.setEnabled(true);
                chk200.setEnabled(true);
                chk100.setEnabled(true);
            }

        }
        if (e.getSource() == rbWithdraw) {
            if (rbWithdraw.isSelected()) {
                txtPrevBalance.setEnabled(true);
                btnCompute.setEnabled(true);

                String strPrevBalance = String.valueOf(getValidInput("Enter Previous Balance:", "Balance"));
                txtPrevBalance.setText(strPrevBalance);

                boolean isValidWithdrawAmount = false;
                while (!isValidWithdrawAmount) {
                    String strWithdrawAmount = String.valueOf(getValidInput("Enter Withdraw Amount:", "Withdraw"));
                    intWithdrawAmount = Integer.parseInt(strWithdrawAmount);
                    int intPrevBalance = Integer.parseInt(txtPrevBalance.getText());
                    if (intWithdrawAmount > intPrevBalance) {
                        JOptionPane.showMessageDialog(null, "Insufficient Funds", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    } else isValidWithdrawAmount = true;
                }
            }
        }

        // Checkboxes
        if (e.getSource() == chk1000) {
            if (chk1000.isSelected()) {
                txt1000.setEnabled(true);
                txt1000.setEditable(true);
            } else {
                txt1000.setEditable(false);
                txt1000.setText("");
                amount1000.setText("");
            }
        }
        if (e.getSource() == chk500) {
            if (chk500.isSelected()) {
                txt500.setEnabled(true);
                txt500.setEditable(true);
            } else {
                txt500.setEditable(false);
                txt500.setText("");
                amount500.setText("");
            }
        }
        if (e.getSource() == chk200) {
            if (chk200.isSelected()) {
                txt200.setEnabled(true);
                txt200.setEditable(true);
            } else {
                txt200.setEditable(false);
                txt200.setText("");
                amount200.setText("");
            }
        }
        if (e.getSource() == chk100) {
            if (chk100.isSelected()) {
                txt100.setEnabled(true);
                txt100.setEditable(true);
            } else {
                txt100.setEditable(false);
                txt100.setText("");
                amount100.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Transaction());
    }
}
