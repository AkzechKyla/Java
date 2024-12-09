import java.awt.*;
import java.awt.event.*;

public class MJRCRestaurant extends Frame implements ItemListener, ActionListener {
    Label lblOrder = new Label("Choose your order and the number of orders:");
    Label lblTotalBill = new Label("Total Bill is:");
    Label lblAmountGiven = new Label("Amount Given:");
    Label lblChange = new Label("Change:");

    Checkbox chkSoup = new Checkbox("Soup:   Php 25.00");
    Checkbox chkCoffee = new Checkbox("Coffee: Php 20.00");
    Checkbox chkSiopao = new Checkbox("Siopao: Php 15.00");

    TextField txtSoup = new TextField(20);
    TextField txtCoffee = new TextField(20);
    TextField txtSiopao = new TextField(20);
    TextField txtTotalBill = new TextField(30);
    TextField txtAmountGiven = new TextField(30);
    TextField txtChange = new TextField(30);

    Button btnComputeBill = new Button("Compute Bill");
    Button btnClear = new Button("Clear All");
    Button btnComputeChange = new Button("Compute Change");
    Button btnClose = new Button("Close");

    MJRCRestaurant() { // constructor
        setTitle("MJRC Restaurant");
        setLayout(new FlowLayout());

        // Add checkboxes and textfields
        add(lblOrder);
        add(chkSoup);   add(txtSoup);
        add(chkCoffee); add(txtCoffee);
        add(chkSiopao); add(txtSiopao);

        add(btnComputeBill); add(btnClear); // Add buttons

        add(lblTotalBill);   add(txtTotalBill);
        add(lblAmountGiven); add(txtAmountGiven);
        add(lblChange);      add(txtChange);

        // "Compute Change" and "Close" button layout
        Panel buttonPanel = new Panel(new GridLayout(2, 2, 6, 6));
        buttonPanel.add(btnComputeChange);
        buttonPanel.add(btnClose);
        add(buttonPanel);

        setResizable(false); // Disable resizing of window

        disableOrdering();

        // Event and Item Listeners 
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        chkSoup.addItemListener(this);
        chkCoffee.addItemListener(this);
        chkSiopao.addItemListener(this);
        btnComputeBill.addActionListener(this);
        btnClear.addActionListener(this);
    }

    public static void main(String[] args) {
        MJRCRestaurant MJRCFrame = new MJRCRestaurant();
        MJRCFrame.setSize(340, 400);
        MJRCFrame.setVisible(true);
    }

    private void disableOrdering() {
        txtSoup.setEnabled(false);
        txtCoffee.setEnabled(false);
        txtSiopao.setEnabled(false);
    }
    
    private void uncheckBoxes() {
        chkSoup.setState(false);
        chkCoffee.setState(false);
        chkSiopao.setState(false);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(chkSoup)) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtSoup.setEnabled(true);
            } else {
                txtSoup.setEnabled(false);
                txtSoup.setText("0");
            } 
        }

        if (e.getSource().equals(chkCoffee)) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtCoffee.setEnabled(true);
            } else {
                txtCoffee.setEnabled(false);
                txtCoffee.setText("0");
            } 
        }

        if (e.getSource().equals(chkSiopao)) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtSiopao.setEnabled(true);
            } else {
                txtSiopao.setEnabled(false);
                txtSiopao.setText("0");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnComputeBill)) {
            computeTotalBill();
        }

        if (e.getSource().equals(btnClear)) {
            txtSoup.setText("0");
            txtCoffee.setText("0");
            txtSiopao.setText("0");

            txtTotalBill.setText("0.00");

            disableOrdering();
            uncheckBoxes();
        }
    }

    public void computeTotalBill() { // Add try catch!!!!!!!!!!
        double soupPrice = 25.00;
        double coffeePrice = 20.00;
        double siopaoPrice = 15.00;

        int soupQuantity = Integer.parseInt(txtSoup.getText());
        int coffeeQuantity = Integer.parseInt(txtCoffee.getText());
        int siopaoQuantity = Integer.parseInt(txtSiopao.getText());

        double totalBill = (soupQuantity * soupPrice) + (coffeeQuantity * coffeePrice)
                            + (siopaoQuantity * siopaoPrice);

        txtTotalBill.setText(String.format("%.2f", totalBill));
    }


}
