import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class McKing extends JFrame implements ActionListener {
    public JLabel lblUsername = new JLabel("User Name");
    public JTextField txtUsername = new JTextField(20);
    public JLabel lblPassword = new JLabel("Password");
    public JTextField txtPassword = new JTextField(20);
    public JButton btnOk = new JButton("Ok");
    public JLabel lblChooseOrder = new JLabel("Choose Your Order:");
    public JCheckBox chkValueMeal1 = new JCheckBox("Value Meal #1:      P25.00");
    public JCheckBox chkValueMeal2 = new JCheckBox("Value Meal #2:      P30.00");
    public JCheckBox chkValueMeal3 = new JCheckBox("Value Meal #3:      P35.00");
    String[] arrDrinks = {"Coke", "Water", "Sprite"};
    public JComboBox<String> dropDrinks = new JComboBox<>(arrDrinks);
    public JRadioButton rbExtraRice = new JRadioButton("Extra Rice");
    public JRadioButton rbNoExtraRice = new JRadioButton("No Extra Rice");
    public ButtonGroup bgRice = new ButtonGroup();
    public JButton btnCompute = new JButton("Compute");
    public JLabel lblTotalBill = new JLabel("Total Bill is:");
    public JTextField txtTotalBill = new JTextField(20);
    public JButton btnClear = new JButton("Clear");
    public JButton btnClose = new JButton("Close");

    public McKing() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Jolly McKing");
        setSize(320, 400);
        setResizable(false);
        setLayout(new FlowLayout());

        bgRice.add(rbExtraRice);
        bgRice.add(rbNoExtraRice);
        addComponents();
        addListener();
        disableOrder();

        setVisible(true);
    }

    public void addListener() {
        btnOk.addActionListener(this);
        btnClear.addActionListener(this);
        btnClose.addActionListener(this);
        btnCompute.addActionListener(this);
    }

    public void addComponents() {
        add(lblUsername); add(txtUsername);
        add(lblPassword); add(txtPassword); add(btnOk);
        add(lblChooseOrder);
        add(chkValueMeal1);
        add(chkValueMeal2);
        add(chkValueMeal3);
        add(dropDrinks);
        add(rbExtraRice); add(rbNoExtraRice);
        add(btnCompute);
        add(lblTotalBill); add(txtTotalBill);
        add(btnClear); add(btnClose);
    }

    public void disableOrder() {
        lblChooseOrder.setEnabled(false);
        chkValueMeal1.setEnabled(false);
        chkValueMeal2.setEnabled(false);
        chkValueMeal3.setEnabled(false);
        dropDrinks.setEnabled(false);
        rbExtraRice.setEnabled(false);
        rbNoExtraRice.setEnabled(false);
        btnCompute.setEnabled(false);
        lblTotalBill.setEnabled(false);
        txtTotalBill.setEnabled(false);
        txtTotalBill.setEditable(false);
        btnClear.setEnabled(false);
    }

    public void enableOrder() {
        lblChooseOrder.setEnabled(true);
        chkValueMeal1.setEnabled(true);
        chkValueMeal2.setEnabled(true);
        chkValueMeal3.setEnabled(true);
        dropDrinks.setEnabled(true);
        rbExtraRice.setEnabled(true);
        rbNoExtraRice.setEnabled(true);
        btnCompute.setEnabled(true);
        lblTotalBill.setEnabled(true);
        txtTotalBill.setEnabled(true);
        btnClear.setEnabled(true);
    }

    public void clearOrder() {
        chkValueMeal1.setSelected(false);
        chkValueMeal2.setSelected(false);
        chkValueMeal3.setSelected(false);
        dropDrinks.setSelectedIndex(0);
        bgRice.clearSelection();
        txtTotalBill.setText("");
    }

    public void computeOrder() {
        double intTotalBill = 0;

        if (chkValueMeal1.isSelected()) intTotalBill += 25;
        if (chkValueMeal2.isSelected()) intTotalBill += 30;
        if (chkValueMeal3.isSelected()) intTotalBill += 35;
        if (rbExtraRice.isSelected()) intTotalBill += 25;

        txtTotalBill.setText(String.valueOf(intTotalBill));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk) {
            try {
                int password = 12345;
                int inputPass = Integer.parseInt(txtPassword.getText());

                if (inputPass == password) {
                    enableOrder();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Password", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Password", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == btnCompute) {
            computeOrder();
        }
        if (e.getSource() == btnClear) {
            int clearOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear?",
            "Clear Order", JOptionPane.YES_NO_OPTION);

            if (clearOption == JOptionPane.YES_OPTION) {
                clearOrder();
            }
        }
        if (e.getSource() == btnClose) {
            int closeOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
            "Close Order", JOptionPane.YES_NO_OPTION);

            if (closeOption == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new McKing());
    }
}
