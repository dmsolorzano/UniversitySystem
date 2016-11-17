
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
public class SystemGUI{
	public SystemGUI(){
		JFrame mainFrame = new JFrame();
		User user;

		//static int counter;				//Keeps track of frame
	}

	/**
		Manages constraints used by subclasses that implement 
		GridBagLayouts.  
		@author Reynaldo Martinez Jr
		@version 1.0
		@date \today
		@param
		@param
		@param
		@param
		@param
		@param
		@param
		@param
		@param
		@param
		@param
		@return constrainst The constraints used by a GridBagLayout
	*/
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

	/**
		Creates the default header for most frames in the system  
		@author Reynaldo Martinez Jr
		@version 1.0
		@date \today
		@param 
		@return northPanel 
	*/
	public JPanel createHeaderPanel(String title){
		
		JPanel northPanel = new JPanel(new BorderLayout());
		/* Create "in-panels" */
		JPanel headerPanel = new JPanel(new FlowLayout());
		JPanel titlePanel = new JPanel(new FlowLayout());
		
		JLabel uniLabel = new JLabel("The University of Texas at El Paso");
		JLabel pageTitle = new JLabel(title);
		JLabel nameLabel = new JLabel("John Smith ");
		JLabel idLabel = new JLabel("80885813");
		JButton backButton = new JButton("BACK");
		JButton homeButton = new JButton("HOME");

		/* Header Panel*/
		headerPanel.add(uniLabel);
		headerPanel.add(nameLabel);	
		headerPanel.add(idLabel);
		headerPanel.add(backButton);
		headerPanel.add(homeButton);
		
		/* Title Panel */
		titlePanel.add(pageTitle);

		/* North Panel - to be returned */
		northPanel.add("North",headerPanel);
		northPanel.add("South",titlePanel);

		return northPanel;
	}
}