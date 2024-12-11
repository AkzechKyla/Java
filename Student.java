import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Student extends JFrame implements ActionListener {
    public JLabel lblStudentName = new JLabel("Student Name:");
    public JTextField txtStudentName = new JTextField(20);
    public JLabel lblUnitsEnrolled = new JLabel("Units Enrolled:");
    public JTextField txtUnitsEnrolled = new JTextField(20);
    public JLabel lblYearLevel = new JLabel("Year Level:");
    public String[] arrYear = {"", "1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year"};
    public JComboBox<String> dropYearLevel = new JComboBox<String>(arrYear);

    public JLabel lblOtherFees = new JLabel("Other Fees:");
    public JCheckBox chkLaboratoryFee = new JCheckBox("Laboratory Fee P200");
    public JCheckBox chkRegistrationCard = new JCheckBox("Registration Card P50");
    public JCheckBox chkCatalyst = new JCheckBox("Catalyst P50");
    public JCheckBox chkStudentCouncil = new JCheckBox("Student Council P50");
    public JCheckBox chkStudentID = new JCheckBox("Student ID P50");
    public JCheckBox chkMisc = new JCheckBox("Other Miscellaneous P100");

    public JLabel lblScholarship = new JLabel("Scholarship Grants:");
    public JRadioButton rbNonScholar = new JRadioButton("Non-Scholar");
    public JRadioButton rbFullScholar = new JRadioButton("Full Scholar");
    public JRadioButton rbPartialScholar = new JRadioButton("Partial Scholar");
    public ButtonGroup bgScholarGroup = new ButtonGroup();

    public JLabel lblTotalAmount = new JLabel("Total Amount:");
    public JTextField txtTotalAmount = new JTextField(20);
    public JButton btnCompute = new JButton("COMPUTE");
    public JButton btnClear = new JButton("CLEAR");

    public Student() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Form");
        setSize(350,400);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        bgScholarGroup.add(rbNonScholar);
        bgScholarGroup.add(rbFullScholar);
        bgScholarGroup.add(rbPartialScholar);

        addComponents();
        setToDefault();
        addListeners();

        setVisible(true);
    }

    public void addListeners() {
        btnCompute.addActionListener(this);
        btnClear.addActionListener(this);
        rbNonScholar.addActionListener(this);
        rbFullScholar.addActionListener(this);
        rbPartialScholar.addActionListener(this);

    }

    public void addComponents() {
        add(lblStudentName); add(txtStudentName);
        add(lblUnitsEnrolled); add(txtUnitsEnrolled);
        add(lblYearLevel); add(dropYearLevel);
        add(lblOtherFees);
        add(chkLaboratoryFee); add(chkStudentCouncil);
        add(chkRegistrationCard); add(chkStudentID);
        add(chkCatalyst); add(chkMisc);
        add(lblScholarship);
        add(rbNonScholar);
        add(rbFullScholar);
        add(rbPartialScholar);
        add(lblTotalAmount); add(txtTotalAmount);
        add(btnCompute);
        add(btnClear);
    }

    public void setToDefault() {
        txtStudentName.setText("");
        txtUnitsEnrolled.setText("");
        dropYearLevel.setSelectedIndex(0);
        chkLaboratoryFee.setSelected(false);
        chkRegistrationCard.setSelected(false);
        chkCatalyst.setSelected(false);
        chkStudentCouncil.setSelected(false);
        chkStudentID.setSelected(false);
        chkMisc.setSelected(false);
        rbNonScholar.setSelected(true);
        txtTotalAmount.setEditable(false);
        txtTotalAmount.setText("");
    }

    public int computeOtherFees() {
        int intTotalFee = 0;

        if (chkLaboratoryFee.isSelected()) intTotalFee += 200;
        if (chkRegistrationCard.isSelected()) intTotalFee += 50;
        if (chkCatalyst.isSelected()) intTotalFee += 50;
        if (chkStudentCouncil.isSelected()) intTotalFee += 50;
        if (chkStudentID.isSelected()) intTotalFee += 50;
        if (chkMisc.isSelected()) intTotalFee += 100;

        return intTotalFee;
    }

    public int computeYearLevelFee() {
        int intYearLevel = dropYearLevel.getSelectedIndex();

        if (intYearLevel == 1) return 100;
        else if (intYearLevel == 2) return 200;
        else if (intYearLevel == 3) return 300;
        else if (intYearLevel == 4) return 400;
        else if (intYearLevel == 5) return 500;
        else return 0;
    }

    public double computeTotalAmount() {
        int intUnitsEnrolled = Integer.parseInt(txtUnitsEnrolled.getText());
        double dblTotalAmount = (intUnitsEnrolled * 10) + computeOtherFees() + computeYearLevelFee();
        return dblTotalAmount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCompute) {
            try {
                if (rbNonScholar.isSelected()) {
                    double dblNonScholarAmount = computeTotalAmount();
                    txtTotalAmount.setText(String.valueOf(dblNonScholarAmount));
                } else if (rbFullScholar.isSelected()) {
                    txtTotalAmount.setText("0");
                } else if (rbPartialScholar.isSelected()) {
                    double dblPartialScholar = (computeTotalAmount()) / 2;
                    txtTotalAmount.setText(String.valueOf(dblPartialScholar));
                }

                if (dropYearLevel.getSelectedIndex() == 0) {;
                    JOptionPane.showMessageDialog(null, "Choose a correct 'Year Level'", "Information", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input a correct positive integer value in 'Units Enrolled'.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == btnClear) setToDefault();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Student());
    }
}
