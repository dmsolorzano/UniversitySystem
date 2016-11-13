import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

/*
	LogIn Class searches a username and password pair in the 
	database and determines if they correspond to an existing user.
	If the pair corresponds to a user, the program extracts the user
	type and calls out the corresponding homepage for that specific 
	user type. 
*/

public class LogIn extends SystemGUI{
	//User userType;
	JFrame frame;
	JLabel userLabel, passwordLabel;
	JPanel panel;
	JTextField userField, passwordField;
	JButton logInButton = new JButton("Log In");

	//LogIn intends to take a userType//
	public LogIn(){
		frame = new JFrame("Log In Page");
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		userLabel = new JLabel("Username ");
		passwordLabel = new JLabel("Password ");
		userField = new JTextField(12);
		passwordField = new JTextField(12);
		createGUI();
	}

	public void createGUI(){

		/* Default Frame Size of program */
		
		frame.setSize(1000,500);
		frame.setLayout(new FlowLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(userLabel);
		panel.add(userField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(logInButton);

		logInButton.addActionListener( new ActionListener()
		{
    		public void actionPerformed(ActionEvent e)
    		{
        		System.out.println("ButtonPressed");
        		frame.getContentPane().removeAll();
        		new HomePage(frame);
    		}
		});

		frame.add(panel);
		frame.setVisible(true);
	}

	public static void main(String[] args){
		LogIn logPage = new LogIn();
	}



}