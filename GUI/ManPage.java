package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import GUI.HomePage.ButtonListener;
import system.*;

public class ManPage extends SystemGUI{

	JFrame frame;
	JPanel p, center; // GridBagConstraints
	JButton searchCourseButton, deleteCourseButton, editCourseButton, addCourseButton;
	JComboBox<String> department;
	JTextField courseName, crn;
	JRadioButton alpha, credits, courseNumber;
	ButtonGroup bGroup;
	GridBagConstraints gc;
	JTable searchTable;
	static User user = new User();
	//Course [] courses = user.exportCourses();
	Course[] courses;
    {
        try {
           courses = User.exportCourses();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	
	/*
	 * Arrays for preliminary tests with JTable, two examples
	 */
	String[] columnTitles = new String[]{"Course Number","Course Name","CRN","Credits",
			"Days Offered","Hours","Teacher"};
	Object[][] dataTest = new Object[6][7];/*{ //create some kind of loop to enter the data from courses
		{3331, "Advanced Object Oriented", "27428", 3, "TR", 12.00, "Omar Baddredin"},
		{4246, "Analytical Mechanics II", "24381", 3, "TR", 01.30, "Ramon Ravelo"},
		{courses[0].getCourseName(),courses[1].getCourseName(), "27428", 3, "TR", 12.00, courses[4].getCourseName()},
		{}
	
	};*/
	
	/*
	 * Column type definition for JTable
	 */
	public void instantiate(){
		for(int i = 0; courses[i]!=null; i++){
			dataTest[i][0] = courses[i].getcRN();
			dataTest[i][1] = courses[i].getCourseName();
			dataTest[i][2] = courses[i].getcRN();
			dataTest[i][3] = courses[i].getCourseName();
			dataTest[i][4] = courses[i].getCourseName();
			String date = courses[i].getDate();
			dataTest[i][5] = date;
			dataTest[i][6] = courses[i].getCourseName();
			//dataTest[i][6] = courses[3].getCourseName();
		//	System.out.println("Tiem: "+courses[i].getTime());
				

		}
		// Print test
		for(int j =0; j < dataTest.length; j++){
			for(int k =0; k< dataTest.length; k++){
				System.out.println(dataTest[j][k]);
			}
		}
	}
	public ManPage(){
		//instantiate();
	}
	
	
	final Class[] columnClasses = new Class[]{
	String.class, String.class, String.class, String.class,
			String.class, String.class, String.class
	};
	
	/*
	 * Arrays used for JComboBox's in this GUI
	 */
	final String[] majors = {"","Mathematics","Physics","Computer Science",
			"Psychology","Criminal Justice","Economics"};
	
	

	public ManPage(JFrame frame){
		
		instantiate();
		this.frame = frame;
		frame.setTitle("University Registration System");
		frame.setSize(1000,500);
		frame.setLayout(new BorderLayout()); // Frame Layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* 
		 * Buttons 
		 */
		searchCourseButton = new JButton("Search for Course");
		deleteCourseButton = new JButton("Delete Course");
		editCourseButton = new JButton("Edit Course");
		addCourseButton = new JButton("Add Course");
		
		/*
		 * Button enablers 
		 */
		homeButton.addActionListener(new ButtonListener()); //button enabled
		
		/*
		 *	ComboBox 
		 */
		department = new JComboBox<String>(majors);
		
		/*
		 * JTextFields
		 */
		courseName = new JTextField(15);
		crn = new JTextField(5);
		
		/*
		 * RadioButtons
		 */
		alpha = new JRadioButton("Alphabetical");
		credits = new JRadioButton("Credits");
		courseNumber = new JRadioButton("Course Number");
		bGroup = new ButtonGroup();
		bGroup.add(alpha);
		bGroup.add(credits);
		bGroup.add(courseNumber);
		
		/*
		 * Adding JTABLE MODEL to center panel
		 */
		DefaultTableModel model = new DefaultTableModel(dataTest, columnTitles){
	
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column)
		    {
		        return false;
		    }

		    @Override
		    public Class<?> getColumnClass(int columnIndex)
		    {
		        return columnClasses[columnIndex];
		    }
		};
		
		/*
		 * Initializing JTable with model
		 */
		searchTable = new JTable(model);
		searchTable.setPreferredScrollableViewportSize(new Dimension(500,50));
		searchTable.setFillsViewportHeight(true);
		
		/*
		 * ===============================================================
		 * 		    Creating the Panels and Frame Structure
		 * ===============================================================
		 */
		
		/* Header Panel*/
		p = createHeaderPanel("Management");
		frame.add(p, BorderLayout.NORTH);
		
		/* Central Panel */
		
		center = new JPanel(new GridBagLayout());
		
		/*	-----------------------------------------------
			-----------------------------------------------
			    GridBagConstraints for Central Panel
			-----------------------------------------------
			----------------------------------------------- 
		*/
		
		/*
		 * Adding Search Courses By Section to center panel
		 */
		p = new JPanel(new GridBagLayout()); // Constraints Basis
		gc = bagConstraints(0,0,2,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,0, 5,5,5,5); // Department Label
		p.add(new JLabel("Deparment "), gc); 					
		
		gc.gridx = 2; // Department ComboBox
		p.add(department, gc);
		
		gc.gridx = 4; // Course Name Label
		p.add(new JLabel("Course Name "), gc);					
		
		gc.gridx = 6; // Course Name Text Field
		p.add(courseName, gc);
		
		gc.gridx = 8; // CRN Label
		p.add(new JLabel("CRN "), gc);					
		
		gc.gridx = 10; // CRN Text Field
		p.add(crn, gc);
		
		titleBorder(p, "Search Courses By"); // A titled Border
		 
		gc = bagConstraints(0,0,3,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,0, 0,0,0,0); // Adding to center panel
		center.add(p, gc);
		
		/*
		 * Adding Sort By Section to center panel
		 */
		p = new JPanel(new GridBagLayout()); // Constraints Basis
		gc = bagConstraints(0,0,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,0,0, 5,60,5,60); // Major Label
		p.add(alpha, gc); 					
		
		gc.gridx = 1; // Major JComboBox
		p.add(credits, gc); 
		
		gc.gridx = 2; // College Label
		p.add(courseNumber, gc); 
		
		titleBorder(p, "Sort By");	// A titled Border
		gc = bagConstraints(0,1,2,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,2,0, 0,0,0,0); // Adding to center panel
		center.add(p, gc);	
		
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.insets = new Insets(10,25,5,25);
		center.add(searchCourseButton, gc);
		
		
		/*
		 * Adding the JTable to center panel
		 */
		p = new JPanel(new BorderLayout()); // Re-using p panel
		p.add(new JScrollPane(searchTable), BorderLayout.CENTER);
		titleBorder(p, "Search Results"); // A titled Border
		
		gc = bagConstraints(0,2,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 0,0,0,0); // Last Name Label
		center.add(p, gc); // Added JTable to center panel
		
		/*
		 * Mouse Listener for JTable when double clicking a table element 
		 */
		searchTable.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2) {
		            // your valueChanged overridden method
		        	System.out.println("Doubled Clicked! Check Records");
		        }
		    }
		});
		

		/*
		 * Adding the Add, Edit, Delete Buttons to center panel
		 */
		
		p = new JPanel(new GridBagLayout()); // Constraints Basis
		gc = bagConstraints(0,0,0,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 35,20,25,20); // Add Course Button
		p.add(addCourseButton, gc); 					
		
		gc.gridy = 1; // Edit Course Button
		gc.insets = new Insets(0,20,25,20);
		p.add(editCourseButton, gc);
		
		gc.gridy = 2; // Delete Course Button
		p.add(deleteCourseButton, gc);					
		
		titleBorder(p, "WARNING"); // A titled Border
		 
		gc = bagConstraints(2,2,1,1, GridBagConstraints.BOTH,
				GridBagConstraints.CENTER,1,1, 0,0,0,0); // Adding to center panel
		center.add(p, gc);
		
		/*
			-----------------------------------------------
			-----------------------------------------------
			----------------------------------------------- 
		*/	

		titleBorder(center, "For Adminitrative Use Only");
		frame.add("Center", center);
		frame.setVisible(true);
	}

	/*	-----------------------------------------------
		-----------------------------------------------
		    Button Action Handler Private Class
		----------------------------------------------- 
		-----------------------------------------------
	*/	

	private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == homeButton){
				System.out.println("Registration Button Pressed");
				frame.getContentPane().removeAll();
        		new HomePage(frame);
			}
//			else if(e.getSource() == checkButton){
//				System.out.println("Check Status Button Pressed");
//				frame.getContentPane().removeAll();
//        		new CheckPage(frame);
//			}
//			else if(e.getSource() == searchButton){
//				System.out.println("Search Button Pressed");
//				frame.getContentPane().removeAll();
//        		new SearchPage(frame);
//			}
//			else if(e.getSource() == teachButton){
//				System.out.println("Classes I Teach Button Pressed");
//				frame.getContentPane().removeAll();
//        		new ProfPage(frame);
//			}
//			else if(e.getSource() == manageButton){
//				System.out.println("Management Button Pressed");
//				frame.getContentPane().removeAll();
//        		new ManPage(frame);
//			}
		}
	}

	/*
		-----------------------------------------------
		-----------------------------------------------
		----------------------------------------------- 
		-----------------------------------------------
	*/
	
	public static void main(String[] args) throws Exception{
		
		ManPage test = new ManPage();
		//test.courses = User.exportCourses();
		//test.instantiate();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManPage(new JFrame());
            }
        });
	}
}