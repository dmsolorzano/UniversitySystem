package GUI;

//import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import system.Admin;

/*
	LogIn Class searches a username and password pair in the 
	database and determines if they correspond to an existing user.
	If the pair corresponds to a user, the program extracts the user
	type and calls out the corresponding homepage for that specific 
	user type. 
*/

public class LogIn extends SystemGUI{
	JFrame frame;
	private static JPasswordField pass = new JPasswordField(15);
	private static JTextField user = new JTextField(15);
	private JPanel p, center;
	private JButton logInButton, signUpButton;
	private GridBagConstraints gc;
	private static Admin adm = Admin.getInstance();
	private String Username;
	private String Password;
 	
	public LogIn(){
 		
		frame = new JFrame("Login - The University of Texas at El Paso");
		frame.setSize(600,250);
		frame.setLayout(new BorderLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// Create Buttons
		logInButton = new JButton("Login");
		signUpButton = new JButton("Sign Up"); 
		
		// Create central panel with bag constraints initialized
		center = new JPanel();
		center.setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		center.setSize(600, 250);
		titleBorder(center, "Course Registration System"); // Creates a border with title
		
		/* Creates upper panel content */
		p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addToPanel(p, new JLabel("THE UNIVERSITY OF TEXAS AT EL PASO"));
		frame.add(p, BorderLayout.NORTH);	// Adds upper panel to frame 
		
		/* Creates central panel content */
		p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addToPanel(p, new JLabel("USERNAME"));
		addToPanel(p, user);
		Username = user.getName();
		gc = bagConstraints(0,0,1,1,GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1,40,0,0,0);
		center.add(p, gc);
		
		p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addToPanel(p, new JLabel("PASSWORD"));
		addToPanel(p, pass);
		Password = pass.getName();
		gc = bagConstraints(0,1,1,1,GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1,0,0,45,0);
		center.add(p, gc);
		
		frame.add(center, BorderLayout.CENTER);	// Adds center panel to frame
		
		/* Creates lower panel content */
		p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addToPanel(p, logInButton);
		addToPanel(p, new JLabel("		Not A Student?"));
		addToPanel(p, signUpButton);
		frame.add(p, BorderLayout.SOUTH);	// Adds lower panel to frame
		
		frame.setVisible(true); // Sets frame to visible
		
		
		/* ---------------------------------------------------------------
		 * --------- Action Handlers ------------------------------------- 
		 * ---------------------------------------------------------------
		 */
		
		logInButton.addActionListener( new ActionListener()
			{
		   		public void actionPerformed(ActionEvent e)
		   		{
		   			try {
		   				if (correctUsername(Username) == true){
		   					System.out.println("Correct Username");
		   					if (correctPassword(Password) == true){
		   						System.out.println("Correct Password");
		  						frame.getContentPane().removeAll();
				        		new HomePage(frame);
		   					} else {
		   						System.out.println("Incorret Password");
		   						return;
		   					}
		   				} else {
		   					System.out.println("Incorrect Username");
		   					return;
		   				}
		   			} catch (Exception i) {
		   				System.out.println(i);
		   			}
		   		}
			});
		
		signUpButton.addActionListener( new ActionListener()
		{
    		public void actionPerformed(ActionEvent e)
    		{
    			// TODO Work on code here
        		System.out.println("Sign Up Button Pressed");	// TODO Erase sysout

    		}
		});

 	}
 	
 	public static boolean correctUsername(String username) throws Exception {
 		return adm.accessUsername(user.getText());
 	}
 	
 	@SuppressWarnings("deprecation")
	public boolean correctPassword(String password) throws Exception {
 		return adm.accessPassword(pass.getText());
 	}
		
	public static void main(String[] args){
		  SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new LogIn();
	            }
	        });
	}
}
