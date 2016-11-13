import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends SystemGUI{

	JFrame frame;
	JPanel northPanel, centralPanel; // GridBagConstraints
	JButton regButton, checkButton, manageButton, searchButton, teachButton;
	GridBagConstraints gc;

	public HomePage(JFrame frame){
		this.frame = frame;					 //Passing the frame over
		frame.setTitle("University Registration System");
		frame.setSize(1000,500);
		frame.setLayout(new BorderLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Buttons */
		regButton = new JButton("Registration");
		checkButton = new JButton("Check Status");
		manageButton = new JButton("Management");
		searchButton = new JButton("Search Students");
		teachButton = new JButton("Classes I Teach");
		
		/* GUI Sections */

		/* North Panel*/
		northPanel = createHeaderPanel("Home Page");
		/* Central Panel */
		centralPanel = new JPanel(new GridBagLayout());
		
		/*	-----------------------------------------------
			-----------------------------------------------
			    GridBagConstraints for Central Panel
			-----------------------------------------------
			----------------------------------------------- 
		*/

		/* Registration Button Constraints */
		gc = addComponent(0,0,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1, 10,10,10,10);
		centralPanel.add(regButton, gc);
		regButton.addActionListener(new ButtonListener()); //button enabled

		/* Check Status Button Constraints */
		gc = addComponent(1,0,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(checkButton, gc);
		checkButton.addActionListener(new ButtonListener()); //button enabled
		
		/* Management Button Constraints */
		gc = addComponent(0,1,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(manageButton, gc);
		manageButton.addActionListener(new ButtonListener()); //button enabled
		
		/* Search Button Constraints */
		gc = addComponent(1,1,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(searchButton, gc);
		searchButton.addActionListener(new ButtonListener()); //button enabled
		
		/* Classes I Teach Button Constraints */
		gc = addComponent(0,2,2,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(teachButton, gc);
		teachButton.addActionListener(new ButtonListener()); //button enabled

		/*
			-----------------------------------------------
			-----------------------------------------------
			----------------------------------------------- 
		*/	

		/* Putting all panels in frame */
		frame.add("North", northPanel);
		frame.add("Center", centralPanel);
		
		frame.setVisible(true);
	}

	/*	-----------------------------------------------
		-----------------------------------------------
		    Button Action Handler Private Class
		----------------------------------------------- 
		-----------------------------------------------
	*/	

	public class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			frame.getContentPane().removeAll();
			if(e.getSource() == regButton){
				System.out.println("Registration Button Pressed");
        		new RegPage(frame);
			}
			else if(e.getSource() == checkButton){
				System.out.println("Check Status Button Pressed");
        		new CheckPage(frame);
			}
			else if(e.getSource() == searchButton){
				System.out.println("Search Button Pressed");
        		new SearchPage(frame);
			}
			else if(e.getSource() == teachButton){
				System.out.println("Classes I Teach Button Pressed");
        		new ProfPage(frame);
			}
			else if(e.getSource() == manageButton){
				System.out.println("Management Button Pressed");
        		new ManPage(frame);
			}
		}
	}

	/*
		-----------------------------------------------
		-----------------------------------------------
		----------------------------------------------- 
		-----------------------------------------------
	*/


	public static void main(String[] args){
		JFrame frame = new JFrame();
		HomePage homepage = new HomePage(frame);
	}
}