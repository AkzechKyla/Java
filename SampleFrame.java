import java.awt.*;
import java.awt.event.*;

public class SampleFrame extends Frame implements ActionListener
{
        Label lblName = new Label("Enter your name: ");
        TextField txtName = new TextField(15);
        Button btnClear = new Button("Clear");
        Button btnDisplay = new Button("Display");
        Button btnClose = new Button("Close");

        Label lblNoLabel = new Label();
        Label lblAlignment = new Label("Hello There!", Label.CENTER);

        Font myFont = new Font("SansSerif",Font.BOLD + Font.ITALIC, 16);

        SampleFrame( )  //constructor
        {
	setLayout(new FlowLayout());    //default Layout of a Frame is BorderLayout
	add(lblAlignment);
	add(lblName);     //method to add a component on the frame
	add(txtName);
	add(btnClear);  btnClear.addActionListener(this);
	add(btnDisplay); btnDisplay.addActionListener(this);
	add(btnClose); btnClose.addActionListener(this);
	add(lblNoLabel);

	lblAlignment.setForeground(Color.BLUE);
	lblAlignment.setBackground(Color.YELLOW);
	lblAlignment.setFont(myFont);

	addWindowListener(new WindowAdapter()       //method to close the frame window
	{
	     public void windowClosing(WindowEvent e)
	 	{
			System.exit(0);
		}
	});
        } // end of constructor

        public static void main(String args[])
        {
           SampleFrame sf = new SampleFrame();
	sf.setSize(350,200); 	// setSize(width,height)
	sf.setVisible(true);
        }

        public void actionPerformed(ActionEvent e)
        {
	if (e.getSource()== btnClear)
	{  txtName.setText("");
    lblNoLabel.setText("");
	}
	else if (e.getSource()== btnDisplay)
	{	  String name = txtName.getText();
		  lblNoLabel.setText("Hi There! " + name);
             }
	else
		 System.exit(0);       

          } //end of actionPerformed
} // end of class
