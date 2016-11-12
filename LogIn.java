import javax.swing.*;
import java.awt.*;

/**
	LogIn Class searches a username and password pair in the 
	database and determines if they correspond to an existing user.
	If the pair corresponds to a user, the program extracts the user
	type and calls out the corresponding homepage for that specific 
	user type. 
*/

public class LogIn extends JFrame{
	//User userType;

	JButton logInButton = new JButton("Log In");

	//LogIn intends to take a userType//
	public LogIn(){
		//this.userType = userType;
		createGUI();
	}

	public void createGUI(){
		setLayout(new FlowLayout());
		setSize(500,500);
		add(logInButton);
		setVisible(true);
	}

	public static void main(String[] args){
		LogIn logPage = new LogIn();
	}
}