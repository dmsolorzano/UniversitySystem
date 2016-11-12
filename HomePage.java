import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
// import java.util.AWTException;
public class HomePage extends JFrame{
	JPanel headerPanel; // Flowlayout
	JPanel titlePanel; // Flowlayout
	JPanel centralPanel; // GridBagConstraints
	JPanel northPanel; // Contains headerPanel and titlePanel
	// JPanel southPanel; //
	JButton backButton, homeButton, regButton, checkButton,
	manageButton, searchButton, teachButton;
	JLabel uniLabel, nameLabel, idLabel, pageTitle;
	GridBagConstraints gc;
	public HomePage(){
		setTitle("University Registration System");
		setSize(1000,500);
		setLayout(new BorderLayout()); // Frame Layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Buttons */
		backButton = new JButton("BACK");
		homeButton = new JButton("HOME");
		regButton = new JButton("Registration");
		checkButton = new JButton("Check Status");
		manageButton = new JButton("Management");
		searchButton = new JButton("Search Students");
		teachButton = new JButton("Classes I Teach");
		/* Labels */
		uniLabel = new JLabel("The University of Texas at El Paso");
		nameLabel = new JLabel("John Smith ");
		idLabel = new JLabel("80885813 ");
		pageTitle = new JLabel("HOME PAGE");
		/* Create in-panels */
		/* Header Panel*/
		headerPanel = new JPanel(new FlowLayout());
		headerPanel.add(uniLabel);
		headerPanel.add(nameLabel);	
		headerPanel.add(idLabel);
		headerPanel.add(backButton);
		headerPanel.add(homeButton);
		/* Title Panel */
		titlePanel = new JPanel(new FlowLayout());
		titlePanel.add(pageTitle);
		northPanel = new JPanel(new BorderLayout());
		northPanel.add("North",headerPanel);
		northPanel.add("South",titlePanel);
		/* Central Panel */
		centralPanel = new JPanel(new GridBagLayout());
		gc = addComponent(0,0,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1, 10,10,10,10);
		// gc.insets = new Insets(15,15,15,15);
		centralPanel.add(regButton, gc);
		gc = addComponent(1,0,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		// gc.weightx = 1;
		centralPanel.add(checkButton, gc);
		gc = addComponent(0,1,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(manageButton, gc);
		gc = addComponent(1,1,1,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(searchButton, gc);
		gc = addComponent(0,2,2,1, GridBagConstraints.BOTH,
		GridBagConstraints.CENTER,1,1,10,10,10,10);
		centralPanel.add(teachButton, gc);
		/* Putting all panels in frame */
		this.add("North", northPanel);
		this.add("Center", centralPanel);
		// pack();
		setVisible(true);
	}

	public GridBagConstraints addComponent(int gridx, int gridy, int
		gridwidth,int gridheight, int fill, int anchor, int weightx, int
		weighty,int insets1, int insets2, int insets3, int insets4){
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.fill = fill;
		constraints.anchor = anchor;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.insets = new Insets(insets1, insets2, insets3,insets4);
		return constraints;
	}

	public static void main(String[] args){
		HomePage homepage = new HomePage();
	}
}