import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentForm extends JFrame implements ActionListener {

    // Components for the details panel.
    private JPanel pnlDetails = new JPanel(null);
    private JLabel lblName = new JLabel("Student Name:");
    private JTextField txtName = new JTextField();
    private JLabel lblUnits = new JLabel("Units Enrolled:");
    private JTextField txtUnits = new JTextField();
    private JLabel lblLevel = new JLabel("Year Level:");
    private String[] arrYear = {"", 
                        "1st Year", 
                        "2nd Year", 
                        "3rd Year", 
                        "4th Year", 
                        "5th Year"};
    private JComboBox<String> dropYear = new JComboBox<>(arrYear);

    // Components for the fees panel.
    private JPanel pnlFees = new JPanel(null);
    private JLabel lblFees = new JLabel("Other Fees:");
    private JCheckBox chkLaboratory = new JCheckBox("Laboratory Fee      P200");
    private JCheckBox chkRegistration = new JCheckBox("Registration Card  P50");
    private JCheckBox chkCatalyst = new JCheckBox("Catalyst                   P50");
    private JCheckBox chkCouncil = new JCheckBox("Student Council           P50");
    private JCheckBox chkID = new JCheckBox("Student ID                     P50");
    private JCheckBox chkOther = new JCheckBox("Other Miscellaneous  P100");

    // Components for the grants panel.
    private JPanel pnlGrants = new JPanel(null);
    private JLabel lblScholar = new JLabel("  Scholarship Grants:");
    private JRadioButton rbNonScholar = new JRadioButton("Non-Scholar");
    private JRadioButton rbFullScholar = new JRadioButton("Full Scholar");
    private JRadioButton rbPartialScholar = new JRadioButton("Partial Scholar");
    private ButtonGroup bgScholarship = new ButtonGroup();

    // Components for the total amount panel.
    private JPanel pnlTotal = new JPanel(null);
    private JLabel lblTotal = new JLabel("Total Amount:");
    private JTextField txtTotal = new JTextField();
    private JButton btnCompute = new JButton("btn-COMPUTE");
    private JButton btnClear = new JButton("btn-CLEAR");

    // Macro definitions for different panel sizes.
    private static final int INT_LARGE = 115;
    private static final int INT_MEDIUM = 110;
    private static final int INT_SMALL = 90;

    // Constructor for the StudentForm class.
    public StudentForm() {
        super("Student Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Method calls for the different panels.
        createDetailsPanel();
        createFeesPanel();
        createGrantsPanel();
        createTotalPanel();

        add(pnlDetails);
        add(pnlFees);
        add(pnlGrants);
        add(pnlTotal);

        setLayout(null);
        setVisible(true);

        txtTotal.setEditable(false);

        btnCompute.addActionListener(this);
        btnClear.addActionListener(this);
    }

    // Method for details panel.
    public void createDetailsPanel() {
        pnlDetails.setBackground(new Color(224, 170, 255));
        pnlDetails.setBounds(0, 0, getWidth(), INT_LARGE);

        lblName.setForeground(new Color(89, 13, 34));
        lblName.setBounds(10, 10, 190, 20);
        txtName.setBounds(120, 10, 190, 25);
        lblUnits.setForeground(new Color(89, 13, 34));
        lblUnits.setBounds(10, 40, 190, 20);
        txtUnits.setBounds(120, 40, 190, 25);
        lblLevel.setForeground(new Color(89, 13, 34));
        lblLevel.setBounds(10, 70, 190, 20);
        dropYear.setBounds(120, 70, 190, 25);

        pnlDetails.add(lblName);
        pnlDetails.add(txtName);
        pnlDetails.add(lblUnits);
        pnlDetails.add(txtUnits);
        pnlDetails.add(lblLevel);
        pnlDetails.add(dropYear);
    }

    // Method for fees panel.
    public void createFeesPanel() {
        pnlFees.setBackground(new Color(123, 44, 191));
        pnlFees.setBounds(0, INT_MEDIUM, getWidth(), INT_LARGE);

        chkLaboratory.setBackground(new Color(123, 44, 191));
        chkRegistration.setBackground(new Color(123, 44, 191));
        chkCatalyst.setBackground(new Color(123, 44, 191));
        chkCouncil.setBackground(new Color(123, 44, 191));
        chkID.setBackground(new Color(123, 44, 191));
        chkOther.setBackground(new Color(123, 44, 191));

        lblFees.setForeground(new Color(248, 237, 235));
        chkLaboratory.setForeground(new Color(248, 237, 235));
        chkRegistration.setForeground(new Color(248, 237, 235));
        chkCouncil.setForeground(new Color(248, 237, 235));
        chkCatalyst.setForeground(new Color(248, 237, 235));
        chkID.setForeground(new Color(248, 237, 235));
        chkOther.setForeground(new Color(248, 237, 235));

        lblFees.setBounds(10, 10, 170, 20);
        chkLaboratory.setBounds(25, 30, 170, 25);
        chkRegistration.setBounds(25, 55, 170, 25);
        chkCatalyst.setBounds(25, 80, 170, 25);
        chkCouncil.setBounds(200, 30, 200, 25);
        chkID.setBounds(200, 55, 200, 25);
        chkOther.setBounds(200, 80, 200, 25);

        pnlFees.add(lblFees);
        pnlFees.add(chkLaboratory);
        pnlFees.add(chkRegistration);
        pnlFees.add(chkCatalyst);
        pnlFees.add(chkCouncil);
        pnlFees.add(chkID);
        pnlFees.add(chkOther);
    }

    // Method for Scholarship grants panel.
    public void createGrantsPanel() {
        pnlGrants.setBackground(new Color(224, 170, 255));
        pnlGrants.setBounds(0, 225, getWidth(), INT_SMALL);

        rbNonScholar.setBackground(new Color(224, 170, 255));
        rbFullScholar.setBackground(new Color(224, 170, 255));
        rbPartialScholar.setBackground(new Color(224, 170, 255));

        lblScholar.setForeground(new Color(89, 13, 34));
        rbNonScholar.setForeground(new Color(89, 13, 34));
        rbFullScholar.setForeground(new Color(89, 13, 34));
        rbPartialScholar.setForeground(new Color(89, 13, 34));

        lblScholar.setBounds(5, 5, 150, 25);
        rbNonScholar.setBounds(140, 5, 150, 25);
        rbFullScholar.setBounds(140, 30, 150, 25);
        rbPartialScholar.setBounds(140, 55, 150, 25);

        rbNonScholar.setSelected(true);

        bgScholarship.add(rbNonScholar);
        bgScholarship.add(rbFullScholar);
        bgScholarship.add(rbPartialScholar);

        pnlGrants.add(lblScholar);
        pnlGrants.add(rbNonScholar);
        pnlGrants.add(rbFullScholar);
        pnlGrants.add(rbPartialScholar);
    }

    // Method for total amount panel.
    public void createTotalPanel() {
        pnlTotal.setBackground(new Color(123, 44, 191));
        pnlTotal.setBounds(0, 310, getWidth(), INT_MEDIUM);

        lblTotal.setForeground(new Color(248, 237, 235));
        btnCompute.setForeground(new Color(89, 13, 34));
        btnClear.setForeground(new Color(89, 13, 34));
        btnCompute.setBackground(new Color(224, 170, 255));
        btnClear.setBackground(new Color(224, 170, 255));

        lblTotal.setBounds(10, 15, 100, 20);
        txtTotal.setBounds(120, 15, 190, 25);
        btnCompute.setBounds(70, 50, 120, 40);
        btnClear.setBounds(200, 50, 120, 40);

        pnlTotal.add(lblTotal);
        pnlTotal.add(txtTotal);
        pnlTotal.add(btnCompute);
        pnlTotal.add(btnClear);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button click event for "Compute" button
        if (e.getSource() == btnCompute) {
            if (txtName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the student's name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dropYear.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please choose a Year Level.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int unitsEnrolled = Integer.parseInt(txtUnits.getText());
                String selectedYear = (String)dropYear.getSelectedItem();

                double totalAmount = 0.0;
                if (rbNonScholar.isSelected()) {
                    totalAmount = (unitsEnrolled * 10) + calculateOtherFees() + calculateYearLevelFee(selectedYear);
                } else if (rbPartialScholar.isSelected()) {
                    totalAmount = ((unitsEnrolled * 10) + calculateOtherFees() + calculateYearLevelFee(selectedYear)) / 2;
                }

                txtTotal.setText(String.valueOf(totalAmount));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for Units Enrolled.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnClear) {
            // Handle button click event for "Clear" button
            txtName.setText("");
            txtUnits.setText("");
            dropYear.setSelectedIndex(0);
            dropYear.setEnabled(true);
            rbNonScholar.setSelected(true);
            chkLaboratory.setSelected(false);
            chkRegistration.setSelected(false);
            chkCatalyst.setSelected(false);
            chkCouncil.setSelected(false);
            chkID.setSelected(false);
            chkOther.setSelected(false);
            txtTotal.setText("");
        }
    }

    // Method for calculating other fees based on selected checkboxes
    private double calculateOtherFees() {
        double totalFees = 0.0;

        if (chkLaboratory.isSelected()) totalFees += 200;
        if (chkRegistration.isSelected()) totalFees += 50;
        if (chkCatalyst.isSelected()) totalFees += 50;
        if (chkCouncil.isSelected()) totalFees += 50;
        if (chkID.isSelected()) totalFees += 50;
        if (chkOther.isSelected()) totalFees += 100;

        return totalFees;
    }

    // Method for calculating year level fee based on the selected year
    private int calculateYearLevelFee(String selectedYear) {
        switch (selectedYear) {
            case "1st Year":
                return 100;
            case "2nd Year":
                return 200;
            case "3rd Year":
                return 300;
            case "4th Year":
                return 400;
            case "5th Year":
                return 500;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        // We use the invokeLater method to prevent thread interference.
        SwingUtilities.invokeLater(() -> new StudentForm());
    }

}

add(pnlDetails
add(lblName
add(txtName
add(lblUnits
