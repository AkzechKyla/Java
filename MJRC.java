import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MJRC extends JFrame implements ActionListener {
    public JLabel lblInstruction = new JLabel("Choose Your Order and the number of orders");
    public JCheckBox chkSoup = new JCheckBox("Soup: P25.00");
    public JTextField txtSoup = new JTextField(20);
    public JCheckBox chkCoffee = new JCheckBox("Coffee: P20.00");
    public JTextField txtCoffee = new JTextField(20);
    public JCheckBox chkSiopao = new JCheckBox("Soup: P15.00");
    public JTextField txtSiopao = new JTextField(20);
    public JButton btnComputeBill = new JButton("Compute Bill");
    public JButton btnClearAll = new JButton("Clear All");
    public JLabel lblTotalBill = new JLabel("                    Total Bill is:");
    public JTextField txtTotalBill = new JTextField(30);
    public JLabel lblAmount = new JLabel("Amount Given:");
    public JTextField txtAmount = new JTextField(30);
    public JLabel lblChange = new JLabel("Change:");
    public JTextField txtChange = new JTextField(25);
    public JButton btnComputeChange = new JButton("Compute Change");
    public JButton btnClose = new JButton("Close");

    public double dblTotalBill = 0.0;

    public MJRC() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MJRC Restaurant");
        setSize(340, 400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        addComponents();
        addListeners();
        setToDefault();

        setVisible(true);
    }

    public void addListeners() {
        btnClose.addActionListener(this);
        btnClearAll.addActionListener(this);
        btnComputeBill.addActionListener(this);
        btnComputeChange.addActionListener(this);
        chkCoffee.addActionListener(this);
        chkSiopao.addActionListener(this);
        chkSoup.addActionListener(this);
    }

    public void addComponents() {
        add(lblInstruction);
        add(chkSoup); add(txtSoup);
        add(chkCoffee); add(txtCoffee);
        add(chkSiopao); add(txtSiopao);
        add(btnComputeBill); add(btnClearAll);
        add(lblTotalBill); add(txtTotalBill);
        add(lblAmount); add(txtAmount);
        add(lblChange); add(txtChange);
        add(btnComputeChange); add(btnClose);
    }

    public void setToDefault() {
        txtSoup.setEditable(false);
        txtCoffee.setEditable(false);
        txtSiopao.setEditable(false);
        txtSoup.setText("0");
        txtCoffee.setText("0");
        txtSiopao.setText("0");
        txtTotalBill.setEditable(false);
        txtChange.setEditable(false);

    }

    public void clearOrder() {
        setToDefault();
        chkSoup.setSelected(false);
        chkCoffee.setSelected(false);
        chkSiopao.setSelected(false);
    }

    public void computeTotalBill() {
        try {
            dblTotalBill = 0.0;
            int soupAmount = Integer.parseInt(txtSoup.getText());
            int coffeeAmount = Integer.parseInt(txtCoffee.getText());
            int SiopaoAmount = Integer.parseInt(txtSiopao.getText());

            if (chkSoup.isSelected()) dblTotalBill += 25 * soupAmount;
            if (chkCoffee.isSelected()) dblTotalBill += 20 * coffeeAmount;
            if (chkSiopao.isSelected()) dblTotalBill += 20 * SiopaoAmount;

            txtTotalBill.setText(String.valueOf(dblTotalBill));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter the number of orders.", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void computeChange() {
        try {
            double dblAmountGiven = Integer.parseInt(txtAmount.getText());
            double dblChange = dblAmountGiven - dblTotalBill;

            if (dblAmountGiven < dblTotalBill) {
                JOptionPane.showMessageDialog(null, "KULANG BAYAD NIYO", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                txtChange.setText(String.valueOf(dblChange));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please input a valid amount.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnComputeBill) {
            computeTotalBill();
        }

        if (e.getSource() == btnClose) {
            int closeOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Close",
                    JOptionPane.YES_NO_OPTION);

            if (closeOption == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for ordering! GodBLS us ALL <3");
                System.exit(0);
            }
        }

        if (e.getSource() == btnClearAll) {
            int clearOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear?",
                            "Clear Order", JOptionPane.YES_NO_OPTION);
            if (clearOption == JOptionPane.YES_OPTION) clearOrder();
        }

        if (e.getSource() == btnComputeChange) {
            computeChange();
        }

        // Checkboxes
        if (e.getSource() == chkSoup) {
            if (chkSoup.isSelected()) txtSoup.setEditable(true);
            else {
                txtSoup.setEditable(false);
                txtSoup.setText("0");
            }
        }

        if (e.getSource() == chkCoffee) {
            if (chkCoffee.isSelected()) {
                txtCoffee.setEditable(true);
            } else {
                txtCoffee.setEditable(false);
                txtCoffee.setText("0");
            }
        }

        if (e.getSource() == chkSiopao) {
            if (chkSiopao.isSelected()) {
                txtSiopao.setEditable(true);
            } else {
                txtSiopao.setEditable(false);
                txtSiopao.setText("0");
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MJRC());
    }
}
